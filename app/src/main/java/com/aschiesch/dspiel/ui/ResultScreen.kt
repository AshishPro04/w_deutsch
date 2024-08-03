package com.aschiesch.dspiel.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.theme.WDeutschTheme

@Composable
fun ResultScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

    }
}

@Composable
fun ResultView(
    resultTitle: Int,
    @StringRes resultType: Int,
    @StringRes resultDescription: Int,
    resultScore: Int,
    @DrawableRes resultImage: Int
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = stringResource(id = resultTitle),
                        style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.complete_result, resultScore, 10),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.secondaryContainer,
                                    MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = resultType),
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
        Card(modifier = Modifier.padding(8.dp)) {
            Text(
                text = stringResource(id = resultDescription),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = resultImage),
                contentDescription = null
            )

        }
    }
}


@Preview
@Composable
fun ResultScreenPreview() {
    WDeutschTheme {
        ResultView(
            resultTitle = R.string.congratulations,
            resultScore = 10,
            resultImage = R.drawable.congratulations_one,
            resultDescription = R.string.excellent_description,
            resultType = R.string.excellent_label
        )
    }
}