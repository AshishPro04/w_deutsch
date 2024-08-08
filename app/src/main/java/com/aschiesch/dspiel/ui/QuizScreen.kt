package com.aschiesch.dspiel.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aschiesch.dspiel.navigatePopBackStack

@Composable
fun QuizScreen(
    quizViewModel: QuizViewModel = viewModel(),
){
    val navController = rememberNavController()
    Surface {
        NavHost(
            navController = navController,
            startDestination = WDeutschScreen.ARTICLE.name
        ) {
            composable(WDeutschScreen.ARTICLE.name) {
                ArticleScreen(quizViewModel){
                    navController.navigate(WDeutschScreen.RESULT.name) {
                        launchSingleTop = true
                        popUpTo(WDeutschScreen.RESULT.name) {
                            inclusive = false
                        }
                    }
                }
            }
            composable(WDeutschScreen.RESULT.name) {
                ResultScreen(quizViewModel){
                    navController.navigatePopBackStack(WDeutschScreen.HOME.name)
                }
            }
        }
    }
}