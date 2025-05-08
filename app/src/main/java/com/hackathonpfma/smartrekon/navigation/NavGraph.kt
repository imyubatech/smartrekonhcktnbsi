package com.hackathonpfma.smartrekon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hackathonpfma.core.NavModule
import com.hackathonpfma.core.NavRoutes
import com.hackathonpfma.smartrekon.ui.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.SplashScreen.name) {
        composable(NavRoutes.SplashScreen.name) {
            SplashScreen {
                navController.navigate(NavModule.AuthModule.name)
            }
        }
    }

}