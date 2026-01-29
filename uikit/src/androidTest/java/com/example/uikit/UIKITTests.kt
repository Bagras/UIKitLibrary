package com.example.uikit

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uikit.components.buttons.ChipsButton
import com.example.uikit.components.buttons.buttonBackgroundColorAdd
import com.example.uikit.components.buttons.buttonBackgroundColorDelete
import com.example.uikit.components.buttons.buttonContentColorAdd
import com.example.uikit.components.buttons.buttonContentColorDelete
import com.example.uikit.components.buttons.buttonTextAdd
import com.example.uikit.components.buttons.buttonTextDelete
import com.example.uikit.components.buttons.chipBackgroundColorOff
import com.example.uikit.components.buttons.chipBackgroundColorOn
import com.example.uikit.components.buttons.chipContentColorOff
import com.example.uikit.components.buttons.chipContentColorOn
import com.example.uikit.components.cards.PrimaryCard
import com.example.uikit.components.inputs.BackgroundColorError
import com.example.uikit.components.inputs.BorderErrorColor
import com.example.uikit.components.inputs.TextErrorColor
import com.example.uikit.components.inputs.UserEmailInput
import com.example.uikit.components.modal_window.ModalWindowSelect
import com.example.uikit.components.selects.Select
import com.example.uikit.components.tabbar.Tabbar
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorDescription
import com.example.uikit.theme.ColorError
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorWhite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)
class UIKITTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @SuppressLint("CheckResult")
    @Test
    fun userEmailInputErrorTest() {
        composeTestRule.setContent {
            UserEmailInput("Введите емаил", "invalid", {})

        }

        composeTestRule.onNodeWithTag("EmailInput", useUnmergedTree = true)
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(
                    BackgroundColorError,
                    ColorError.copy(alpha = 0.1f)
                )
            )
            .assert(SemanticsMatcher.expectValue(BorderErrorColor, ColorError))

        composeTestRule.onNodeWithTag("ErrorText")
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(
                    TextErrorColor, ColorError
                )
            )
    }


@Test
fun selectTest(){
    composeTestRule.setContent {
        val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val scope = rememberCoroutineScope()
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                ModalWindowSelect({}, sheetState)
            },
            ) {
            Select(sheetState, "", true, isTest = true)
        }

    }

    composeTestRule.onNodeWithTag("Select").assertIsDisplayed().performClick()

    composeTestRule.onNodeWithTag("BottomSheet").assertIsDisplayed()
}


    @Test
    fun chipButtonTest() {
        composeTestRule.setContent {
            val groupList = mutableListOf("Chip 1", "Chip 2")
            ChipsButton(0, "Chip 1", groupList)
            ChipsButton(1, "Chip 2", groupList)
        }


        composeTestRule.onNodeWithText("Chip 1")
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(chipBackgroundColorOn, ColorAccent)
            )
            .assert(SemanticsMatcher.expectValue(chipContentColorOn, ColorWhite))


        composeTestRule.onNodeWithText("Chip 2")
            .assertIsDisplayed()
            .assert(SemanticsMatcher.expectValue(chipBackgroundColorOff, ColorInputBG))
            .assert(SemanticsMatcher.expectValue(chipContentColorOff, ColorDescription))

    }

    @Test
    fun primaryCardTest(){
        composeTestRule.setContent {
            PrimaryCard("", "", 0, rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden))
        }

        composeTestRule.onNodeWithTag("PrimaryCard").assertIsDisplayed()

        composeTestRule.onNodeWithTag("PrimaryButton")
            .assert(SemanticsMatcher.expectValue(buttonBackgroundColorAdd, ColorAccent))
            .assert(SemanticsMatcher.expectValue(buttonContentColorAdd, ColorWhite))
            .assert(SemanticsMatcher.expectValue(buttonTextAdd, "Добавить"))
            .performClick()
            .assert(SemanticsMatcher.expectValue(buttonBackgroundColorDelete, ColorWhite))
            .assert(SemanticsMatcher.expectValue(buttonContentColorDelete, ColorAccent))
            .assert(SemanticsMatcher.expectValue(buttonTextDelete, "Убрать"))
    }

    @Test
    fun tabbarTest() {

        composeTestRule.setContent {
            Tabbar(destinationNumber = 0, navController = rememberNavController(), isTest = true)
        }

        composeTestRule.onNodeWithTag("tab_0").assertIsSelected()
        composeTestRule.onNodeWithTag("tab_1").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_2").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_3").assertIsNotSelected()

        composeTestRule.onNodeWithTag("tab_1").performClick()

        composeTestRule.onNodeWithTag("tab_0").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_1").assertIsSelected()
        composeTestRule.onNodeWithTag("tab_2").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_3").assertIsNotSelected()

        composeTestRule.onNodeWithTag("tab_2").performClick()

        composeTestRule.onNodeWithTag("tab_0").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_1").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_2").assertIsSelected()
        composeTestRule.onNodeWithTag("tab_3").assertIsNotSelected()

        composeTestRule.onNodeWithTag("tab_3").performClick()

        composeTestRule.onNodeWithTag("tab_0").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_1").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_2").assertIsNotSelected()
        composeTestRule.onNodeWithTag("tab_3").assertIsSelected()






    }
}