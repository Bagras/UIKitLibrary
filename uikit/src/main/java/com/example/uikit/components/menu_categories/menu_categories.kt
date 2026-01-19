package com.example.uikit.components.menu_categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.components.buttons.ChipsButton

@Composable
fun GroupDescription(modifier: Modifier = Modifier) {
    val groupList = mutableListOf<String>("Все", "Женщинам", "Мужчинам", "Детям", "Аксессуары")
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            groupList.forEachIndexed { index, item ->
                ChipsButton(index = index, item = item, groupList = groupList)
            }
        }
    }

}


