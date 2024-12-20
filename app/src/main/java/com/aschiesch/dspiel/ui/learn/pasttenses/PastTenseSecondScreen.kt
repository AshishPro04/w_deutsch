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
object PastTenseSecondScreen

@Composable
fun PastTenseSecondScreen(
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    val columnScrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonTitle(
            stringResource(R.string.formation_of_prateritm_header)
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.prateritum_regular_verbs_caption),
            text = stringResource(R.string.prateritum_regular_verbs_explanation),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_header),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_example_6),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.prateritum_regular_verbs_caption),
            text = stringResource(R.string.prateritum_irregular_verbs_explanation),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_header),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_irregular_verbs_example_6),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(
                onClick = onPreviousClick
            )
            Spacer(modifier = Modifier.weight(1f))
            NextButton(
                onClick = onNextClick
            )

        }
    }
}

@Preview
@Composable
fun PreviewPastTenseSecondScreen() {
    WDeutschTheme {
        Surface {
            PastTenseSecondScreen()
        }
    }
}