package com.aschiesch.dspiel.ui

import androidx.lifecycle.ViewModel
import com.aschiesch.dspiel.data.quiz.ArticleResource
import com.aschiesch.dspiel.data.quiz.ArticleSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
class QuizViewModel() : ViewModel() {
    private  val quizItems: List<ArticleResource> = ArticleSource.definitive_articles
    private var _uiState: MutableStateFlow<QuizUiState> = MutableStateFlow(
        QuizUiState(
            score = 0,
            currentQuestionNumber = 0,
            totalQuestion = 0,
            currentQuestion = 0,
            currentAnswer = 0,
            option1 = 0,
            option2 = 0,
            option3 = 0,
            isGameOver = false,
            result = null
        )
    )
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()


    init {
        initUIState(
            score = 0,
            currentQuestionNumber = 1,
            totalQuestion = quizItems.size,
            currentQuestion = quizItems[0].question,
            currentAnswer = quizItems[0].answer,
            option1 = quizItems[0].option1,
            option2 = quizItems[0].option2,
            option3 = quizItems[0].option3
        )
    }


    private fun initUIState(
        score: Int = 0,
        currentQuestionNumber: Int = 1,
        totalQuestion: Int,
        currentQuestion: Int,
        currentAnswer: Int,
        option1: Int,
        option2: Int,
        option3: Int,
        isGameOver: Boolean = false
    ) {
         _uiState.update {
            it.copy(
                score = score,
                currentQuestionNumber = currentQuestionNumber,
                totalQuestion = totalQuestion,
                currentQuestion = currentQuestion,
                currentAnswer = currentAnswer,
                option1 = option1,
                option2 = option2,
                option3 = option3,
                isGameOver = isGameOver
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
        nextOption1: Int,
        nextOption2: Int,
        nextOption3: Int
    ) {
        if (_uiState.value.currentQuestionNumber < _uiState.value.totalQuestion) {
            _uiState.update {
                it.copy(
                    currentQuestionNumber = it.currentQuestionNumber + 1,
                    currentQuestion = nextQuestion,
                    currentAnswer = nextAnswer,
                    option1 = nextOption1,
                    option2 = nextOption2,
                    option3 = nextOption3
                    )
            }
        } else {
            _uiState.update {
                it.copy(isGameOver = true)
            }
        }
    }

    fun isLastQuestion() = _uiState.value.currentQuestionNumber == _uiState.value.totalQuestion

    fun userClicked(
        answer: Int
    ) {
        if (answer == _uiState.value.currentAnswer && !_uiState.value.isGameOver) {
            updateScore(_uiState.value.score + 1)
        }
        if (_uiState.value.currentQuestionNumber < _uiState.value.totalQuestion){
            quizItems[_uiState.value.currentQuestionNumber].let {
                proceedToNext(
                    nextQuestion = it.question,
                    nextAnswer = it.answer,
                    nextOption1 = it.option1,
                    nextOption2 = it.option2,
                    nextOption3 = it.option3
                )
            }
        } else {
            _uiState.update {
                it.copy(isGameOver = true)
            }
        }
    }
}

