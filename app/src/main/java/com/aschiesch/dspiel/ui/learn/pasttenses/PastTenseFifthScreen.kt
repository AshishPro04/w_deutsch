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
import com.aschiesch.dspiel.ui.learn.LessonTitle
import com.aschiesch.dspiel.ui.learn.NextButton
import com.aschiesch.dspiel.ui.learn.PreviousButton
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PastTenseFifthScreen


@Composable
fun PastTenseFifthScreen(
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    val columnScrollState = rememberScrollState()

    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(state = columnScrollState)
    ){
        LessonTitle(title = stringResource(R.string.common_verbs_and_their_forms))
        BulletedPoint(
            text = stringResource(R.string.sein_to_be_header),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_caption),
            modifier = Modifier.padding(start = 32.dp)
        )
        BulletedPoint(
            text = stringResource(R.string.sein_prateritum_example_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_prateritum_example_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_prateritum_example_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_prateritum_example_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_prateritum_example_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_caption),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_perfekt_example_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_perfekt_example_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_perfekt_example_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_perfekt_example_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_perfekt_example_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.sein_perfekt_example_6),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        BulletedPoint(
            text = stringResource(R.string.haben_to_have_header),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.prateritum_caption),
            modifier = Modifier.padding(start = 32.dp)
        )
        BulletedPoint(
            text = stringResource(R.string.haben_prateritum_example_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_prateritum_example_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_prateritum_example_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_prateritum_example_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_prateritum_example_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_prateritum_example_6),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_caption),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_perfekt_example_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_perfekt_example_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_perfekt_example_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_perfekt_example_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_perfekt_example_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.haben_perfekt_example_6),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(onClick = onPreviousClick)
            NextButton(onClick = onNextClick)
        }

    }
}

@Preview
@Composable
fun PastTenseFifthScreenPreview() {
    WDeutschTheme {
        Surface {
            PastTenseFifthScreen()
        }
    }
}