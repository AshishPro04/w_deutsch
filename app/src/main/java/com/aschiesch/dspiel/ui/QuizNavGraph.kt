package com.aschiesch.dspiel.ui

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.aschiesch.dspiel.sharedViewModel
import kotlinx.serialization.Serializable

@Serializable
object QuizNavGraph

fun NavGraphBuilder.quizNavGraph(
    navController: NavController
) {
    navigation<QuizNavGraph>(
        startDestination = HomeScreen
    ) {
        composable<HomeScreen>(
            enterTransition = {
                scaleIn(
                    animationSpec = tween(300),
                    initialScale = 0.5f
                ) + fadeIn(
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                scaleOut(
                    animationSpec = tween(300),
                    targetScale = 2f
                ) + fadeOut(
                    animationSpec = tween(300)
                )
            }
        ) {
            HomeScreen { articleType ->
                navController.navigate(ArticleScreen(articleType = articleType)) {
                    launchSingleTop = true
                    popUpTo(HomeScreen) {
                        inclusive = false
                    }
                }
            }
        }
        composable<ArticleScreen>(
            enterTransition = {
                scaleIn(
                    animationSpec = tween(300),
                    initialScale = 0.5f
                ) + fadeIn(
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                scaleOut(
                    animationSpec = tween(300),
                    targetScale = 0.5f
                ) + fadeOut(
                    animationSpec = tween(300)
                )
            }
        ) { navBackStackEntry ->
            val arguments = navBackStackEntry.toRoute<ArticleScreen>()
            val articleType = arguments.articleType
            Log.d("ArticleScreen", "articleType: $articleType")

            val viewModel: QuizViewModel = navBackStackEntry.sharedViewModel(
                navController,
                argumentType = arguments.articleType
            )
            ArticleScreen(viewModel){
                navController.navigate(ResultScreen) {
                    launchSingleTop = true
                    popUpTo(HomeScreen) {
                        inclusive = false
                    }
                }
            }
        }

        composable<ResultScreen>(
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(
                        durationMillis = 500,
                        delayMillis = 400
                    )
                ) {
                    it
                }
            },
            exitTransition = {
                slideOutVertically(
                    animationSpec = tween(
                        durationMillis = 500
                    )
                ) {
                    -it
                }
            }
        ) { navBackStackEntry ->
            val arguments = navBackStackEntry.toRoute<ArticleScreen>()
            val viewModel: QuizViewModel = navBackStackEntry.sharedViewModel(
                navController,
                argumentType = arguments.articleType
            )
            ResultScreen (viewModel){
                navController.navigate(HomeScreen) {
                    launchSingleTop = true
                    popUpTo(HomeScreen) {
                        inclusive = false
                    }
                }
            }
        }
    }
}