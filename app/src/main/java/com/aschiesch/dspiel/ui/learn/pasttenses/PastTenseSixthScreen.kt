package com.aschiesch.dspiel.ui.learn.pasttenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BulletedPoint
import com.aschiesch.dspiel.ui.learn.BulletedPointWithBoldCaption
import com.aschiesch.dspiel.ui.learn.LessonTitle
import com.aschiesch.dspiel.ui.learn.NextButton
import com.aschiesch.dspiel.ui.learn.PreviousButton
import kotlinx.serialization.Serializable

@Serializable
object PastTenseSixthScreen

@Composable
fun PastTenseSixthScreen(
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    val columnScrollState = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonTitle(stringResource(R.string.practice_exercises_header))
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.exercise_1_caption),
            text = stringResource(R.string.past_exercise_1_description),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.past_exercise_1_frage_1),
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.past_exercise_1_frage_2),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.past_exercise_1_frage_3),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.exercise_2_caption),
            text = stringResource(R.string.past_exercise_2_description),
            fontSize = 20.sp
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Row (
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(onClick = onPreviousClick)
            NextButton(onClick = onNextClick)
        }
    }
}