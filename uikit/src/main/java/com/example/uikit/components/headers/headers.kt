package com.example.uikit.components.headers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.components.bubbles.BubbleBack
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorWhite

@Composable
fun Header1(clearCartButton: () -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(84.dp)
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            BubbleBack(navController = rememberNavController())
        }
        Box(
            Modifier
                .fillMaxSize()
                .padding(11.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_delete),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.clickable{
                    clearCartButton
                }
            )
        }
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            Text("Корзина", fontSize = 24.sp, color = ColorBlack)

        }
    }
}


@Composable
fun Header2(clearCartButton: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BubbleBack(navController = rememberNavController())
        Box(
            Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text("Корзина", fontSize = 20.sp, color = ColorBlack)

        }
        Box(
            Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_delete),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.clickable{
                    clearCartButton
                }
            )
        }
    }
}


@Preview
@Composable
private fun Preview() {
    Header2 {}
}