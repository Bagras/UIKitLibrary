package com.example.uikit.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uikit.components.tabbar.Destination

@Composable
fun Main(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val destination: Destination
    NavHost(
        navController,
        startDestination = "Profile"
    ) {
        Destination.entries.forEach { destination ->
            composable(route = destination.route) {
                when (destination) {
                    Destination.HOME -> HomeScreen(navController = navController)
                    Destination.CATALOG -> CatalogScreen(navController = navController)
                    Destination.PROJECT -> ProjectScreen(navController = navController)
                    Destination.PROFILE -> ProfileScreen(navController = navController)
                }
            }
        }
    }
}