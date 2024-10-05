package com.aschiesch.dspiel.ui.learn

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
object LearnGraph

fun NavGraphBuilder.learnGraph(navController: NavController) {
    navigation<LearnGraph>(startDestination = LearnHomeScreen) {
        composable<LearnHomeScreen> {
            LearnHomeScreen(
                onPresentTenseClicked = {navController.navigate(PresentTenseFirstScreen)}
            )
        }
        composable<PresentTenseFirstScreen>() {
            PresentTenseFirstScreen(
                onNextClicked = {
                    navController.navigate(PresentTenseSecondScreen)
                }
            )
        }
        composable<PresentTenseSecondScreen> {
            PresentTenseSecondScreen(
                onPreviousClicked = {
                    navController.navigateUp()
                },
                onNextClicked = {
                    navController.navigate(PresentTenseThirdScreen)
                }
            )
        }
        composable<PresentTenseThirdScreen> {
            PresentTensThirdScreen()
        }
    }
}