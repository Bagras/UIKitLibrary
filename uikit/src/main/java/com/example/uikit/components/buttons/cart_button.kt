package com.example.uikit.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorAccentInactive
import com.example.uikit.theme.ColorWhite

@Composable
fun CartButton(price: Int, buttonClick: () -> Unit) {
    var buttonEnabled by remember { mutableStateOf(true) }
    Button(onClick = {
    buttonClick
    },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
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
        Row(Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row (Modifier.fillMaxHeight()){
                Icon(painter = painterResource(R.drawable.icon_shopping_cart,), contentDescription = null)
                Spacer(Modifier.width(16.dp))
                Text("В корзину", fontSize = 17.sp)
            }
            Text("$price ₽", fontSize = 17.sp)
        }
    }
}