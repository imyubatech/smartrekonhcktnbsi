package com.hackathonpfma.smartrekon.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hackathonpfma.core.navigation.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppMain() {
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()
    val bottomNavItems = listOf(BottomNavItem.Home, BottomNavItem.Profile)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }

    Scaffold(
        bottomBar = {
            if (currentRoute == Route.DASHBOARD || currentRoute == Route.PROFILE) {
                AppBottomNavigation(navController, bottomNavItems)
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AppNavigation(navController = navController)
        }
    }
}

sealed class BottomNavItem(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Home : BottomNavItem(route = Route.DASHBOARD, label = "Dashboard", icon = { Icon(Icons.Filled.Home, contentDescription = "Dashboard") })
    object Profile : BottomNavItem(Route.PROFILE, "Profile", icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") })
}
