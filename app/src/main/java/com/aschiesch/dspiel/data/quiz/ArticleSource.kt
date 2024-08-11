package com.aschiesch.dspiel.data.quiz

import com.aschiesch.dspiel.R

object ArticleSource {
    val negativeArticles: List<ArticleResource> = listOf()
    private val definiteArticleOptions = listOf(
        R.string.definite_article_nominative_option_1,
        R.string.definite_article_nominative_option_2,
        R.string.definite_article_nominative_option_3,
    )
    val definitiveArticles = listOf(
        ArticleResource(
            question = R.string.definite_article_nominative_question_1,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_2,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_3,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_4,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_5,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_6,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_7,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_8,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_9,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_10,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_11,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_12,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_13,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_14,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_15,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_16,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_17,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_18,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_19,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_20,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_21,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_22,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_23,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_24,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_25,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_26,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_27,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_28,
            answer = R.string.definite_article_nominative_option_1,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_29,
            answer = R.string.definite_article_nominative_option_2,
            options = definiteArticleOptions
        ),
        ArticleResource(
            question = R.string.definite_article_nominative_question_30,
            answer = R.string.definite_article_nominative_option_3,
            options = definiteArticleOptions
        )
    )
    private val indefinitiveArticleOptions = listOf(
        R.string.indefinite_article_nominative_option_1,
        R.string.indefinite_article_nominative_option_2
    )
    val indefiniteArticles = listOf(
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_1,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_2,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_3,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_4,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_5,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_6,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_7,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_8,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_9,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_10,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_11,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_12,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_13,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_14,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_15,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_16,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_17,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_18,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_19,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_20,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_21,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_22,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_23,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_24,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_25,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_26,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_27,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_28,
            answer = R.string.indefinite_article_nominative_option_1,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_29,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        ),
        ArticleResource(
            question = R.string.indefinite_article_nominative_question_30,
            answer = R.string.indefinite_article_nominative_option_2,
            options = indefinitiveArticleOptions
        )
    )
}