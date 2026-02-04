package com.example.uikit.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorAccentInactive
import com.example.uikit.theme.ColorWhite

@Composable
fun BigButtons(buttonText: String, buttonClick: () -> Unit) {
    var buttonEnabled by remember { mutableStateOf(true) }
    Button(onClick = {
    buttonClick
    },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(10.dp),
        enabled = buttonEnabled,
        colors = if (buttonEnabled){
            ButtonDefaults.buttonColors(
                backgroundColor = ColorAccent,
                contentColor = ColorWhite
            )
        } else {
            ButtonDefaults.buttonColors(
                backgroundColor = ColorAccentInactive,
                contentColor = ColorWhite
            )
        }
        ) {
        Text(buttonText, fontSize = 17.sp)
    }
}