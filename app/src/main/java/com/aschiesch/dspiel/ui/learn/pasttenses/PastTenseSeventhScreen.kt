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
import com.aschiesch.dspiel.ui.learn.FinishButton
import com.aschiesch.dspiel.ui.learn.LessonTitle
import com.aschiesch.dspiel.ui.learn.PreviousButton
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PastTenseSeventhScreen

@Composable
fun PastTenseSeventhScreen(
    onPreviousClick: () -> Unit = {},
    onFinishClick: () -> Unit = {}
) {
    val columnScrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(8.dp).fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonTitle(stringResource(R.string.summary_header))
        BulletedPoint(
            text = stringResource(R.string.summary_point_1),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp
        )
        BulletedPoint(
            text = stringResource(R.string.summary_point_2),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Row (
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(onClick = onPreviousClick)
            FinishButton(onClick = onFinishClick)
        }
    }
}

@Preview
@Composable
fun PastTenseSeventhScreenPreview() {
    WDeutschTheme {
        Surface {
            PastTenseSeventhScreen()
        }
    }
}