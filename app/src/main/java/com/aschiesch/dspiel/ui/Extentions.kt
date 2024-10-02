package com.aschiesch.dspiel.ui

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy

val destinations = listOf(HomeScreen, LearnScreen, PrivacyPolicyScreen)
fun NavDestination.bottomBarRequired(): Boolean {
    return destinations.any { destination ->
        this.hierarchy.any { currentDestination ->
            currentDestination.hasRoute(destination::class)
        }
    }
}