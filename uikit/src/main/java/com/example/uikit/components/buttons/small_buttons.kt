package com.example.uikit.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorWhite
val buttonBackgroundColorAdd = SemanticsPropertyKey<Color>("backgroundColorAdd")
var SemanticsPropertyReceiver.backgroundColorAdd by buttonBackgroundColorAdd

val buttonContentColorAdd = SemanticsPropertyKey<Color>("contentColorAdd")
var SemanticsPropertyReceiver.contentColorAdd by buttonContentColorAdd

val buttonBackgroundColorDelete = SemanticsPropertyKey<Color>("backgroundColorDelete")
var SemanticsPropertyReceiver.backgroundColorDelete by buttonBackgroundColorDelete

val buttonContentColorDelete = SemanticsPropertyKey<Color>("contentColorDelete")
var SemanticsPropertyReceiver.contentColorDelete by buttonContentColorDelete

val buttonTextAdd = SemanticsPropertyKey<String>("textAdd")
var SemanticsPropertyReceiver.textAdd by buttonTextAdd

val buttonTextDelete = SemanticsPropertyKey<String>("textDelete")
var SemanticsPropertyReceiver.textDelete by buttonTextDelete
@Composable
fun SmallButtons(buttonClickable: () -> Unit) {
    var buttonClick by remember { mutableStateOf(true) }
    Button(
        onClick = {
            buttonClickable()
            buttonClick = !buttonClick
        },
        modifier = Modifier
            .height(48.dp)
            .width(105.dp)
            .testTag("PrimaryButton")
            .semantics{
                buttonBackgroundColorAdd
                backgroundColorAdd = ColorAccent

                buttonBackgroundColorDelete
                backgroundColorDelete = ColorWhite

                buttonContentColorAdd
                contentColorAdd = ColorWhite

                buttonContentColorDelete
                contentColorDelete = ColorAccent

                buttonTextAdd
                textAdd = "Добавить"

                buttonTextDelete
                textDelete = "Убрать"
            },
        colors = if (buttonClick) {
            ButtonDefaults.buttonColors(
                contentColor = ColorWhite,
                backgroundColor = ColorAccent,
            )
        } else {
            ButtonDefaults.buttonColors(
                contentColor = ColorAccent,
                backgroundColor = ColorWhite
            )
        },
        border = BorderStroke(1.dp, ColorAccent),
        shape = RoundedCornerShape(10.dp)
    ) {
        if (buttonClick){
            Text("Добавить", fontSize = 14.sp)
        } else {
            Text("Убрать", fontSize = 14.sp)
        }

    }
}
