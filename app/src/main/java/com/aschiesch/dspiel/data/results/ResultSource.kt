package com.aschiesch.dspiel.data.results

import com.aschiesch.dspiel.R

object ResultSource {
    val excellent = ResultInfo(
        resultTitle = R.string.excellent_title,
        resultCategory = Result.EXCELLENT,
        resultLabel = R.string.excellent_label,
        resultMessage = R.string.excellent_description,
        resultImageOptions = listOf(
            R.drawable.excellent_one,
            R.drawable.excellent_two,
            R.drawable.excellent_three
        )
    )

    val good = ResultInfo(
        resultTitle = R.string.good_title,
        resultCategory = Result.GOOD,
        resultLabel = R.string.good_label,
        resultMessage = R.string.good_description,
        resultImageOptions = listOf(
            R.drawable.good_one,
            R.drawable.good_two,
            R.drawable.good_three
        )
    )

    val average = ResultInfo(
        resultTitle = R.string.average_title,
        resultCategory = Result.AVERAGE,
        resultLabel = R.string.average_label,
        resultMessage = R.string.average_description,
        resultImageOptions = listOf(
            R.drawable.average_one,
            R.drawable.average_two,
            R.drawable.average_three
        )
    )

    val fair = ResultInfo(
        resultTitle = R.string.fair_title,
        resultCategory = Result.FAIR,
        resultLabel = R.string.fair_label,
        resultMessage = R.string.fair_description,
        resultImageOptions = listOf(
            R.drawable.fair_one,
            R.drawable.fair_two,
            R.drawable.fair_three
        )
    )

    val poor = ResultInfo(
        resultTitle = R.string.needs_improvement_title,
        resultCategory = Result.POOR,
        resultLabel = R.string.needs_improvement_label,
        resultMessage = R.string.needs_improvement_description,
        resultImageOptions = listOf(
            R.drawable.failed_one,
            R.drawable.failed_two,
            R.drawable.failed_three
        )
    )
}