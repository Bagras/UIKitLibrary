package com.example.uikit.components.inputs

import android.R.attr.textColor
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorDescription
import com.example.uikit.theme.ColorError
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke
import com.example.uikit.theme.CustomTypography

val TextErrorColor = SemanticsPropertyKey<Color>("TextColor")
var SemanticsPropertyReceiver.textColor by TextErrorColor

val BackgroundColorError = SemanticsPropertyKey<Color>("BackgroundColor")
var SemanticsPropertyReceiver.backgroundColor by BackgroundColorError

val BorderErrorColor = SemanticsPropertyKey<Color>("BorderColor")
var SemanticsPropertyReceiver.borderColor by BorderErrorColor


@Composable
fun UserEmailInput(placeholderText: String, inputText: String, inputTextChance: (String) -> Unit, titleText: String, isRegister: Boolean = false) {

    val emailError = if (inputText.isNotEmpty()){
        !android.util.Patterns.EMAIL_ADDRESS.matcher(inputText).matches()
    } else {
        false
    }

    if (isRegister){
        null
    } else{
        Text(titleText, style = CustomTypography.caption_regular, color = ColorDescription)
        Spacer(Modifier.height(4.dp))
    }

    OutlinedTextField(
        value = inputText,
        onValueChange = inputTextChance,
        modifier = Modifier.fillMaxWidth().height(48.dp).testTag("EmailInput").semantics{
            BackgroundColorError
            backgroundColor = ColorError.copy(alpha = 0.1f)
            BorderErrorColor
            borderColor = ColorError
        },
        placeholder = { Text(placeholderText, color = ColorCaption) },
        isError = emailError,
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
            errorContainerColor = ColorError.copy(alpha = 0.1f),
            errorPlaceholderColor = ColorCaption,
        ),
        maxLines = 1
    )
    if (emailError){
        Spacer(Modifier.height(8.dp))
        Text("Введите свой email", fontSize = 14.sp, color = ColorError, modifier = Modifier.testTag("ErrorText").semantics{
            textColor = ColorError
        })
    }
    Spacer(Modifier.height(16.dp))
}