package com.hackathonpfma.feature_home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardFeature(navController: NavHostController) {
    val loginNavController = rememberNavController()
    DashboardNavigation(dashboardNavController = loginNavController,navController = navController)
}