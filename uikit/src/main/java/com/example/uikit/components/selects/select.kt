package com.example.uikit.components.selects

import android.adservices.adselection.TestAdSelectionManager
import android.hardware.biometrics.BiometricManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorDescription
import com.example.uikit.theme.ColorDivider
import com.example.uikit.theme.ColorError
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke
import com.example.uikit.theme.ColorWhite
import com.example.uikit.theme.CustomTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun Select(
    sheetState: ModalBottomSheetState,
    bottomSheetText: String,
    placeholderText: String,
    isRegister: Boolean,
    title: String,
    isTest: Boolean = false
) {

    val scope = rememberCoroutineScope()
    if (isRegister){
        null
    } else {
        Text(title, style = CustomTypography.caption_regular, color = ColorDescription)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                scope.launch { sheetState.show() }
            }
            .testTag("Select"),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorInputBG,
        ),
        border = BorderStroke(1.dp, ColorInputStroke)
    ) {
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .padding(start = 14.dp), contentAlignment = Alignment.Center
            ) {
                Text(
                    if (bottomSheetText.isEmpty()) placeholderText else bottomSheetText,
                    color = if (bottomSheetText.isEmpty()) ColorCaption else ColorBlack
                )
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .padding(end = 14.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                if (isTest) {

                } else {
                    Icon(
                        painter = painterResource(R.drawable.icon_chevron_down),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.clickable {
                            scope.launch { sheetState.show() }
                        }
                    )
                }
            }
        }
    }
    Spacer(Modifier.height(16.dp))
}




