package com.hackathonpfma.smartrekon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.hackathonpfma.core.ui.theme.AppColor
import com.hackathonpfma.core.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onBoarding: () -> Unit) {
    LaunchedEffect(key1 = true, block = {
        delay(2000L)
        onBoarding()
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Emerald.Normal)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_splash_screen),
            contentDescription = "background_splashscreen",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        )
        Image(
            painter = painterResource(id = R.drawable.logoapp),
            contentDescription = "lorem logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun view() {
    SplashScreen { }
}