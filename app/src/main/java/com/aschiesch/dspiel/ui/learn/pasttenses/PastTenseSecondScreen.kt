package com.aschiesch.dspiel.ui.learn.pasttenses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Serializable
object PastTenseSecondScreen

@Composable
fun PastTenseSecondScreen() {
    val columnScrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(columnScrollState)
    ) {

    }
}