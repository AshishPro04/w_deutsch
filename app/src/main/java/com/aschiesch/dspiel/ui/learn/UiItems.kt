package com.aschiesch.dspiel.ui.learn


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun LessonTitle(title: String, modifier: Modifier = Modifier) {
    val titleColors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
    val brush = Brush.linearGradient(titleColors)
    Text(
        text = title,
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.headlineLarge.copy(
            brush = brush
        ),
        fontWeight = FontWeight.Bold
    )
}

// A paragraph that describes the lesson
@Composable
fun LessonParagraph(paragraph: String, modifier: Modifier = Modifier) {
    val paragraphColors = listOf(
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.tertiary
    )
    Text(
        text = paragraph,
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.titleLarge.copy(
            brush = Brush.linearGradient(paragraphColors)
        )
    )
}

@Composable
fun LessonSubTitle(subTitle: String, modifier: Modifier = Modifier) {
    Text(
        text = subTitle,
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.headlineMedium.copy(
            color = MaterialTheme.colorScheme.secondary
        )
    )
}

// A Button for navigating to the next screen
@Composable
fun NextButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(8.dp),
        shape = CutCornerShape(
            topStartPercent = 10,
            bottomEndPercent = 40,
            topEndPercent = 40,
            bottomStartPercent = 10
        )
    ) {
        Text(
            text = "Next",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun PreviousButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.padding(8.dp),
        shape = CutCornerShape(
            topStartPercent = 40,
            bottomEndPercent = 10,
            topEndPercent = 10,
            bottomStartPercent = 40
        )
    ) {
        Text(
            text = "Previous",
            modifier = Modifier.padding(8.dp)
        )
    }
}