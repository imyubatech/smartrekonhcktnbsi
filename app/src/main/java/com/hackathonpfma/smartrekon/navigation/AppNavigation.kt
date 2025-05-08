package com.hackathonpfma.smartrekon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hackathonpfma.core.navigation.Route
import com.hackathonpfma.feature_home.DashboardScreen
import com.hackathonpfma.feature_login.LoginScreen
import com.hackathonpfma.smartrekon.ui.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.SPLASH) {
        composable(route = Route.SPLASH) {
            SplashScreen {
                navController.navigate(Route.AUTH)
            }
        }
        composable(route = Route.AUTH) {
            LoginScreen {
                navController.navigate(Route.DASHBOARD)
            }
        }
        composable(route = Route.DASHBOARD) {
            DashboardScreen()
        }
    }
}