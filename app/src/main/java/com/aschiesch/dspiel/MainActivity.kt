package com.aschiesch.dspiel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.aschiesch.dspiel.ui.ArticleScreen
import com.aschiesch.dspiel.ui.HomeScreen

import com.aschiesch.dspiel.ui.QuizViewModel
import com.aschiesch.dspiel.ui.ResultScreen
import com.aschiesch.dspiel.ui.WDeutschScreen
import com.aschiesch.dspiel.ui.theme.WDeutschTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WDeutschTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        WDeutschTopBar()
                    },
                    bottomBar = {
                        WDeutschBottomBar(
                            onHomeClicked = {
                                navController.navigatePopBackStack(WDeutschScreen.HOME.name)
                            },
                            onInfoClicked = {
                                navController.navigatePopBackStack(WDeutschScreen.PRIVACY_POLICY.name)
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = WDeutschScreen.HOME.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(WDeutschScreen.HOME.name) {
                            HomeScreen() {
                                navController.navigatePopBackStack(WDeutschScreen.QUIZ.name)
                            }
                        }
                        navigation(
                            route = WDeutschScreen.QUIZ.name,
                            startDestination = WDeutschScreen.ARTICLE.name) {

                            composable(WDeutschScreen.ARTICLE.name) {
                                val viewModel: QuizViewModel = it.sharedViewModel(navController)
                                ArticleScreen(viewModel){

                                    navController.navigate(WDeutschScreen.RESULT.name) {
                                        launchSingleTop = true
                                        popUpTo(WDeutschScreen.ARTICLE.name) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                            composable(WDeutschScreen.RESULT.name) {
                                val viewModel: QuizViewModel = it.sharedViewModel(navController)
                                ResultScreen(viewModel){
                                    navController.navigatePopBackStack(WDeutschScreen.HOME.name)
                                }
                            }
                        }
                        composable(WDeutschScreen.PRIVACY_POLICY.name) {

                        }
                    }
                }
            }
        }
    }

    @Composable
    inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
        navController: NavController,
    ): T {
        val navGraphRoute = destination.parent?.route ?: return viewModel()
        val parentEntry  = remember(this){
            navController.getBackStackEntry(navGraphRoute)
        }
        return viewModel(parentEntry)
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun WDeutschTopBar() {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displaySmall
                    )
            },
            modifier = Modifier.shadow(
                elevation = 4.dp,
                shape = CutCornerShape(bottomEnd = 50f, bottomStart = 50f)
            ),
        )
    }

    @Composable
    fun WDeutschBottomBar(onHomeClicked: () -> Unit = {}, onInfoClicked: () -> Unit = {}) {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            actions = {
                IconButton(
                    onClick = onHomeClicked,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = stringResource(id = R.string.home)
                    )
                }
                IconButton(
                    onClick = onInfoClicked,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = stringResource(id = R.string.privacy_policy)
                    )
                }
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        WDeutschTheme {
            Greeting("Android")
        }
    }

    @Preview
    @Composable
    fun WDeutschBottomBarPreview() {
        WDeutschTheme {
            WDeutschBottomBar()
        }
    }
}

fun NavController.navigatePopBackStack(route: String) {
    navigate(route) {
        launchSingleTop = true
        popUpTo(WDeutschScreen.HOME.name) {
            inclusive = false
        }
    }
}

