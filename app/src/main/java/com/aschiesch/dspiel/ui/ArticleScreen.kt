package com.aschiesch.dspiel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.theme.WDeutschTheme

@Composable
fun ArticleScreen(gameViewModel: QuizViewModel = viewModel()) {
    val uiState by gameViewModel.uiState.collectAsState()
    Column {
        GameStatus(
            score = uiState.score,
            currentNumber = uiState.currentQuestionNumber,
            totalNumber = uiState.totalQuestion
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(8.dp)) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ArticleQuestion(question =  uiState.currentQuestion)
                Column {

                    ArticleAnswerOption(option = uiState.option1){ userAnswer ->
                        gameViewModel.userClicked(userAnswer)
                    }
                    ArticleAnswerOption(option = uiState.option2) {
                        gameViewModel.userClicked(it)
                    }
                    ArticleAnswerOption(option = uiState.option3){
                        gameViewModel.userClicked(it)
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
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.Center
        ){
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
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .width(IntrinsicSize.Max)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "$currentNumber/$totalNumber",
                Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.displaySmall
            )
//            Spacer(
//                modifier = Modifier
//                    .padding(horizontal = 4.dp)
//                    .height(4.dp)
//                    .background(MaterialTheme.colorScheme.tertiary)
//                    .fillMaxWidth()
//            )
//            Text(
//                text = totalNumber.toString(),
//                modifier = modifier.padding(8.dp),
//                style = MaterialTheme.typography.displaySmall
//            )
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
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun ArticleAnswerOption(option: Int, onOptionClick: (Int) -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.75f)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CutCornerShape(topStart = 25f, 0.1f, 25f, 0.1f)
            )
            .shadow(elevation = 2.dp,
                shape = CutCornerShape(topStart = 25f, bottomEnd = 25f),
            )
            .clickable {
                onOptionClick(option)
            },
        contentAlignment = Alignment.Center
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