package com.aschiesch.dspiel.ui.learn


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
fun BulletedPoint(text: String, modifier: Modifier = Modifier) {
    val bullet = "\u2022" // Unicode for bullet
    val pointTextColors = listOf(
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.tertiary
    )
    val pointedText = buildAnnotatedString {
        withStyle(ParagraphStyle(textAlign = TextAlign.Left)) {
            withStyle(style = SpanStyle(fontSize = 16.sp)) {
                append(bullet)
                append(" ")
                append(text)
            }
        }
    }
    val pointedTextBrush = Brush.linearGradient(pointTextColors)
    Text(
        text = pointedText,
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.titleMedium.copy(
            brush = pointedTextBrush
        ),
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

@Composable
fun LessonSubTitleSmall(subTitle: String, modifier: Modifier = Modifier) {
    Text(
        text = subTitle,
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.headlineSmall.copy(
            color = MaterialTheme.colorScheme.tertiary
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

@Composable
fun BoxedText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current
) {
    val tableBorderWidth = 1f.dp
    Box(
        modifier = Modifier
            .border(
                width = tableBorderWidth,
                color = MaterialTheme.colorScheme.outline
            )
    ) {
        Text(
            text = text,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = style,
            maxLines = 1,
        )
    }
}

@Composable
fun BoxedTitle(text: String, modifier: Modifier = Modifier) {
    BoxedText(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge.copy(
            color = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun BoxedContent(contentText: String, modifier: Modifier = Modifier) {
    BoxedText(
        text = contentText,
        modifier = modifier,
        style = MaterialTheme.typography.labelMedium
    )
}