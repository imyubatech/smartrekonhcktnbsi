package com.hackathonpfma.feature_home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hackathonpfma.core.navigation.DashboardFeature
import com.hackathonpfma.core.navigation.LoginFeature
import com.hackathonpfma.feature_home.DashboardScreen

@Composable
fun DashboardNavigation(dashboardNavController: NavHostController, navController: NavHostController) {

    NavHost(
        dashboardNavController,
        startDestination = DashboardFeature.DashoardScreen.name
    ) {
        composable(LoginFeature.LoginScreen.name) {
            DashboardScreen({},{},{})

        }
    }
}
