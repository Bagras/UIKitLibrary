package com.example.uikit.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorError
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke

@Composable
fun UserPasswordInput(placeholderText: String) {
    var passwordInput by remember { mutableStateOf("") }
    var passwordVisual by remember { mutableStateOf(true) }
    OutlinedTextField(
        value = passwordInput,
        onValueChange = {
            passwordInput = it
        },
        modifier = Modifier.fillMaxWidth().height(48.dp),
        placeholder = { Text(placeholderText, fontSize = 14.sp) },
        trailingIcon = { Box(Modifier
            .size(20.dp)
            .clickable {
                passwordVisual = !passwordVisual
            }) {
            if (passwordVisual) {
                Icon(
                    painter = painterResource(R.drawable.icon_eye_on), contentDescription = null,
                )
            } else {
                Icon(painter = painterResource(R.drawable.icon_eye_off), contentDescription = null)
            }
        }
        },
        visualTransformation = if (passwordVisual) PasswordVisualTransformation() else VisualTransformation.None,
        maxLines = 1,
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
        ),
    )
}