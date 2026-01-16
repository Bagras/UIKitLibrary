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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorWhite

@Composable
fun SmallButtons(modifier: Modifier = Modifier) {
    var buttonClick by remember { mutableStateOf(true) }
    Button(
        onClick = {
        buttonClick = !buttonClick
        },
        modifier = Modifier
            .height(48.dp)
            .width(105.dp),
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

@Preview
@Composable
private fun Aaaaa() {
    SmallButtons()
}