package com.aschiesch.dspiel.ui.learn

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val columnScrollState = rememberScrollState(0)
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {
        LessonSubTitle(stringResource(R.string.conjugation_of_regular_verb_title))
        LessonParagraph(stringResource(R.string.conjugation_of_regular_verb_explanation))
        RegularVerbConjugationTable()
        LessonSubTitleSmall(stringResource(R.string.examples_header))
        BulletedPoint(stringResource(R.string.present_regular_example_1))
        BulletedPoint(stringResource(R.string.present_regular_example_2))
        BulletedPoint(stringResource(R.string.present_regular_example_3))
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PreviousButton(
                onClick = onPreviousClicked
            )
            NextButton(
                onClick = onNextClicked
            )
        }
    }
}

@Composable
fun RegularVerbConjugationTable() {
    val scrollSate = rememberScrollState(0)
    Row(
        Modifier
            .horizontalScroll(scrollSate)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(
                text = stringResource(R.string.person)
            )
            BoxedContent(
                contentText = stringResource(R.string.ich_de_en)
            )
            BoxedContent(
                contentText = stringResource(R.string.du_de_en)
            )
            BoxedContent(
                contentText = stringResource(R.string.er_sie_es_de_en)
            )
            BoxedContent(
                contentText = stringResource(R.string.wir_de_en)
            )
            BoxedContent(
                contentText = stringResource(R.string.ihr_de_en)
            )
            BoxedContent(
                contentText = stringResource(R.string.sie_de_en)
            )
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(
                text = stringResource(R.string.ending_header)
            )
            BoxedContent(
                contentText = stringResource(R.string.ich_present_tense_ending)
            )
            BoxedContent(
                contentText = stringResource(R.string.du_present_tense_ending)
            )
            BoxedContent(
                contentText = stringResource(R.string.er_sie_es_present_tense_ending)
            )
            BoxedContent(
                contentText = stringResource(R.string.wir_present_tense_ending)
            )
            BoxedContent(
                contentText = stringResource(R.string.ihr_present_tense_ending)
            )
            BoxedContent(
                contentText = stringResource(R.string.er_sie_es_present_tense_ending)
            )
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(
                text = stringResource(R.string.example_learner_header)
            )
            BoxedContent(
                contentText = stringResource(R.string.ich_present_tense_example)
            )
            BoxedContent(
                contentText = stringResource(R.string.du_present_tense_example)
            )
            BoxedContent(
                contentText = stringResource(R.string.er_sie_es_present_tense_example)
            )
            BoxedContent(
                contentText = stringResource(R.string.wir_present_tense_example)
            )
            BoxedContent(
                contentText = stringResource(R.string.ihr_present_tense_example)
            )
            BoxedContent(
                contentText = stringResource(R.string.sie_present_tense_example)
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
