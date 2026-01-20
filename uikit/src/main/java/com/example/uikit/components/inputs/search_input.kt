package com.example.uikit.components.inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorCaption
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputStroke
import com.example.uikit.theme.ColorWhite


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInput(searchText: String, searchTextChange: (String) -> Unit) {

    var expanted by remember { mutableStateOf(false) }
    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = searchText.toString(),
                onQueryChange = searchTextChange,
                onSearch = {},
                expanded = expanted,
                onExpandedChange = { expanted = it },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = ColorBlack,
                    focusedContainerColor = ColorInputBG,
                    focusedIndicatorColor = ColorAccent,
                    focusedPlaceholderColor = ColorCaption,
                    focusedTrailingIconColor = Color.Unspecified,
                    focusedLeadingIconColor = Color.Unspecified,
                    unfocusedTextColor = ColorBlack,
                    unfocusedContainerColor = ColorInputBG,
                    unfocusedPlaceholderColor = ColorCaption,
                    unfocusedLeadingIconColor = Color.Unspecified,
                    unfocusedTrailingIconColor = Color.Unspecified,
                ),
                placeholder = { Text("Искать описание", fontSize = 16.sp) },
                trailingIcon = {
                    if (expanted) Icon(
                        painter = painterResource(R.drawable.icon_close),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            expanted = false
                        })
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.icon_search),
                        contentDescription = null
                    )
                },

                )
        },
        expanded = expanted,
        onExpandedChange = {
            expanted = it
        },
        modifier = Modifier.fillMaxWidth(),
        colors = SearchBarDefaults.colors(
            containerColor = ColorInputBG
        ),
        shape = RoundedCornerShape(10.dp)


    ) {

    }
}

@Composable
fun Test(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    Column(Modifier
        .fillMaxSize()
        .background(ColorWhite)) {
        SearchInput(searchText = searchText, searchTextChange = {
            searchText = it
        })
    }

}


@Preview
@Composable
private fun Prev() {
    Test()
}