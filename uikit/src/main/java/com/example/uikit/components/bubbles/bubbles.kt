package com.example.uikit.components.bubbles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorInputBG

@Composable
fun BubbleBack(modifier: Modifier = Modifier, navController: NavController) {
    Card(
         modifier
             .size(32.dp)
             .clickable {
                 navController.popBackStack()
             },
         colors = CardDefaults.cardColors(
            containerColor = ColorInputBG,
             contentColor = Color.Unspecified
         ),
         shape = RoundedCornerShape(8.dp)
     ) {
         Box(Modifier.fillMaxSize(),
             contentAlignment = Alignment.Center){
             Icon(painter = painterResource(R.drawable.icon_chevron_left), contentDescription = null, tint = Color.Unspecified)
         }
     }
}


@Composable
fun BubbleFilter(modifier: Modifier = Modifier) {
    Card(
        modifier
            .size(48.dp)
            .clickable {

            },
        colors = CardDefaults.cardColors(
            containerColor = ColorInputBG,
            contentColor = Color.Unspecified
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Icon(painter = painterResource(R.drawable.icon_filter), contentDescription = null, tint = Color.Unspecified)
        }
    }
}

@Preview
@Composable
private fun Aaaaa() {
    BubbleFilter()
}