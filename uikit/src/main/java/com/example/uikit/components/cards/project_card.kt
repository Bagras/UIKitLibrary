package com.example.uikit.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.components.buttons.SmallButtons
import com.example.uikit.components.controls.Counter
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorDivider
import com.example.uikit.theme.ColorWhite

@Composable
fun ProjectCard(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Card(
            modifier = Modifier
                .height(135.dp)
                .fillMaxWidth(),

            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(ColorWhite),
            border = BorderStroke(1.dp, ColorDivider)
        ) {
            Box(Modifier
                .fillMaxSize()
                .padding(all = 16.dp)) {
                Box(Modifier.fillMaxSize()){
                    Text("Мой первый проект", fontSize = 16.sp, color = ColorBlack)
                }
                Box(Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomStart){
                    Text("Прошло 2 дня", fontSize = 14.sp, color = ColorCaption)
                }
                Box(Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd){
                    SmallButtons()
                }
            }
        }
    }

}

@Preview
@Composable
private fun Aaaaa() {
    ProjectCard()
}