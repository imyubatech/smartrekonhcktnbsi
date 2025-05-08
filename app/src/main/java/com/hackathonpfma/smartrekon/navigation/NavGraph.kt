package com.hackathonpfma.smartrekon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hackathonpfma.core.navigation.GraphNav
import com.hackathonpfma.smartrekon.ui.SplashScreen
import com.hackathonpfma.core.navigation.NavModule
import com.hackathonpfma.core.navigation.NavRoutes
import com.hackathonpfma.feature_login.LoginFeature

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.SplashScreen.name) {

        composable(NavRoutes.SplashScreen.name) {
            SplashScreen {
                navController.navigate(NavModule.AuthModule.name)
            }
        }

        navigation(
            startDestination = GraphNav.LoginFeature.name,
            route = NavModule.AuthModule.name
        ) {
            composable(GraphNav.LoginFeature.name) {
                LoginFeature(navController)
            }
        }
    }
}