package com.aschiesch.dspiel.data.results

import androidx.annotation.StringRes

data class ResultInfo(
    @StringRes val resultTitle: Int,
    @StringRes val resultLabel: Int,
    val resultCategory: Result,
    @StringRes val resultMessage: Int,
    val resultImageOptions: List<Int>
) {
    val resultImage: Int get() = resultImageOptions.random()
}
