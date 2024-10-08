package com.aschiesch.dspiel.ui.learn.presenttense


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BulletedPoint
import com.aschiesch.dspiel.ui.learn.LessonSubTitle
import com.aschiesch.dspiel.ui.learn.LessonSubTitleSmall
import com.aschiesch.dspiel.ui.learn.NextButton
import com.aschiesch.dspiel.ui.learn.PreviousButton
import kotlinx.serialization.Serializable

@Serializable
object PresentTenseFourthScreen

@Composable
fun PresentTenseFourthScreen(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val columnScrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonSubTitle(stringResource(R.string.usage_header))
        LessonSubTitleSmall(stringResource(R.string.present_actions_header))
        BulletedPoint(stringResource(R.string.present_action_example))
        LessonSubTitleSmall(stringResource(R.string.habitual_actions_header))
        BulletedPoint(stringResource(R.string.habitual_actions_example))
        LessonSubTitleSmall(stringResource(R.string.future_action_header))
        BulletedPoint(
            stringResource(R.string.future_actions_example),
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PreviousButton(
                onClick = onPreviousClick
            )

            NextButton(
                onClick = onNextClick
            )
        }
    }
}