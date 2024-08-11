package com.aschiesch.dspiel.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.data.quiz.QuizMode
import com.aschiesch.dspiel.data.quiz.QuizInfo
import com.aschiesch.dspiel.ui.theme.WDeutschTheme

@Composable
fun HomeScreen(
    onOpen: (String) -> Unit
) {
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            Category(
                categoryName = stringResource(R.string.article),
                playItems = listOf(
                    QuizInfo(nameId = R.string.definite_article, quizMode = QuizMode.DEFINITE_ARTICLE),
                    QuizInfo(nameId = R.string.indefinite_article, quizMode = QuizMode.INDEFINITE_ARTICLE),
                    QuizInfo(nameId = R.string.indefinite_negative_article, quizMode = QuizMode.NEGATIVE_ARTICLE)
                ),
                modifier = Modifier.padding(8.dp),
                onOpen = onOpen
            )
            Category(
                categoryName = stringResource(id = R.string.numbers),
                playItems = listOf(
                    QuizInfo(nameId = R.string.single_digit, quizMode = QuizMode.SINGLE_DIGIT),
                    QuizInfo(nameId = R.string.double_digit, quizMode = QuizMode.DOUBLE_DIGIT),
                    QuizInfo(nameId = R.string.triple_digit, quizMode = QuizMode.TRIPLE_DIGIT)
                ),
                modifier = Modifier.padding(8.dp)
            ) {

            }
        }
    }
}

@Composable
fun Category(
    categoryName: String,
    playItems: List<QuizInfo>,
    modifier: Modifier = Modifier,
    onOpen: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        CategoryTitle(categoryName = categoryName)
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(playItems.size) { index ->
                PlayItem(playItems[index], onOpen = onOpen)
            }
        }
    }
}

@Composable
fun CategoryTitle(
    categoryName: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = categoryName,
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.titleMedium
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayItem(
    articleItem: QuizInfo,
    onOpen: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {onOpen(articleItem.quizMode.name)},
        modifier = modifier
            .padding(8.dp)
            .size(128.dp),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = articleItem.nameId),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    WDeutschTheme {
        HomeScreen {

        }
    }
}