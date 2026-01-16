package com.example.uikit.components.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke

@Composable
fun Counter(modifier: Modifier = Modifier) {
    Row(
        Modifier
            .height(32.dp)
            .border(width = 1.dp, color = ColorInputBG, shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clickable{

                },
            colors = CardDefaults.cardColors(ColorInputBG),
            shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp),
        ) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Icon(
                    painter = painterResource(R.drawable.icon_minus),
                    contentDescription = null,
                    modifier = Modifier.width(20.dp),
                    tint = Color.Black
                )
            }

        }
        Box(
            Modifier
                .background(ColorInputBG)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            VerticalDivider(modifier.height(16.dp), thickness = 1.dp, color = ColorInputStroke)
        }

        Card(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clickable{

                },
            colors = CardDefaults.cardColors(ColorInputBG),
            shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
        ) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
               Icon(
                    painter = painterResource(R.drawable.icon_plus),
                    contentDescription = null,
                    modifier = Modifier.width(20.dp),
                    tint = Color.Black
                )
            }
        }
    }
}