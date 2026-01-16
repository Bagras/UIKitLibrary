package com.example.uikit.components.menu_categories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uikit.components.buttons.ChipsButton

@Composable
fun GroupDescription(modifier: Modifier = Modifier, groupList: MutableList<String>,) {
    val groupList = mutableListOf<String>("Все", "Женщинам", "Мужчинам", "Детям", "Аксессуары")
    groupList.forEachIndexed { index, item ->
        ChipsButton(index = index, item = item, groupList = groupList)
    }
}