package com.aschiesch.dspiel.ui.learn.pasttenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
object PastTenseThirdScreen

@Composable
fun PastTenseThirdScreen(
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    val columnScrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ){
        LessonTitle(
            title = stringResource(R.string.formation_of_perfekt_header)
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.perfekt_auxiliary_verbs_caption),
            text = stringResource(R.string.perfekt_auxiliary_verbs_explanation),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_haben_description),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_sein_description),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPointWithBoldCaption(
            caption = stringResource(R.string.perfekt_past_participle_caption),
            text = stringResource(R.string.perfekt_past_participle_explanation),
            fontSize = 20.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_header),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_spielen_6),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_heder),
            modifier = Modifier.padding(start = 32.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_1),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_2),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_3),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_4),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_5),
            modifier = Modifier.padding(start = 64.dp),
            fontSize = 16.sp
        )
        BulletedPoint(
            text = stringResource(R.string.perfekt_past_participle_example_gehen_6),
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