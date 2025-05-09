package com.hackathonpfma.core.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun AppPipeChart(
    values: List<Int>,
    colors: List<Color>,
    labels: List<String>,
    modifier: Modifier = Modifier
) {
    val count = minOf(values.size, minOf(colors.size, labels.size))
    val validValues = values.take(count)
    val validColors = colors.take(count)
    val validLabels = labels.take(count)

    var containerHeightPx by remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp) // Fixed height for example, could be passed as parameter
            .onGloballyPositioned {
                containerHeightPx = it.size.height
            },
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Bottom
        ) {
            validValues.forEachIndexed { index, value ->
                DrawPipeWithLabel(
                    value = value,
                    color = validColors[index],
                    maxValue = validValues.maxOrNull() ?: 100,
                    containerHeightPx = containerHeightPx
                )
            }
        }
    }
}

@Composable
fun DrawPipeWithLabel(
    value: Int,
    color: Color,
    maxValue: Int,
    containerHeightPx: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        DrawPipe(
            color = color,
            value = value,
            maxValue = maxValue,
            containerHeightPx = containerHeightPx
        )
    }
}

@Composable
fun DrawPipe(
    color: Color,
    value: Int,
    maxValue: Int,
    containerHeightPx: Int
) {
    val gradientColors = listOf(
        color.copy(0.8f),
        color,
        color.copy(0.8f)
    )

    val gradient = Brush.verticalGradient(colors = gradientColors)

    // Normalize height to container size
    val normalizedHeight = if (maxValue > 0) (value.toFloat() / maxValue.toFloat()).coerceIn(0f, 1f) else 0f
    val pipeHeightPx = containerHeightPx * normalizedHeight

    val pipeHeightDp = with(LocalDensity.current) { pipeHeightPx.toDp() }
    val containerHeightDp = with(LocalDensity.current) { containerHeightPx.toDp() }

    Box(contentAlignment = Alignment.TopCenter) {
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(with(LocalDensity.current) { containerHeightPx.toDp() })
        ) {
            val width = size.width
            val height = size.height

            // Pipe rectangle
            drawRect(
                brush = gradient,
                topLeft = Offset(0f, height - pipeHeightPx),
                size = Size(width, pipeHeightPx)
            )

            val ellipseHeight = width * 0.6f
            // Top ellipse
            drawOval(
                brush = gradient,
                topLeft = Offset(0f, height - pipeHeightPx - ellipseHeight / 2),
                size = Size(width, ellipseHeight)
            )

            // Bottom ellipse
            drawOval(
                brush = gradient,
                topLeft = Offset(0f, height - ellipseHeight / 2),
                size = Size(width, ellipseHeight)
            )
        }

        Text(
            text = value.toString(),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                shadow = Shadow(Color.Black, offset = Offset(1f, 1f), blurRadius = 2f)
            ),
            modifier = Modifier
                .offset(y = containerHeightDp - pipeHeightDp + (pipeHeightDp / 2) - 10.dp) // Middle of pipe
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PipeChartPreview() {
    // Example data for the chart
    val values = listOf(20, 20, 80)
    val colors = listOf(Color(0xFFF0B90B), Color(0xFF46B4C3), Color(0xFFE55331)) // Example colors
    val labels = listOf("Label 1", "Label 2", "Label 3")

    AppPipeChart(
        values = values,
        colors = colors,
        labels = labels,
        modifier = Modifier.padding(16.dp)
    )
}

