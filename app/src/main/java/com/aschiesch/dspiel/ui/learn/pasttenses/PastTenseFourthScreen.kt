package com.aschiesch.dspiel.ui.learn.pasttenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BulletedPoint
import com.aschiesch.dspiel.ui.learn.BulletedPointWithBoldCaption
import com.aschiesch.dspiel.ui.learn.LessonTitle
import com.aschiesch.dspiel.ui.learn.NextButton
import com.aschiesch.dspiel.ui.learn.PreviousButton
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PastTenseFourthScreen

@Composable
fun PastTenseFourthScreen(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val columnScrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(state = columnScrollState)
    ) {
        LessonTitle(title = stringResource(R.string.usage_of_prateritum_vs_perfekt_header))
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.prateritum_caption),
            text = stringResource(R.string.prateritum_explanation),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_sentence),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.perfekt_caption),
            text = stringResource(R.string.perfekt_explanation),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_example_sentence),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(
                onClick = onPreviousClick
            )
            NextButton(
                onClick = onNextClick
            )
        }
    }
}

@Preview
@Composable
fun PreviewPastTenseFourthScreen() {
    WDeutschTheme {
        Surface {
            PastTenseFourthScreen(
                onPreviousClick = {},
                onNextClick = {}
            )

        }
    }
}