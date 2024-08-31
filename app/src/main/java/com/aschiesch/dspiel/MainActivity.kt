package com.aschiesch.dspiel

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aschiesch.dspiel.data.quiz.QuizMode
import com.aschiesch.dspiel.ui.ArticleScreen
import com.aschiesch.dspiel.ui.HomeScreen
import com.aschiesch.dspiel.ui.MainActivityViewModel

import com.aschiesch.dspiel.ui.QuizViewModel
import com.aschiesch.dspiel.ui.QuizViewModelFactory
import com.aschiesch.dspiel.ui.ResultScreen
import com.aschiesch.dspiel.ui.WDeutschScreen
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import com.aschiesch.dspiel.ui.theme.gBlack
import com.aschiesch.dspiel.ui.theme.gRed
import com.aschiesch.dspiel.ui.theme.gYellow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WDeutschTheme {
                val navController = rememberNavController()
                val currentScreen by navController.currentBackStackEntryAsState()
                val currentRoute = currentScreen?.destination?.route ?: "Nill"
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        WDeutschTopBar()
                    },
                    bottomBar = {
                        WDeutschBottomBar(
                            currentRoute = currentRoute,
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
                            HomeScreen(
                                onQuizOpen = { articleType ->
                                    navController
                                        .navigatePopBackStack("${WDeutschScreen.QUIZ.name}/$articleType")
                                }
                            )
                        }
                        navigation(
                            route = "${WDeutschScreen.QUIZ.name}/{articleType}",
                            startDestination = "${WDeutschScreen.ARTICLE.name}/{articleType}",
                            arguments = listOf(navArgument("articleType") {
                                type = NavType.StringType
                            })
                        ) {

                            composable(
                                "${WDeutschScreen.ARTICLE.name}/{articleType}",
                                arguments = listOf(navArgument("articleType") {
                                    type = NavType.StringType
                                    defaultValue = QuizMode.DEFINITE_ARTICLE.name
                                })
                            ) {
                                val articleType = it.arguments?.getString("articleType")
                                Log.d("QUIZ", "Recieved Article name: $articleType")
                                val viewModelFactory = QuizViewModelFactory(
                                    articleType ?: QuizMode.DEFINITE_ARTICLE.name
                                )
                                val viewModel: QuizViewModel = it.sharedViewModel(
                                    navController,
                                    articleType ?: QuizMode.DEFINITE_ARTICLE.name,
                                    viewModelFactory
                                )
                                ArticleScreen(viewModel) {
                                    navController.navigate(WDeutschScreen.RESULT.name) {
                                        launchSingleTop = true
                                        popUpTo(WDeutschScreen.ARTICLE.name) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                            composable(WDeutschScreen.RESULT.name) {
                                val articleType = it.arguments?.getString("articleType")
                                val viewModelFactory = QuizViewModelFactory(
                                    articleType ?: QuizMode.DEFINITE_ARTICLE.name
                                )
                                val viewModel: QuizViewModel = it.sharedViewModel(
                                    navController,
                                    articleType ?: QuizMode.DEFINITE_ARTICLE.name,
                                    viewModelFactory
                                )
                                ResultScreen(viewModel) {
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
        quizType: String,
        viewModelFactory: QuizViewModelFactory = QuizViewModelFactory(quizType)
    ): T {
        val navGraphRoute =
            destination.parent?.route ?: return viewModel(factory = viewModelFactory)
        val parentEntry = remember(this) {
            navController.getBackStackEntry(navGraphRoute)
        }
        return viewModel(parentEntry, factory = viewModelFactory)
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
                    style = MaterialTheme.typography.displaySmall.copy(
                        brush = Brush.verticalGradient(
                            colors = listOf(gBlack, gRed, gYellow),
                            tileMode = TileMode.Clamp,
                            startY = 20f,
                            endY = 90.0f
                        )
                    ),
                )
            },
            modifier = Modifier.shadow(
                elevation = 4.dp
            )
        )
    }

    @Composable
    fun WDeutschBottomBar(
        currentRoute: String,
        onHomeClicked: () -> Unit = {},
        onInfoClicked: () -> Unit = {}
    ) {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            actions = {
                WDeutschBottomAction(
                    currentRoute = currentRoute,
                    icon = Icons.Outlined.Home,
                    iconName = R.string.home,
                    onHomeClicked = onHomeClicked,
                    modifier = Modifier.weight(1f),
                    screenRoute = WDeutschScreen.HOME.name
                )
                WDeutschBottomAction(
                    currentRoute = currentRoute,
                    icon = Icons.Outlined.Info,
                    iconName = R.string.privacy_policy,
                    onHomeClicked = onInfoClicked,
                    modifier = Modifier.weight(1f),
                    screenRoute = WDeutschScreen.PRIVACY_POLICY.name
                )
            }
        )
    }

    @Composable
    private fun WDeutschBottomAction(
        currentRoute: String,
        icon: ImageVector,
        @StringRes iconName: Int,
        onHomeClicked: () -> Unit,
        modifier: Modifier = Modifier,
        screenRoute: String
    ) {
        Log.d("CurrentScreen", ": $currentRoute")
        LaunchedEffect(key1 = currentRoute) {
        }
        IconButton(
            onClick = onHomeClicked,
            modifier = modifier
        ) {
            val color = if (currentRoute == screenRoute) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            val tint by animateColorAsState(
                targetValue = color,
                label = "BottomBarTint",
                animationSpec = tween(300)
            )
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = iconName),
                tint = tint
            )
        }
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
            WDeutschBottomBar(
                currentRoute = WDeutschScreen.HOME.name
            )
        }
    }

    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun WDeutschTopBarPreview() {
        WDeutschTheme {
            WDeutschTopBar()
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

