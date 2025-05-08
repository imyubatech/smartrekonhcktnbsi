package com.hackathonpfma.feature_login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginFeature(navController: NavHostController) {
    val loginNavController = rememberNavController()
    LoginNavigation(loginNavController = loginNavController,navController = navController)
}