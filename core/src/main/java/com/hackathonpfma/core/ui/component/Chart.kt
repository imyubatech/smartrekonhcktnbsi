package com.hackathonpfma.core.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.withSave
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.util.lerp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PipeChart(
    values: List<Int>, // Data values for the pipes
    colors: List<Color>, // Colors for each pipe
    labels: List<String>, // Labels for each pipe
    modifier: Modifier = Modifier
) {
    // Ensure that the data, colors, and labels are consistent
    val count = minOf(values.size, minOf(colors.size, labels.size))
    val validValues = values.take(count)
    val validColors = colors.take(count)
    val validLabels = labels.take(count)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp), // Set a fixed height for the chart
        contentAlignment = Alignment.BottomCenter // Align the pipes to the bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround, // Space the pipes evenly
            verticalAlignment = Alignment.Bottom, // Align items to the bottom of the Row
        ) {
            validValues.forEachIndexed { index, value ->
                DrawPipeWithLabel(
                    value = value,
                    color = validColors[index],
                    maxValue = validValues.maxOrNull() ?: 100 // Use 100 as a default max if list is empty
                )
            }
        }
    }
}

@Composable
fun DrawPipeWithLabel(
    value: Int,
    color: Color,
    maxValue: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom // Align items to the bottom of the Column
    ) {
        // Calculate the height of the pipe based on the value and maximum value.
        val pipeHeight = (20.toFloat() / maxValue.toFloat()).coerceIn(0f, 1f) * 120.dp.value
        val displayValue = if (value > 99) "99+" else value.toString()

        DrawPipe(
            color = color,
            height = value.dp,
            value = displayValue
        )
    }
}

@Composable
fun DrawPipe(color: Color, height: Dp, value: String) {
    // Define gradient colors with a slight variation for a 3D effect
    val gradientColors = listOf(
        color.copy(0.8f), // Lighter shade
        color,             // Base color
        color.copy(0.8f)  // Lighter shade
    )

    // Use a Brush to create the vertical gradient
    val gradient = Brush.verticalGradient(colors = gradientColors)

    Box {
        Canvas(
            modifier = Modifier
                .width(40.dp) // Fixed width for the pipe
                .height(200.dp)
        ) {
            val width = size.width
            val height = size.height

            // Draw the main rectangle with the gradient
            drawRect(
                brush = gradient,
                topLeft = Offset(0f, 0f),
                size = size
            )

            // Add a subtle shadow using drawIntoCanvas for more control
            drawIntoCanvas {

                // Shadow offset - adjust to change the direction of the shadow
                val shadowOffset = Offset(5f, 5f)
                // Draw the shadow *before* the rectangle
                drawIntoCanvas {
                    drawRect(
                        size = size,
                        brush = gradient,
                        topLeft = Offset(0f, 0f),
                    )
                }
            }

            val ellipseHeight = 150 * 0.3f // Make the ellipse a fraction of the height.  Use a constant value
            drawOval(
                brush = gradient,
                topLeft = Offset(0f, -ellipseHeight/2), // overlap with the top
                size = androidx.compose.ui.geometry.Size(width, ellipseHeight)
            )

            // Draw an ellipse for the bottom
            drawOval(
                brush = gradient,
                topLeft = Offset(0f, height - ellipseHeight / 2),
                size = androidx.compose.ui.geometry.Size(width, ellipseHeight)
            )

        }
        // Position the text *on top* of the pipe
        Text(
            text = value,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Use white or a contrasting color
                shadow = Shadow( //Add shadow
                    color = Color.Black,
                    blurRadius = 2f,
                    offset = Offset(1f, 1f)
                )
            ),
            modifier = Modifier
                .align(Alignment.TopCenter) // Position at the top center
                .padding(top = 8.dp), // Add some padding to move it slightly down
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

    PipeChart(
        values = values,
        colors = colors,
        labels = labels,
        modifier = Modifier.padding(16.dp)
    )
}

