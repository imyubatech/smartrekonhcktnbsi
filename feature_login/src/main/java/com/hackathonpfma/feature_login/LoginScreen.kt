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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackathonpfma.core.R
import com.hackathonpfma.core.ui.component.AppTextFieldOutlined
import com.hackathonpfma.core.ui.theme.AppColor

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)), // warna abu2 muda
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(128.dp))

        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = stringResource(com.hackathonpfma.feature_login.R.string.smart_rekon_logo_desc),
            modifier = Modifier.wrapContentSize()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(com.hackathonpfma.feature_login.R.string.login), fontWeight = FontWeight.Bold, fontSize = 30.sp, color = AppColor.Black)
        Text(stringResource(com.hackathonpfma.feature_login.R.string.monitor_your_docs_in_minutes), color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            stringResource(com.hackathonpfma.feature_login.R.string.email), fontWeight = FontWeight.SemiBold, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            color = AppColor.Black
        )
        AppTextFieldOutlined(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = email,
            onValueChange = { email = it.trim() },
            label = "",
            hint = "pabloescobar@gmail.com"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(com.hackathonpfma.feature_login.R.string.password), fontWeight = FontWeight.SemiBold, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            color = AppColor.Black
        )
        AppTextFieldOutlined(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = password,
            onValueChange = { password = it.trim() },
            label = "",
            hint = "zd3-ddk-$0-33",
            isPassword = true
        )

        Spacer(modifier = Modifier.height(72.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (email.isNotBlank() && password.isNotBlank()) Color(0XFF003539) else Color(0xFFCCCCCC),
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
