package com.hackathonpfma.feature_login

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hackathonpfma.core.*
import com.hackathonpfma.core.navigation.LoginFeature

@Composable
fun LoginNavigation(loginNavController: NavHostController, navController: NavHostController) {

    NavHost(
        loginNavController,
        startDestination = LoginFeature.LoginScreen.name
    ) {
        composable(LoginFeature.LoginScreen.name) {
            LoginScreen(){

            }
        }
    }
}
