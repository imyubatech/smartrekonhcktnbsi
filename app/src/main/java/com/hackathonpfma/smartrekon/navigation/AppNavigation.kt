package com.hackathonpfma.smartrekon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hackathonpfma.core.navigation.Route
import com.hackathonpfma.feature_home.DashboardScreen
import com.hackathonpfma.feature_home.DetailApprovedScreen
import com.hackathonpfma.feature_home.DetailRejectedScreen
import com.hackathonpfma.feature_home.DetailWaitingScreen
import com.hackathonpfma.feature_login.LoginScreen
import com.hackathonpfma.feature_profile.ProfileScreen
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
            DashboardScreen(
                toWaitingDocs = {
                navController.navigate(Route.DETAIL_WAITING)
            },
                toApproveDocs = {
                    navController.navigate(Route.DETAIL_APPROV)
                },
                toRejectedDocs = {
                    navController.navigate(Route.DETAIL_REJECTED)
                })
        }
        composable(route = Route.DETAIL_WAITING){
            DetailWaitingScreen( onBack = {
                navController.popBackStack()
            }, toDetails = {})
        }
        composable(route = Route.DETAIL_APPROV){
            DetailApprovedScreen ( onBack = {
                navController.popBackStack()
            }, toDetails = {})
        }
        composable(route = Route.DETAIL_REJECTED){
            DetailRejectedScreen ( onBack = {
                navController.popBackStack()
            }, toDetails = {})
        }

        composable(route = Route.PROFILE){
            ProfileScreen()
        }
    }
}