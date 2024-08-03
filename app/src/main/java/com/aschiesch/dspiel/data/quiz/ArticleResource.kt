package com.aschiesch.dspiel.data.quiz

import androidx.annotation.StringRes

data class ArticleResource(
    @StringRes val question: Int,
    @StringRes val answer: Int,
    @StringRes val option1: Int,
    @StringRes val option2: Int,
    @StringRes val option3: Int
)
