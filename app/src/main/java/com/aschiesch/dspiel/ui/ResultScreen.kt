package com.aschiesch.dspiel.ui

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.data.results.Result
import com.aschiesch.dspiel.data.results.ResultInfo
import com.aschiesch.dspiel.data.results.ResultSource
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlin.math.roundToInt

@Composable
fun ResultScreen(
    quizViewModel: QuizViewModel = viewModel(),
    onCloseResult: () -> Unit
) {
    val state = quizViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        SelectResult(state){
            quizViewModel.resetState()
            onCloseResult()
        }
    }
}

@Composable
private fun SelectResult(
    state: State<QuizUiState>,
    onCloseResult: () -> Unit
) {
    when (state.value.result) {
        Result.EXCELLENT -> ResultView(
            resultScore = state.value.score,
            resultTotalScore = state.value.totalQuestion,
            resultInfo = ResultSource.excellent,
            onCloseResult = onCloseResult
        )

        Result.GOOD -> ResultView(
            resultScore = state.value.score,
            resultTotalScore = state.value.totalQuestion,
            resultInfo = ResultSource.good,
            onCloseResult = onCloseResult
        )

        Result.AVERAGE -> ResultView(
            resultScore = state.value.score,
            resultTotalScore = state.value.totalQuestion,
            resultInfo = ResultSource.average,
            onCloseResult = onCloseResult
        )

        Result.FAIR -> ResultView(
            resultScore = state.value.score,
            resultTotalScore = state.value.totalQuestion,
            resultInfo = ResultSource.fair,
            onCloseResult = onCloseResult
        )

        Result.POOR -> ResultView(
            resultScore = state.value.score,
            resultTotalScore = state.value.totalQuestion,
            resultInfo = ResultSource.poor,
            onCloseResult = onCloseResult
        )

        else -> {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ResultView(
    resultScore: Int,
    resultTotalScore: Int,
    resultInfo: ResultInfo,
    onCloseResult: () -> Unit
) {
    val resultImage by rememberSaveable(resultInfo) {
        mutableIntStateOf(resultInfo.resultImage)
    }
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale image"
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(8.dp)
                        .padding()
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(id = resultInfo.resultTitle),
                        style = MaterialTheme.typography.displaySmall.copy(),
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = stringResource(
                            id = R.string.complete_result,
                            resultScore,
                            resultTotalScore
                        ),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp)
                        .width(IntrinsicSize.Min)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.secondaryContainer,
                                    MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        ),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = stringResource(id = resultInfo.resultLabel),
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
        Card(modifier = Modifier.padding(8.dp)) {
            Text(
                text = stringResource(id = resultInfo.resultMessage),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = resultImage),
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        val scaledHeight = (placeable.height * scale).roundToInt()
                        val scaledWidth = (placeable.width * scale).roundToInt()
                        val xPos = (scaledWidth - placeable.width) / 2
                        val yPos = (scaledHeight - placeable.height) / 2
                        layout(width = scaledWidth, height = scaledHeight) {
                            placeable.placeRelative(xPos, yPos)
                        }
                    }
            )

        }
        Button(
            onClick = onCloseResult,
            shape = CutCornerShape(topStart = 25f, bottomEnd = 25f),
            modifier = Modifier
                .padding(8.dp)
                .wrapContentWidth(),
        ) {
            Text(text = stringResource(id = R.string.close))
        }
    }
}


@Preview
@Composable
fun ResultScreenPreview() {
    WDeutschTheme {
        ResultView(
            resultScore = 8,
            resultTotalScore = 10,
            resultInfo = ResultSource.good
        ){

        }
    }
}