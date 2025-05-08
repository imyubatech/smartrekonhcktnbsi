package com.hackathonpfma.feature_home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hackathonpfma.core.ui.component.AppCylinderBarChart
import com.hackathonpfma.core.ui.theme.AppColor

@Composable
fun DashboardScreen() {
    val maxValue = 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.White)
            .padding(16.dp)
    ) {
        // Logo dan Judul
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Ganti ini dengan Image() jika kamu punya logo
            Text(
                text = "Smart Rekon",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Judul Dashboard
        Text(
            text = "Dashboard",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Chart Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {
                AppCylinderBarChart(
                    value = 20,
                    maxValue = maxValue,
                    color = AppColor.Black,
                    label = ""
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Dokumen Cards
        DocumentStatusCard("Waiting document", 20, AppColor.Black)
        DocumentStatusCard("Approved document", 20, AppColor.Black)
        DocumentStatusCard("Rejected document", 60, AppColor.Black)
    }
}

@Composable
fun DocumentStatusCard(title: String, count: Int, color: Color) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(color, shape = RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text("$count documents", color = Color.Gray)
            }

            Icon(
                imageVector = Icons.Default.Description,
                contentDescription = "document icon",
                tint = AppColor.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    DashboardScreen()
}