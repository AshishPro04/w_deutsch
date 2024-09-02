package com.aschiesch.dspiel.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.theme.WDeutschTheme

@Composable
fun ArticleScreen(
    gameViewModel: QuizViewModel = viewModel(),
    onGameComplete: () -> Unit = {}
) {
    val uiState by gameViewModel.uiState.collectAsState()
    Column {
        GameStatus(
            score = uiState.score,
            currentNumber = uiState.currentQuestionNumber,
            totalNumber = uiState.totalQuestion
        )
        AnimatedContent(
            targetState = uiState.currentQuestion,
            label = "card",
            transitionSpec = {
                slideInHorizontally(
                    tween(300),
                    initialOffsetX = { fullWidth -> fullWidth }
                ) + fadeIn() + scaleIn(initialScale = 0.5f) togetherWith
                        slideOutHorizontally(
                            tween(300),
                            targetOffsetX = { fullWidth -> -fullWidth }
                        ) + fadeOut() + scaleOut(targetScale = 0.5f)
            }
        ) { question ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(8.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primaryContainer,
                                MaterialTheme.colorScheme.secondaryContainer
                            ),
                        ),
                        shape = CardDefaults.outlinedShape,
                        alpha = 0.5f
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    ArticleQuestion(question = question)
                    LazyColumn {
                        items(uiState.options) { answerOption ->
                            ArticleAnswerOption(option = answerOption) { userAnswer ->
                                if (!gameViewModel.checkNextQuestion(userAnswer)) {
                                    onGameComplete()
                                }
                            }
                        }
                    }
                }

            }
        }
    }

}

@Composable
fun GameStatus(modifier: Modifier = Modifier, score: Int, currentNumber: Int, totalNumber: Int) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ScoreView(score = score)
        Spacer(modifier = Modifier.weight(1f))
        QuizQuestionNumber(currentNumber = currentNumber, totalNumber = totalNumber)
    }
}

@Composable
fun ScoreView(modifier: Modifier = Modifier, score: Int) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .fillMaxHeight()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(10)
            ),
        shape = RoundedCornerShape(10)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.score),
                Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(4.dp)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .fillMaxWidth()

            )
            Text(
                text = score.toString(),
                modifier = modifier.padding(8.dp),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@Composable
fun QuizQuestionNumber(modifier: Modifier = Modifier, currentNumber: Int, totalNumber: Int) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .fillMaxHeight()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(10)
            ),
        shape = RoundedCornerShape(10)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .width(IntrinsicSize.Max)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$currentNumber/$totalNumber",
                Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@Composable
fun ArticleQuestion(question: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = question),
        modifier = modifier
            .padding(8.dp)
            .padding(vertical = 8.dp),
        style = MaterialTheme.typography.titleLarge.copy(
            textMotion = TextMotion.Animated
        )
    )
}

@Composable
fun ArticleAnswerOption(option: Int, onOptionClick: (Int) -> Unit = {}) {
    Button(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.75f)
            .shadow(
                elevation = 2.dp,
                shape = CutCornerShape(topStart = 25f, bottomEnd = 25f),
            ),
        onClick = {
            onOptionClick(option)
        },
        shape = CutCornerShape(topStart = 25f, 0.10f, 25f, 0.10f),
        border = ButtonDefaults.outlinedButtonBorder
    ) {
        Text(
            text = stringResource(id = option),
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun ArticleScreenPreview() {
    WDeutschTheme {
        ArticleScreen()
    }
}

@Preview
@Composable
fun ScoreViewPreview() {
    WDeutschTheme {
        ScoreView(score = 10)
    }
}

@Preview
@Composable
fun QuizQuestionNumberPreview() {
    WDeutschTheme {
        QuizQuestionNumber(currentNumber = 1, totalNumber = 10)
    }
}