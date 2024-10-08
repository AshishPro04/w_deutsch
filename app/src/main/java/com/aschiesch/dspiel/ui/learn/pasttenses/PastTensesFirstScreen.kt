package com.aschiesch.dspiel.ui.learn.pasttenses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BulletedPointWithBoldCaption
import com.aschiesch.dspiel.ui.learn.LessonTitle
import com.aschiesch.dspiel.ui.learn.NextButton
import com.aschiesch.dspiel.ui.learn.RoundedFancyBox
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PastTensesFirstScreen


@Composable
fun PastTensesFirstScreen(
    onNextClicked: () -> Unit
) {
    val columnScrollState = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonTitle(
            stringResource(R.string.past_header)
        )
        val boxModifier = Modifier.padding(8.dp)
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        RoundedFancyBox(modifier = boxModifier) {
            BulletedPointWithBoldCaption(
                caption = stringResource(R.string.simple_past_title_de),
                inBrackets = stringResource(R.string.simple_past_title_en),
                text = stringResource(R.string.simple_past_explanation),
                modifier = boxModifier
            )
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        RoundedFancyBox(modifier = boxModifier) {
            BulletedPointWithBoldCaption(
                caption = stringResource(R.string.present_perfect_title_de),
                inBrackets = stringResource(R.string.present_perfect_title_en),
                text = stringResource(R.string.present_perfect_explanation),
                modifier = boxModifier
            )
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        NextButton(
            onClick = onNextClicked,
            modifier = Modifier.align(Alignment.End)
        )
    }
}


@Preview
@Composable
fun PreviewPastTensesFirstScreen() {
    WDeutschTheme {
        Surface {
            PastTensesFirstScreen(){

            }
        }
    }
}