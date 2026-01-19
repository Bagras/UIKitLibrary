package com.example.uikit.components.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorDescription
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorWhite

@Composable
fun ChipsButton(index: Int, item: String, groupList: MutableList<String>) {
    var groupChoiceNum by remember { mutableIntStateOf(0) }
    Button(
        onClick = {},
        modifier = Modifier
            .padding(end = 16.dp)
            .clickable {
                groupChoiceNum = index
            },
        colors = ButtonDefaults.buttonColors(
            contentColor = if (groupChoiceNum == index) Color.White else ColorDescription,
            backgroundColor = if (groupChoiceNum == index) ColorAccent else ColorInputBG,
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            item,
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 14.dp)
        )
    }
}