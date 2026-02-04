package com.example.uikit.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.components.controls.Counter
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorDivider
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke
import com.example.uikit.theme.ColorWhite
import com.example.uikit.theme.CustomTypography

@Composable
fun CartCard(title: String, price: Int, quantity: Int, cartDeleteButton: () -> Unit) {

    var quantityChange by remember { mutableIntStateOf(quantity) }
    Card(
        modifier = Modifier
            .height(138.dp)
            .fillMaxWidth(),

        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(ColorWhite),
        border = BorderStroke(1.dp, ColorDivider)
    ) {
        Box(Modifier
            .fillMaxSize()
            .padding(all = 16.dp)) {
            Text(
                title,
                style = CustomTypography.headline_medium,
                color = ColorBlack,
                modifier = Modifier.padding(end = 60.dp)

            )
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 4.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    "$price ₽",
                    fontSize = 17.sp,
                    color = ColorBlack,
                )
            }


            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Row(
                    modifier = Modifier
                        .padding()
                        .width(150.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("$quantity штук", fontSize = 15.sp, color = ColorBlack)
                    Counter(updateQuantityPlus = {++quantityChange}, updateQuantityMinus = {--quantityChange})
                }
            }
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_close),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.clickable {
                        cartDeleteButton

                    })
            }

        }


    }

}


@Preview
@Composable
private fun Aaaaa() {
    CartCard("Рубашка Воскресенье для машинного вязания", 300, 1, {})
}