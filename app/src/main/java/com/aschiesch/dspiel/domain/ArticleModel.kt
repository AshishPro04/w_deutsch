package com.aschiesch.dspiel.domain

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.aschiesch.dspiel.data.quiz.ArticleResource

data class ArticleModel(
    val currentQuestion: String,
    val answer: String,
    val option1: String,
    val option2: String,
    val option3: String,
)

@Composable
fun ArticleResource.toArticleModel() = ArticleModel(
    currentQuestion = stringResource(id = question),
    answer = stringResource(id = answer),
    option1 = stringResource(id = option1),
    option2 = stringResource(id = option2),
    option3 = stringResource(id = option3)
)