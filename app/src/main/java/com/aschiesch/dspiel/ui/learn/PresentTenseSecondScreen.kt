package com.aschiesch.dspiel.ui.learn

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
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
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LessonSubTitle(stringResource(R.string.conjugation_of_regular_verb_title))
        LessonParagraph(stringResource(R.string.conjugation_of_regular_verb_explanation))
        RegularVerbConjugationTable()
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
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
    Row(Modifier.fillMaxWidth().padding(8.dp).verticalScroll(scrollSate)) {
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
                text = stringResource(R.string.example_learner_header),
                modifier = Modifier.basicMarquee()
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
                contentText = stringResource(R.string.er_sie_es_present_tense_example),
            )
        }
    }
}

@Composable
fun BoxedText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current
) {
    val tableBorderWidth = 1f.dp

    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .border(width = tableBorderWidth, color = MaterialTheme.colorScheme.outline)
            .padding(8.dp),
        style = style,
        maxLines = 1
    )
}

@Composable
fun BoxedTitle(text: String, modifier: Modifier = Modifier) {
    BoxedText(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge.copy(
            color = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun BoxedContent(contentText: String, modifier: Modifier = Modifier) {
    BoxedText(
        text = contentText,
        modifier = modifier,
        style = MaterialTheme.typography.labelMedium
    )
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
