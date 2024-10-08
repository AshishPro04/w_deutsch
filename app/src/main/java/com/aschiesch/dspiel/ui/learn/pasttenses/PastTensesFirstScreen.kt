package com.aschiesch.dspiel.ui.learn.pasttenses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BulletedPointWithBoldCaption
import com.aschiesch.dspiel.ui.learn.LessonTitle
import kotlinx.serialization.Serializable

@Serializable
object PastTensesFirstScreen


@Composable
fun PastTensesFirstScreen() {
    val columnScrollState = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonTitle(
            stringResource(R.string.past_header)
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.simple_past_title_de),
            inBrackets = stringResource(R.string.simple_past_title_en),
            text = stringResource(R.string.simple_past_explanation)
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.present_perfect_title_de),
            inBrackets = stringResource(R.string.present_perfect_title_en),
            text = stringResource(R.string.present_perfect_explanation)
        )
    }
}