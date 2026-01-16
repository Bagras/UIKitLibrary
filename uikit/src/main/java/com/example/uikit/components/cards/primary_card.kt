package com.example.uikit.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.components.buttons.Aaaa
import com.example.uikit.components.buttons.SmallButtons
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorDivider
import com.example.uikit.theme.ColorWhite

@Composable
fun PrimaryCard(modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(136.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, ColorDivider),
        colors = CardDefaults.cardColors(
            containerColor = ColorWhite
        )
    ) {
       Box(Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center){

       }
    }
}

@Preview
@Composable
private fun Aaa() {
    PrimaryCard()
}