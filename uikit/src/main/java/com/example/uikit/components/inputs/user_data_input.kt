package com.example.uikit.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorError
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke

@Composable
fun UserDataInput(placeholderText: String) {
    var inputType by remember { mutableStateOf("") }
    OutlinedTextField(
        value = inputType,
        onValueChange = {
            inputType = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        placeholder = { Text(placeholderText, fontSize = 14.sp) },
        isError = false,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = ColorAccent,
            focusedTextColor = ColorBlack,
            focusedContainerColor = ColorInputBG,
            focusedPlaceholderColor = ColorCaption,
            unfocusedTextColor = ColorBlack,
            unfocusedBorderColor = ColorInputStroke,
            unfocusedPlaceholderColor = ColorCaption,
            unfocusedContainerColor = ColorInputBG,
            errorBorderColor = ColorError,
            errorTextColor = ColorBlack,
            errorCursorColor = Color.Transparent,
            errorContainerColor = ColorError,
            errorPlaceholderColor = ColorCaption,
        )
    )
}