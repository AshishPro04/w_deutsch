package com.aschiesch.dspiel.ui

import com.aschiesch.dspiel.data.results.Result

data class QuizUiState(
    val score: Int,
    val currentQuestionNumber: Int,
    val totalQuestion: Int,
    val currentQuestion: Int,
    val currentAnswer: Int,
    val userOption: String? = null,
    val options: List<Int>,
    val isGameOver: Boolean,
    val result: Result?
)
