package com.example.uikit.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ColorInputStroke

@Composable
fun LoginButtons(aaa: Aaaa){

    Column(
        Modifier.fillMaxWidth()
    ) {
            Button(onClick = {

            },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    ,
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, ColorInputStroke)
            ) {
                Row(Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(painter = painterResource(aaa.icon), null)
                    Spacer(Modifier.width(16.dp))
                    Text(aaa.name, fontSize = 14.sp)
                }
            }
        }
    }

data class Aaaa(
    val name: String,
    val icon: Int
)
