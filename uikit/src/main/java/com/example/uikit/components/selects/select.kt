package com.example.uikit.components.selects

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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
fun Select(selectInput: String, selectInputChance: (String) -> Unit, placeholderText: String) {
    OutlinedTextField(
        value = selectInput,
        onValueChange = selectInputChance,
        modifier = Modifier.fillMaxWidth().height(48.dp),
        readOnly = true,
        placeholder = { Text(placeholderText, fontSize = 16.sp, color = ColorCaption) },
        trailingIcon = {
            Icon(painter = painterResource(R.drawable.icon_chevron_down), contentDescription = null, tint = Color.Unspecified, modifier = Modifier.clickable {

            })
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = ColorAccent,
            focusedTextColor = ColorBlack,
            focusedContainerColor = ColorInputBG,
            focusedPlaceholderColor = ColorCaption,
            focusedLabelColor = ColorCaption,
            unfocusedTextColor = ColorBlack,
            unfocusedBorderColor = ColorInputStroke,
            unfocusedPlaceholderColor = ColorCaption,
            unfocusedContainerColor = ColorInputBG,
            unfocusedLabelColor = ColorCaption,
            errorBorderColor = ColorError,
            errorTextColor = ColorBlack,
            errorCursorColor = Color.Transparent,
            errorContainerColor = ColorError,
            errorPlaceholderColor = ColorCaption,
            errorLabelColor = ColorCaption
        ),
        shape = RoundedCornerShape(10.dp)
    )
}



@Preview
@Composable
private fun Preview() {

}