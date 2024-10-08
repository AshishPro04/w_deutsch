package com.aschiesch.dspiel.ui.learn

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.aschiesch.dspiel.ui.learn.pasttenses.PastTensesFirstScreen
import com.aschiesch.dspiel.ui.learn.presenttense.PresentTenseFifthScreen
import com.aschiesch.dspiel.ui.learn.presenttense.PresentTenseFirstScreen
import com.aschiesch.dspiel.ui.learn.presenttense.PresentTenseFourthScreen
import com.aschiesch.dspiel.ui.learn.presenttense.PresentTenseSecondScreen
import com.aschiesch.dspiel.ui.learn.presenttense.PresentTenseThirdScreen
import kotlinx.serialization.Serializable

@Serializable
object LearnGraph

fun NavGraphBuilder.learnGraph(navController: NavController) {
    navigation<LearnGraph>(startDestination = LearnHomeScreen) {
        composable<LearnHomeScreen> {
            LearnHomeScreen(
                onPresentTenseClicked = {navController.navigate(PresentTenseFirstScreen)},
                onPastTenseClicked = {navController.navigate(PastTensesFirstScreen)}
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
            PresentTenseThirdScreen(
                onPreviousClick = {
                    navController.navigateUp()
                },
                onNextClick = {
                    navController.navigate(PresentTenseFourthScreen)
                }
            )
        }
        composable<PresentTenseFourthScreen> {
            PresentTenseFourthScreen(
                onPreviousClick = {
                    navController.navigateUp()
                },
                onNextClick = {
                    navController.navigate(PresentTenseFifthScreen)
                }
            )
        }
        composable<PresentTenseFifthScreen> {
            PresentTenseFifthScreen(
                onPreviousClick = {
                    navController.navigateUp()
                },
                onCloseClick = {
                    navController.navigate(LearnHomeScreen) {
                        launchSingleTop = true
                        popUpTo<LearnHomeScreen>(){
                            inclusive = false
                        }
                    }
                }
            )
        }
        composable<PastTensesFirstScreen> {
            PastTensesFirstScreen()
        }
    }
}