package com.example.uikit.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.components.buttons.SmallButtons
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorDivider
import com.example.uikit.theme.ColorWhite
import com.example.uikit.theme.CustomTypography
import kotlinx.coroutines.launch

@Composable
fun PrimaryCard(cardName: String, cardCategories: String, cardPrice: Int, sheetState: ModalBottomSheetState) {
    val scope = rememberCoroutineScope()
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(136.dp)
        .testTag("PrimaryCard"),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, ColorDivider),
        colors = CardDefaults.cardColors(
            containerColor = ColorWhite
        )
    ) {
       Box(Modifier
           .fillMaxSize()
           .padding(16.dp)){
           Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
               SmallButtons()
           }
           Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart){
               Text(cardName, style = CustomTypography.headline_medium, modifier = Modifier.clickable{
                    scope.launch { sheetState.show() }
               })
           }
           Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart){
               Column() {
                   Text(cardCategories, style = CustomTypography.caption_semibold, color = ColorCaption)
                   Spacer(Modifier.height(4.dp))
                   Text("$cardPrice ₽", style = CustomTypography.title_3_semibold)
               }
           }
       }
    }
}

@Composable
fun TestApp(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().padding(horizontal = 20.dp)) {
        PrimaryCard("Рубашка Воскресенье для машинного вязания", "Мужская одежда", 300,
            rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        )
    }
}

@Preview
@Composable
private fun Aaa() {
TestApp()
}