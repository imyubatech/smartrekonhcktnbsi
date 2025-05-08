package com.hackathonpfma.core.ui.component

import android.graphics.Color
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathonpfma.core.ui.theme.AppColor
import java.nio.file.Files.size

@Composable
fun AppCylinderBarChart(
    value: Int,
    maxValue: Int,
    color: androidx.compose.ui.graphics.Color,
    label: String,
    modifier: Modifier = Modifier
) {
    val barHeightFraction = if (maxValue == 0) 0f else value.toFloat() / maxValue.toFloat()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Value text
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = AppColor.White,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Cylinder bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(barHeightFraction)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val width = size.width
                val height = size.height

                // Cylinder body
                drawRoundRect(
                    color = color,
                    topLeft = Offset(0f, 0f),
                    size = Size(width, height),
                    cornerRadius = CornerRadius(width / 2, width / 2)
                )

                // Top ellipse for 3D effect
                drawOval(
                    color = color.copy(alpha = 0.95f),
                    topLeft = Offset(0f, -width / 4),
                    size = Size(width, width / 2)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Label
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = AppColor.Black
        )
    }
}
