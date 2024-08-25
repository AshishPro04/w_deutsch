package com.aschiesch.dspiel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.data.quiz.QuizInfo
import com.aschiesch.dspiel.data.quiz.QuizItem
import com.aschiesch.dspiel.ui.theme.WDeutschTheme

@Composable
fun HomeScreen(
    onQuizOpen: (String) -> Unit
) {
    Surface (){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
        ) {
            items(QuizItem.quizGroups){
                Category(
                    categoryName = stringResource(id = it.quizGroupTitle),
                    playItems = it.quizItems,
                    onOpen = onQuizOpen
                )
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
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary
    )
}


@Composable
fun PlayItem(
    articleItem: QuizInfo,
    onOpen: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .defaultMinSize(minWidth = 128.dp)
            .height(128.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer
                    )
                ),
                shape = CardDefaults.shape
            )
            .clickable {
                onOpen(articleItem.quizMode.name)
            }
            .border(
                width = 1.dp,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.tertiaryContainer,
                        MaterialTheme.colorScheme.tertiary
                    )
                ),
                shape = CardDefaults.shape
            )
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