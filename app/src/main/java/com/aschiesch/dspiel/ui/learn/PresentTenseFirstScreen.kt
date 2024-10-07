package com.aschiesch.dspiel.ui.learn

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object PresentTenseFirstScreen

@Composable
fun PresentTenseFirstScreen(onNextClicked: () -> Unit = {}) {
    val scrollState = rememberScrollState()
    Surface (modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
            LessonTitle(stringResource(R.string.present_tense_title))
            LessonParagraph(stringResource(R.string.present_tense_explanation))
            Spacer(modifier = Modifier.weight(1f))
            NextButton(
                onClick = onNextClicked,
                modifier = Modifier.align(alignment = Alignment.End).padding(8.dp)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PresentTenseFirstScreenPreview() {
    WDeutschTheme {
        PresentTenseFirstScreen()
    }
}