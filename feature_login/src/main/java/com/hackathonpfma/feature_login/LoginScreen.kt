package com.hackathonpfma.feature_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackathonpfma.core.R
import com.hackathonpfma.core.ui.component.AppTextFieldOutlined

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(Color(0xFFF5F5F5)), // warna abu2 muda
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(128.dp))

        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = "Smart Rekon Logo",
            modifier = Modifier.wrapContentSize()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Login", fontWeight = FontWeight.Bold, fontSize = 35.sp)
        Text("Monitor your docs in minutes", color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        Text("Email", fontWeight = FontWeight.SemiBold, modifier = Modifier.fillMaxWidth())
        AppTextFieldOutlined(
            value = email,
            onValueChange = { email = it },
            label = "",
            hint = "pabloescobar@gmail.com"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Password", fontWeight = FontWeight.SemiBold, modifier = Modifier.fillMaxWidth())
        AppTextFieldOutlined(
            value = password,
            onValueChange = { password = it },
            label = "",
            hint = "zd3-ddk-$0-33",
            isPassword = true
        )

        Spacer(modifier = Modifier.height(72.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (email.isNotBlank() && password.isNotBlank()) Color(0xFF007BFF) else Color(0xFFCCCCCC),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFFCCCCCC),  // Warna latar saat disabled
                disabledContentColor = Color.White          // Warna teks saat disabled
            ),

            shape = RoundedCornerShape(12.dp),
            enabled = email.isNotBlank() && password.isNotBlank()
        ) {
            Text("Login")
        }
    }
}
