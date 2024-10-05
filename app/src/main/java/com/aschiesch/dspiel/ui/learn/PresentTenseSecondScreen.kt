package com.aschiesch.dspiel.ui.learn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PresentTenseSecondScreen

@Composable
fun PresentTenseSecondScreen(
    onPreviousClicked: () -> Unit = {},
    onNextClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LessonSubTitle(stringResource(R.string.conjugation_of_regular_verb_title))
        LessonParagraph(stringResource(R.string.conjugation_of_regular_verb_explanation))
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PreviousButton(
                onClick = onPreviousClicked
            )
            NextButton(
                onClick = onNextClicked
            )
        }
    }
}


@Preview
@Composable
fun PresentTenseSecondScreenPreview() {
    WDeutschTheme {
        Surface {
            PresentTenseSecondScreen()
        }
    }
}
