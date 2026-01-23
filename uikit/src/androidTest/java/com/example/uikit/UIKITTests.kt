package com.example.uikit

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uikit.components.inputs.BackgroundColorError
import com.example.uikit.components.inputs.BorderErrorColor
import com.example.uikit.components.inputs.TextErrorColor
import com.example.uikit.components.inputs.UserEmailInput
import com.example.uikit.components.selects.Select
import com.example.uikit.theme.ColorError
import kotlinx.coroutines.launch
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
    fun userEmailInputErrorTest(){
        composeTestRule.setContent {
            UserEmailInput("Введите емаил", "invalid", {})

        }

        composeTestRule.onNodeWithTag("EmailInput", useUnmergedTree = true)
            .assertIsDisplayed()
            .assert(SemanticsMatcher.expectValue(BackgroundColorError, ColorError.copy(alpha = 0.1f)))
            .assert(SemanticsMatcher.expectValue(BorderErrorColor, ColorError))

        composeTestRule.onNodeWithTag("ErrorText")
            .assertIsDisplayed()
            .assert(SemanticsMatcher.expectValue(
            TextErrorColor, ColorError
        ))
    }

    @Test
    fun selectOpnBottomSheet(){
        composeTestRule.setContent {
            val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true)
            val scope = rememberCoroutineScope()
            ModalBottomSheetLayout(
                sheetState = sheetState,
                sheetContent = {
                    Column(Modifier.fillMaxSize().testTag("BottomSheet")) {
                    }
                })
            {
                Column(Modifier.fillMaxSize()) {
                    Select("", {}, "Алеша", true, sheetState, {scope.launch { sheetState.show() }})
                }

            }
        }

        composeTestRule
            .onNodeWithTag("Select")
            .performClick()

        composeTestRule.waitUntil(10_000) {
            runCatching {
                composeTestRule
                    .onAllNodesWithTag("BottomSheet")
                    .fetchSemanticsNodes()
                    .isNotEmpty()
            }.getOrDefault(false)
        }

        composeTestRule
            .onAllNodesWithTag("BottomSheet")
            .printToLog("BOTTOM_SHEET")


        composeTestRule
            .onNodeWithTag("BottomSheet")
            .assertIsDisplayed()
    }


}