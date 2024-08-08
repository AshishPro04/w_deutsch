package com.aschiesch.dspiel.ui

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
}

@Composable
fun ResultView(
    resultScore: Int,
    resultTotalScore: Int,
    resultInfo: ResultInfo,
    onCloseResult: () -> Unit
) {
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
                        style = MaterialTheme.typography.displaySmall,
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
                painter = painterResource(id = resultInfo.resultImage),
                contentDescription = null
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