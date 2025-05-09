package com.hackathonpfma.feature_home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hackathonpfma.core.R
import com.hackathonpfma.core.ui.component.AppPipeChart
import com.hackathonpfma.core.ui.theme.AppColor

@Composable
fun DashboardScreen(toWaitingDocs:()-> Unit,toApproveDocs:()-> Unit,toRejectedDocs:()-> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.White)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Dashboard",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        val values = listOf(10, 30, 60)
        val colors = listOf(Color(0xFFF0B90B), Color(0xFF56C924), Color(0xFFE55331)) // Example colors
        val labels = listOf("Label 1", "Label 2", "Label 3")

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
        ) {
            Card(shape = RoundedCornerShape(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.bg_splash_screen),
                    contentDescription = "lorem",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {
                AppPipeChart(
                    values = values,
                    colors = colors,
                    labels = labels

                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        DocumentStatusCard("Waiting document", 20, Color(0xFFF0B90B),toWaitingDocs)
        DocumentStatusCard("Approved document", 20, Color(0xFF56C924),toApproveDocs)
        DocumentStatusCard("Rejected document", 60, Color(0xFFE55331),toRejectedDocs)
    }
}

@Composable
fun DocumentStatusCard(title: String, count: Int, color: Color,onclick :()->Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable{onclick.invoke()}
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
    DashboardScreen({},{},{})
}