package com.aschiesch.dspiel.data.quiz

import com.aschiesch.dspiel.R

object NumberSource {
    private val singleDigitNumericAnswers = listOf(
        R.string.number_1_digit_0_answer,
        R.string.number_1_digit_1_answer,
        R.string.number_1_digit_2_answer,
        R.string.number_1_digit_3_answer,
        R.string.number_1_digit_4_answer,
        R.string.number_1_digit_5_answer,
        R.string.number_1_digit_6_answer,
        R.string.number_1_digit_7_answer,
        R.string.number_1_digit_8_answer,
        R.string.number_1_digit_9_answer
    )
    val numbersSingleDigitNumeric = listOf(
        ArticleResource(
            question = R.string.number_1_digit_0,
            answer = R.string.number_1_digit_0_answer,
            options = R.string.number_1_digit_0_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_1,
            answer = R.string.number_1_digit_1_answer,
            options = R.string.number_1_digit_1_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_2,
            answer = R.string.number_1_digit_2_answer,
            options = R.string.number_1_digit_2_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_3,
            answer = R.string.number_1_digit_3_answer,
            options = R.string.number_1_digit_3_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_4,
            answer = R.string.number_1_digit_4_answer,
            options = R.string.number_1_digit_4_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_5,
            answer = R.string.number_1_digit_5_answer,
            options = R.string.number_1_digit_5_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_6,
            answer = R.string.number_1_digit_6_answer,
            options = R.string.number_1_digit_6_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_7,
            answer = R.string.number_1_digit_7_answer,
            options = R.string.number_1_digit_7_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_8,
            answer = R.string.number_1_digit_8_answer,
            options = R.string.number_1_digit_8_answer.shuffleWithSingleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_1_digit_9,
            answer = R.string.number_1_digit_9_answer,
            options = R.string.number_1_digit_9_answer.shuffleWithSingleDigitOptions()
        )
    )
    val doubleDigitAnswers = listOf(
        R.string.number_2_digit_1_answer,
        R.string.number_2_digit_2_answer,
        R.string.number_2_digit_3_answer,
        R.string.number_2_digit_4_answer,
        R.string.number_2_digit_5_answer,
        R.string.number_2_digit_6_answer,
        R.string.number_2_digit_7_answer,
        R.string.number_2_digit_8_answer,
        R.string.number_2_digit_9_answer,
        R.string.number_2_digit_10_answer,
        R.string.number_2_digit_11_answer,
        R.string.number_2_digit_12_answer,
        R.string.number_2_digit_13_answer,
        R.string.number_2_digit_14_answer,
        R.string.number_2_digit_15_answer,
        R.string.number_2_digit_16_answer,
        R.string.number_2_digit_17_answer,
        R.string.number_2_digit_18_answer,
        R.string.number_2_digit_19_answer,
        R.string.number_2_digit_20_answer,
        R.string.number_2_digit_21_answer,
        R.string.number_2_digit_22_answer,
        R.string.number_2_digit_23_answer,
        R.string.number_2_digit_24_answer,
        R.string.number_2_digit_25_answer,
        R.string.number_2_digit_26_answer,
        R.string.number_2_digit_27_answer,
        R.string.number_2_digit_28_answer,
        R.string.number_2_digit_29_answer,
        R.string.number_2_digit_30_answer
    )

    val numbersDoubleDigitNumeric = listOf(
        ArticleResource(
            question = R.string.number_2_digit_1,
            answer = R.string.number_2_digit_1_answer,
            options = R.string.number_2_digit_1_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_2,
            answer = R.string.number_2_digit_2_answer,
            options = R.string.number_2_digit_2_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_3,
            answer = R.string.number_2_digit_3_answer,
            options = R.string.number_2_digit_3_answer.shuffleWithDoubleDigitOptions()
        ),ArticleResource(
            question = R.string.number_2_digit_4,
            answer = R.string.number_2_digit_4_answer,
            options = R.string.number_2_digit_4_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_5,
            answer = R.string.number_2_digit_5_answer,
            options = R.string.number_2_digit_5_answer.shuffleWithDoubleDigitOptions()),
        ArticleResource(
            question = R.string.number_2_digit_6,
            answer = R.string.number_2_digit_6_answer,
            options = R.string.number_2_digit_6_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_7,
            answer = R.string.number_2_digit_7_answer,
            options = R.string.number_2_digit_7_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_8,
            answer = R.string.number_2_digit_8_answer,
            options = R.string.number_2_digit_8_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_9,
            answer = R.string.number_2_digit_9_answer,
            options = R.string.number_2_digit_9_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_10,
            answer = R.string.number_2_digit_10_answer,
            options = R.string.number_2_digit_10_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_11,
            answer = R.string.number_2_digit_11_answer,
            options = R.string.number_2_digit_11_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_12,
            answer = R.string.number_2_digit_12_answer,
            options = R.string.number_2_digit_12_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_13,
            answer = R.string.number_2_digit_13_answer,
            options = R.string.number_2_digit_13_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_14,
            answer = R.string.number_2_digit_14_answer,
            options = R.string.number_2_digit_14_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_15,
            answer = R.string.number_2_digit_15_answer,
            options = R.string.number_2_digit_15_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_16,
            answer = R.string.number_2_digit_16_answer,
            options = R.string.number_2_digit_16_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_17,
            answer = R.string.number_2_digit_17_answer,
            options = R.string.number_2_digit_17_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_18,
            answer = R.string.number_2_digit_18_answer,
            options = R.string.number_2_digit_18_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_19,
            answer = R.string.number_2_digit_19_answer,
            options = R.string.number_2_digit_19_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_20,
            answer = R.string.number_2_digit_20_answer,
            options = R.string.number_2_digit_20_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_21,
            answer = R.string.number_2_digit_21_answer,
            options = R.string.number_2_digit_21_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_22,
            answer = R.string.number_2_digit_22_answer,
            options = R.string.number_2_digit_22_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_23,
            answer = R.string.number_2_digit_23_answer,
            options = R.string.number_2_digit_23_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_24,
            answer = R.string.number_2_digit_24_answer,
            options = R.string.number_2_digit_24_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_25,
            answer = R.string.number_2_digit_25_answer,
            options = R.string.number_2_digit_25_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_26,
            answer = R.string.number_2_digit_26_answer,
            options = R.string.number_2_digit_26_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_27,
            answer = R.string.number_2_digit_27_answer,
            options = R.string.number_2_digit_27_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_28,
            answer = R.string.number_2_digit_28_answer,
            options = R.string.number_2_digit_28_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_29,
            answer = R.string.number_2_digit_29_answer,
            options = R.string.number_2_digit_29_answer.shuffleWithDoubleDigitOptions()
        ),
        ArticleResource(
            question = R.string.number_2_digit_30,
            answer = R.string.number_2_digit_30_answer,
            options = R.string.number_2_digit_30_answer.shuffleWithDoubleDigitOptions()
        )
    )


    private fun Int.shuffleWithSingleDigitOptions(): List<Int> {
        return shuffleWith3ListOptions(singleDigitNumericAnswers)
    }
    private fun Int.shuffleWithDoubleDigitOptions(): List<Int> {
        return shuffleWith3ListOptions(doubleDigitAnswers)
    }

    /* A function adding the integer to a list and get shuffled list with three objects,
    2 integers from the list and the given integer */
    private fun Int.shuffleWith3ListOptions(list: List<Int>): List<Int> {
        val shuffled = list.shuffled().take(2)
        if (this in shuffled) {
            return this.shuffleWith3ListOptions(list)
        }
        return shuffled.plus(this).shuffled()
    }
}