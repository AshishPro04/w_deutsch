package com.aschiesch.dspiel.ui

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.aschiesch.dspiel.ui.learn.LearnGraph

val destinations = listOf(HomeScreen, LearnGraph, PrivacyPolicyScreen)
fun NavDestination.bottomBarRequired(): Boolean {
    return destinations.any { destination ->
        this.hierarchy.any { currentDestination ->
            currentDestination.hasRoute(destination::class)
        }
    }
}