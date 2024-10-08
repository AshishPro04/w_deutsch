package com.aschiesch.dspiel.ui

import androidx.lifecycle.ViewModel
import com.aschiesch.dspiel.data.quiz.QuizMode
import com.aschiesch.dspiel.data.quiz.ArticleResource
import com.aschiesch.dspiel.data.quiz.ArticleSource
import com.aschiesch.dspiel.data.quiz.NumberSource
import com.aschiesch.dspiel.data.quiz.TimeResource
import com.aschiesch.dspiel.data.quiz.VerbConjugationResource
import com.aschiesch.dspiel.data.results.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel(
) : ViewModel() {

    private val _articleType: MutableStateFlow<String> = MutableStateFlow("")

    private var quizItems: List<ArticleResource> = updateArticleResource(_articleType.value)

    private fun updateArticleResource(newArticleType: String) = when (newArticleType) {
        QuizMode.DEFINITE_ARTICLE.name -> ArticleSource.definitiveArticles.shuffled()
        QuizMode.INDEFINITE_ARTICLE.name -> ArticleSource.indefiniteArticles.shuffled()
        QuizMode.NEGATIVE_ARTICLE.name -> ArticleSource.negativeArticles.shuffled()
        QuizMode.SINGLE_DIGIT.name -> NumberSource.numbersSingleDigitNumeric.shuffled()
        QuizMode.DOUBLE_DIGIT.name -> NumberSource.numbersDoubleDigitNumeric.shuffled()
        QuizMode.TRIPLE_DIGIT.name -> NumberSource.numbersTripleDigitNumeric.shuffled()
        QuizMode.VERB_CONJUGATIONS_1.name -> VerbConjugationResource.verbConjugations1.shuffled()
            .take(30)

        QuizMode.VERB_CONJUGATIONS_2.name -> VerbConjugationResource.verbConjugations2.shuffled()
            .take(30)

        QuizMode.VERB_CONJUGATIONS_3.name -> VerbConjugationResource.verbConjugations3.shuffled()
            .take(30)

        QuizMode.TIME_1.name -> TimeResource.timeGuess1.shuffled().take(30)
        QuizMode.TIME_2.name -> TimeResource.timeGuess2.shuffled().take(30)
        QuizMode.DATE.name -> TimeResource.dateResources.shuffled().take(30)
        else -> listOf()
    }

    private var _uiState: MutableStateFlow<QuizUiState> = MutableStateFlow(
        QuizUiState(
            score = 0,
            currentQuestionNumber = 0,
            totalQuestion = 0,
            currentQuestion = 0,
            currentAnswer = 0,
            options = listOf(),
            isGameOver = false,
            result = null
        )
    )
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()



    private fun setUpInitialState() {
        initUIState(
            score = 0,
            currentQuestionNumber = 1,
            totalQuestion = quizItems.size,
            currentQuestion = quizItems[0].question,
            currentAnswer = quizItems[0].answer,
            options = quizItems[0].options
        )
    }

    fun changeGame(articleType: String) {
        _articleType.update {
            articleType
        }
        quizItems = updateArticleResource(articleType)
        setUpInitialState()
    }


    private fun initUIState(
        score: Int = 0,
        currentQuestionNumber: Int = 1,
        totalQuestion: Int,
        currentQuestion: Int,
        currentAnswer: Int,
        options: List<Int>,
        isGameOver: Boolean = false
    ) {
        _uiState.update {
            it.copy(
                score = score,
                currentQuestionNumber = currentQuestionNumber,
                totalQuestion = totalQuestion,
                currentQuestion = currentQuestion,
                currentAnswer = currentAnswer,
                isGameOver = isGameOver,
                options = options.shuffled()
            )
        }
    }

    fun updateScore(score: Int) {
        _uiState.update {
            it.copy(score = score)
        }
    }

    fun proceedToNext(
        nextQuestion: Int,
        nextAnswer: Int,
        options: List<Int>,
    ) {
        if (_uiState.value.currentQuestionNumber < _uiState.value.totalQuestion) {
            _uiState.update {
                it.copy(
                    currentQuestionNumber = it.currentQuestionNumber + 1,
                    currentQuestion = nextQuestion,
                    currentAnswer = nextAnswer,
                    options = options
                )
            }
        } else {
            _uiState.update {
                it.copy(isGameOver = true)
            }
        }
    }


    fun checkNextQuestion(
        answer: Int
    ): Boolean {
        if (answer == _uiState.value.currentAnswer && !_uiState.value.isGameOver) {
            updateScore(_uiState.value.score + 1)
        }
        if (_uiState.value.currentQuestionNumber < _uiState.value.totalQuestion) {
            quizItems[_uiState.value.currentQuestionNumber].let {
                proceedToNext(
                    nextQuestion = it.question,
                    nextAnswer = it.answer,
                    options = it.options
                )
            }
        } else {
            setResult()
            _uiState.update {
                it.copy(isGameOver = true)
            }
            return false
        }
        return true
    }

    private fun setResult() {
        val percentageScored = _uiState.value.run {
            (score / totalQuestion.toFloat() * 100)
        }
        when {
            percentageScored >= 90f -> {
                _uiState.update {
                    it.copy(result = Result.EXCELLENT)
                }
            }

            percentageScored >= 80f -> {
                _uiState.update {
                    it.copy(result = Result.GOOD)
                }
            }

            percentageScored >= 70f -> {
                _uiState.update {
                    it.copy(result = Result.AVERAGE)
                }
            }

            percentageScored >= 60f -> {
                _uiState.update {
                    it.copy(result = Result.FAIR)
                }
            }

            else -> {
                _uiState.update {
                    it.copy(result = Result.POOR)
                }
            }
        }
    }

    fun resetState() {
        _uiState.update {
            it.copy(
                score = 0,
                currentQuestionNumber = 0,
                totalQuestion = 0,
                currentQuestion = 0,
                currentAnswer = 0,
                options = listOf(),
                isGameOver = false,
                result = null
            )
        }
    }
}

