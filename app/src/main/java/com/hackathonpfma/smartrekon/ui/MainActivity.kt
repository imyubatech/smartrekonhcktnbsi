package com.hackathonpfma.smartrekon.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.hackathonpfma.core.ui.theme.SmartRekonTheme
import com.hackathonpfma.smartrekon.navigation.AppMain
import com.hackathonpfma.smartrekon.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            SmartRekonTheme {
                AppMain()
            }
        }
    }
}