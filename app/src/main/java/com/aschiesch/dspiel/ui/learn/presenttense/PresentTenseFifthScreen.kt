package com.aschiesch.dspiel.ui.learn.presenttense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BulletedPoint
import com.aschiesch.dspiel.ui.learn.FinishButton
import com.aschiesch.dspiel.ui.learn.LessonParagraph
import com.aschiesch.dspiel.ui.learn.LessonTitle
import com.aschiesch.dspiel.ui.learn.PreviousButton
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PresentTenseFifthScreen


@Composable
fun PresentTenseFifthScreen(
    onPreviousClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    val columnScrollState = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonTitle(stringResource(R.string.practice_exercises_header))
        LessonParagraph(stringResource(R.string.present_tense_practice_1))
        LessonParagraph(stringResource(R.string.present_tense_practice_2))
        BulletedPoint(
            stringResource(R.string.present_tense_practice_2_1),
            modifier = Modifier.padding(start = 16.dp)
        )
        BulletedPoint(
            stringResource(R.string.present_tense_practice_2_2),
            modifier = Modifier.padding(start = 16.dp)
        )
        BulletedPoint(
            stringResource(R.string.present_tense_practice_2_3),
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(onPreviousClick)
            FinishButton(onCloseClick)
        }

    }
}

@Preview
@Composable
fun PresentTenseFifthScreenPreview() {
    WDeutschTheme {
        Surface {
            PresentTenseFifthScreen(
                onPreviousClick = {},
                onCloseClick = {}
            )
        }
    }
}