package com.aschiesch.dspiel.data.quiz

import androidx.annotation.StringRes

data class QuizInfo(
    @StringRes val nameId: Int,
    val quizMode: QuizMode
)