package com.aschiesch.dspiel.data.results

import androidx.annotation.StringRes

data class ResultInfo(
    @StringRes val resultTitle: Int,
    @StringRes val resultLabel: Int,
    val resultCategory: Result,
    @StringRes val resultMessage: Int,
    val resultImageOptions: List<Int>
) {
    // Randomly select an image from the list whenever the resultImage property is accessed.
    val resultImage: Int get() = resultImageOptions.random()
}
