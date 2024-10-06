package com.aschiesch.dspiel

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material.icons.twotone.School
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.aschiesch.dspiel.ui.HomeScreen
import com.aschiesch.dspiel.ui.learn.LearnGraph
import com.aschiesch.dspiel.ui.PrivacyPolicyScreen
import com.aschiesch.dspiel.ui.QuizNavGraph
import com.aschiesch.dspiel.ui.bottomBarRequired
import com.aschiesch.dspiel.ui.learn.learnGraph
import com.aschiesch.dspiel.ui.quizNavGraph
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlin.math.roundToInt
import kotlin.reflect.KClass


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WDeutschTheme {
                val navController = rememberNavController()
                val currentScreen by navController.currentBackStackEntryAsState()
                val currentDestination = currentScreen?.destination
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        WDeutschTopBar()
                    },
                    bottomBar = {
                        WDeutschBottomBar(
                            currentDestination = currentDestination,
                            onHomeClicked = {
                                navController.navigatePopBackStack(HomeScreen)
                            },
                            onInfoClicked = {
                                navController.navigatePopBackStack(PrivacyPolicyScreen)
                            },
                            onLearnClicked = {
                                navController.navigatePopBackStack(LearnGraph)
                            },
                            visible = currentDestination?.bottomBarRequired() ?: false
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = QuizNavGraph,
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        quizNavGraph(navController)

                        learnGraph(navController = navController)

                        composable<PrivacyPolicyScreen>() {
                            PrivacyPolicyScreen()
                        }
                    }
                }
            }
        }
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
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.tertiary
                            ),
                            tileMode = TileMode.Clamp
                        ),
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
        currentDestination: NavDestination?,
        onHomeClicked: () -> Unit = {},
        onInfoClicked: () -> Unit = {},
        onLearnClicked: () -> Unit = {},
        visible: Boolean
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ) {
                it
            },
            exit = slideOutVertically(
                animationSpec = tween(300)
            ) {
                it
            }
        ) {
            BottomAppBar(

                modifier = Modifier.fillMaxWidth(),
                actions = {
                    val destinations = listOf(HomeScreen, LearnGraph, PrivacyPolicyScreen)
                    destinations.forEach { destination ->
                        currentDestination?.hierarchy?.any {
                            it.hasRoute(destination::class)
                        }
                    }
                    val isAtHome = currentDestination?.hierarchy?.any { route ->
                        route.hasRoute(HomeScreen::class)
                    } == true
                    val isAtPrivacy = currentDestination?.hierarchy?.any { route ->
                        route.hasRoute(PrivacyPolicyScreen::class)
                    } == true
                    val isAtLearn = currentDestination?.hierarchy?.any { route ->
                        route.hasRoute(LearnGraph::class)
                    } == true
                    val homeIcon = if (isAtHome) Icons.TwoTone.Home else Icons.Outlined.Home
                    val infoIcon = if (isAtPrivacy) Icons.TwoTone.Info else Icons.Outlined.Info
                    val learnIcon = if (isAtLearn) Icons.TwoTone.School else Icons.Outlined.School
                    WDeutschBottomAction(
                        currentDestination = currentDestination,
                        icon = homeIcon,
                        iconName = R.string.home,
                        onHomeClicked = onHomeClicked,
                        modifier = Modifier.weight(1f),
                        currentScreen = HomeScreen::class
                    )
                    WDeutschBottomAction(
                        currentDestination = currentDestination,
                        icon = learnIcon,
                        iconName = R.string.learn,
                        onHomeClicked = onLearnClicked,
                        modifier = Modifier.weight(1f),
                        currentScreen = LearnGraph::class
                    )
                    WDeutschBottomAction(
                        currentDestination = currentDestination,
                        icon = infoIcon,
                        iconName = R.string.privacy_policy,
                        onHomeClicked = onInfoClicked,
                        modifier = Modifier.weight(1f),
                        currentScreen = PrivacyPolicyScreen::class
                    )
                }
            )
        }
    }

    @Composable
    private fun <T : Any> WDeutschBottomAction(
        currentDestination: NavDestination?,
        icon: ImageVector,
        @StringRes iconName: Int,
        onHomeClicked: () -> Unit,
        modifier: Modifier = Modifier,
        currentScreen: KClass<T>
    ) {
        Log.d("CurrentScreen", ": ${currentDestination?.route}")
        IconButton(
            onClick = onHomeClicked,
            modifier = modifier
        ) {
            val selected = currentDestination?.hierarchy?.any { route ->
                route.hasRoute(currentScreen)
            } == true
            val transition = updateTransition(targetState = selected, label = "bottomBarIcon")
            val color by transition.animateColor(label = "itemColor") { isActive ->
                if (isActive)
                    MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            }
            val scale by transition.animateFloat(label = "itemShadow") { isActive ->
                if (isActive) 1f else 0.9f
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        val scaledHeight = (placeable.height * scale).roundToInt()
                        val scaledWidth = (placeable.width * scale).roundToInt()
                        val xPos = (scaledWidth - placeable.width) / 2
                        val yPos = (scaledHeight - placeable.height) / 2
                        layout(width = scaledWidth, height = scaledHeight) {
                            placeable.placeRelative(xPos, yPos)
                        }
                    }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(id = iconName),
                    tint = color,
                    )
                Text(
                    text = stringResource(id = iconName),
                    color = color,
                    style = MaterialTheme.typography.labelMedium
                )
            }
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
                currentDestination = null,
                visible = true
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

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController
): T {
    val navGraphRoute =
        destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

fun NavController.navigatePopBackStack(type: Any) {
    navigate(type) {
        launchSingleTop = true
        popUpTo<HomeScreen>() {
            inclusive = false
        }
    }
}

