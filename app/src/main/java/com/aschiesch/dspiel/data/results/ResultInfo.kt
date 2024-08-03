package com.aschiesch.dspiel.data.results

import androidx.annotation.StringRes

data class ResultInfo(
    @StringRes val resultTitle: Int,
    val resultCategory: Result,
    @StringRes val resultMessage: Int,
    @StringRes val resultImage: Int
)
