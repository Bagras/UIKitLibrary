package com.example.uikit.components.tabbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorInputBG
import com.example.uikit.theme.ColorInputIcon
import com.google.android.material.snackbar.BaseTransientBottomBar

@Composable
fun Tabbar(destinationNumber: Int, navController: NavController, isTest: Boolean = false) {
    var selectedDestination by remember { mutableIntStateOf(destinationNumber) }
    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets,
        containerColor = ColorInputBG,
    ) {
        Destination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedDestination == index,
                onClick = {
                    if (isTest) null else navController.navigate(route = destination.route)
                    selectedDestination = if (isTest) index else destinationNumber
                },
                icon = {
                    Icon(
                        painter = painterResource(destination.icon),
                        contentDescription = destination.contentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(destination.label) },
                colors = NavigationBarItemColors(
                    selectedIconColor = ColorAccent,
                    selectedTextColor = ColorAccent,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = ColorInputIcon,
                    unselectedTextColor = ColorInputIcon,
                    disabledIconColor = Color.Transparent,
                    disabledTextColor = Color.Transparent
                ),
                modifier = Modifier.testTag("tab_$index")

            )
        }
    }

}


@Preview
@Composable
private fun Aaaaaa() {
    Tabbar(navController = rememberNavController(), destinationNumber = 0)
}


enum class Destination(
    val route: String,
    val label: String,
    val icon: Int,
    val contentDescription: String
) {
    HOME("Home", "Главная", R.drawable.icon_home, "Home"),
    CATALOG("Catalog", "Каталог", R.drawable.icon_catalog, "Catalog"),
    PROJECT("Project", "`Проект", R.drawable.icon_project, "Project"),
    PROFILE("Profile", "Профиль", R.drawable.icon_profile, "Profile")
}