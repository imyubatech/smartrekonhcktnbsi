package com.hackathonpfma.smartrekon.navigation

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation
import com.hackathonpfma.core.navigation.AppNav
import com.hackathonpfma.core.navigation.NavModule
import com.hackathonpfma.core.navigation.NavRoutes
import com.hackathonpfma.feature_home.DashboardFeature
import com.hackathonpfma.feature_login.LoginFeature
import com.hackathonpfma.smartrekon.ui.SplashScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavGraph(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController)}
    ) {
        NavHost(navController, startDestination = NavRoutes.SplashScreen.name) {

            composable(NavRoutes.SplashScreen.name) {
                SplashScreen {
                    navController.navigate(NavModule.AuthModule.name)
                }
            }

            navigation(
                startDestination = AppNav.LoginFeature.name,
                route = NavModule.AuthModule.name
            ) {
                composable(AppNav.LoginFeature.name) {
                    LoginFeature(navController)
                }
            }

            navigation(
                startDestination = AppNav.DashboardFeature.name,
                route = NavModule.DashboardModule.name
            ) {
                composable(AppNav.LoginFeature.name) {
                    DashboardFeature(navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val items = listOf(
            NavModule.DashboardModule,
            NavModule.DashboardModule,
            NavModule.ProfileModule
        )
        items.forEach { item ->
            NavigationBarItem( // Use Material 3 NavigationBarItem
                icon = {
                    // Gunakan ikon berdasarkan rute. Anda dapat menyesuaikannya.
                    val icon = when (item) {
                        NavModule.DashboardModule -> Icons.Filled.Home
                        NavModule.DashboardModule-> Icons.Filled.Warning
                        else -> Icons.Filled.Person
                    }
                    Icon(icon, contentDescription = item.name)
                },
                label = { Text(item.name) }, //Use Material 3 Text
                selected = currentRoute == item.name,
                onClick = {
                    // Navigasi ke rute yang dipilih, dan cegah banyak salinan
                    navController.navigate(item.name) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}