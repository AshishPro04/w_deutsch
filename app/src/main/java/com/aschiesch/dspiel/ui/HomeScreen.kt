package com.aschiesch.dspiel.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.verticalScroll
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
import com.aschiesch.dspiel.ui.theme.WDeutschTheme

@Composable
fun HomeScreen(
    onOpen: () -> Unit
) {
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            Category(
                categoryName = stringResource(R.string.article),
                playItems = listOf(
                    stringResource(id = R.string.definite_article),
                    stringResource(id = R.string.indefinite_article),
                    stringResource(id = R.string.indefinite_negative_article)
                ),
                modifier = Modifier.padding(8.dp),
                onOpen = onOpen
            )
            Category(
                categoryName = stringResource(id = R.string.numbers),
                playItems = listOf(
                    stringResource(id = R.string.single_digit),
                    stringResource(id = R.string.double_digit),
                    stringResource(id = R.string.triple_digit)
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
    playItems: List<String>,
    modifier: Modifier = Modifier,
    onOpen: () -> Unit
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
    name: String,
    onOpen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onOpen,
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
                text = name,
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