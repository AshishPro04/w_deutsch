package com.aschiesch.dspiel.ui

fun String.bottomBarRequired(): Boolean {
    return this == WDeutschScreen.HOME.name || this == WDeutschScreen.PRIVACY_POLICY.name || this == WDeutschScreen.LEARN.name
}