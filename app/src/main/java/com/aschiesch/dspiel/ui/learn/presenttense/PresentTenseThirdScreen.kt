package com.aschiesch.dspiel.ui.learn.presenttense

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.learn.BoxedContent
import com.aschiesch.dspiel.ui.learn.BoxedTitle
import com.aschiesch.dspiel.ui.learn.BulletedPoint
import com.aschiesch.dspiel.ui.learn.LessonParagraph
import com.aschiesch.dspiel.ui.learn.LessonSubTitle
import com.aschiesch.dspiel.ui.learn.LessonSubTitleSmall
import com.aschiesch.dspiel.ui.learn.NextButton
import com.aschiesch.dspiel.ui.learn.PreviousButton
import kotlinx.serialization.Serializable

@Serializable
object PresentTenseThirdScreen

@Composable
fun PresentTenseThirdScreen(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val columnScrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().padding(8.dp).verticalScroll(columnScrollState)) {
        LessonSubTitle(stringResource(R.string.irregular_verbs_header))
        LessonParagraph(stringResource(R.string.irregular_verbs_explanation))
        IrregularVerbConjugations()
        LessonSubTitleSmall(subTitle = stringResource(R.string.examples_header))
        BulletedPoint(stringResource(R.string.present_irregular_example_1))
        BulletedPoint(stringResource(R.string.present_irregular_example_2))
        BulletedPoint(stringResource(R.string.present_irregular_example_3))
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier.fillMaxWidth(),
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


@Composable
fun IrregularVerbConjugations() {
    val rowScrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rowScrollState)
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ){
            BoxedTitle(stringResource(R.string.verb))
            BoxedContent(stringResource(R.string.sein_tobe))
            BoxedContent(stringResource(R.string.haben_tohave))
            BoxedContent(stringResource(R.string.werden))
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(stringResource(R.string.ich))
            BoxedContent(stringResource(R.string.bin))
            BoxedContent(stringResource(R.string.habe))
            BoxedContent(stringResource(R.string.werde))
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(stringResource(R.string.du))
            BoxedContent(stringResource(R.string.bist))
            BoxedContent(stringResource(R.string.hast))
            BoxedContent(stringResource(R.string.wirst))
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(stringResource(R.string.er_sie_es))
            BoxedContent(stringResource(R.string.ist))
            BoxedContent(stringResource(R.string.hat))
            BoxedContent(stringResource(R.string.wird))
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(stringResource(R.string.wir))
            BoxedContent(stringResource(R.string.sind))
            BoxedContent(stringResource(R.string.haben))
            BoxedContent(stringResource(R.string.werden))
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(stringResource(R.string.ihr))
            BoxedContent(stringResource(R.string.seid))
            BoxedContent(stringResource(R.string.habt))
            BoxedContent(stringResource(R.string.werdet))
        }
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            BoxedTitle(stringResource(R.string.sie_sie))
            BoxedContent(stringResource(R.string.sind))
            BoxedContent(stringResource(R.string.haben))
            BoxedContent(stringResource(R.string.werden))
        }
    }
}