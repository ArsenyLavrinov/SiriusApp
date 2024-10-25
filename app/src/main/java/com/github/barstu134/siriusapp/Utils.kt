package com.github.barstu134.siriusapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

val veryLightGray = Color(230,230,230)
val veryLightBlue = Color(107,177,247)
val customBlue = Color(43,86,246)
@Composable
fun GrayText(text: String) {
    Text(text, color = Color.Gray, fontWeight = FontWeight.Bold)
}

@Composable
fun TitleWithBackArrow(text: String, callback: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .padding(24.dp)
            .weight(0.1f)
            .clickable {
                callback()
            }) {
            Text(
                "<",
                style = MaterialTheme.typography.headlineLarge,

                )
        }
        Text(
            text,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.5f)
        )
        Spacer(Modifier.weight(0.1f))
    }
}

@Composable
fun ComposeCircularProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
) {
    Canvas(
        modifier = modifier
            .size(50.dp)
            .padding(10.dp)
    ) {

        drawCircle(
            color = veryLightBlue.copy(alpha = 0.5f),
            radius = size.width/2,
        )
        drawArc(
            color = veryLightBlue,
            0f,
            360f * percentage,
            true,
            size = Size(size.width, size.height)
        )
        drawArc(
            color = customBlue,
            0f,
            360f * percentage,
            true,
            topLeft= Offset(size.width/4, size.height/4),
            size = Size(size.width/2, size.height/2)
        )

        var angleInDegrees = (percentage * 260.0) + 50.0
        var radius = (size.height / 2)
        var x = -(radius * sin(Math.toRadians(angleInDegrees))).toFloat() + (size.width / 2)
        var y = (radius * cos(Math.toRadians(angleInDegrees))).toFloat() + (size.height / 2)

        drawCircle(
            color = Color.White,
            radius = 5f,
            center = Offset(x,  y)
        )
    }
}