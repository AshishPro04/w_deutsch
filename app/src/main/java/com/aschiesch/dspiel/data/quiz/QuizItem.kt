package com.aschiesch.dspiel.data.quiz

import androidx.annotation.StringRes
import com.aschiesch.dspiel.R

data class QuizItem(
    @StringRes val quizGroupTitle: Int,
    val quizItems: List<QuizInfo>
) {
    companion object {
        val quizGroups = listOf(
            QuizItem(
                R.string.article,
                listOf(
                    QuizInfo(R.string.definite_article, QuizMode.DEFINITE_ARTICLE),
                    QuizInfo(R.string.indefinite_article, QuizMode.INDEFINITE_ARTICLE),
                    QuizInfo(R.string.indefinite_negative_article, QuizMode.NEGATIVE_ARTICLE)
                )
            ),
            QuizItem(
                R.string.numbers,
                listOf(
                    QuizInfo(R.string.single_digit, QuizMode.SINGLE_DIGIT),
                    QuizInfo(R.string.double_digit, QuizMode.DOUBLE_DIGIT),
                    QuizInfo(R.string.triple_digit, QuizMode.TRIPLE_DIGIT)
                )
            ),
            QuizItem(
                R.string.time_title,
                listOf(
                    QuizInfo(R.string.time_1, QuizMode.TIME_1),
                    QuizInfo(R.string.time_2, QuizMode.TIME_2),
                    QuizInfo(R.string.date, QuizMode.DATE)
                )
            ),
            QuizItem(
                R.string.verbs_title,
                listOf(
                    QuizInfo(R.string.verb_conjugations_1, QuizMode.VERB_CONJUGATIONS_1),
                    QuizInfo(R.string.verb_conjugations_2, QuizMode.VERB_CONJUGATIONS_2),
                    QuizInfo(R.string.verb_conjugations_3, QuizMode.VERB_CONJUGATIONS_3)
                )
            )
        )
    }
}