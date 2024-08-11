package com.aschiesch.dspiel.data.quiz

import androidx.annotation.StringRes

data class ArticleResource(
    @StringRes val question: Int,
    @StringRes val answer: Int,
    val options: List<Int>
)
