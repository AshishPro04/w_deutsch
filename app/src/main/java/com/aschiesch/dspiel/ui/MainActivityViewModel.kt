package com.aschiesch.dspiel.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivityViewModel: ViewModel() {
    private val _bottomBarState: MutableStateFlow<WDeutschScreen> = MutableStateFlow(WDeutschScreen.HOME)
    val bottomBarState: StateFlow<WDeutschScreen> = _bottomBarState.asStateFlow()
    fun updateBottomBarState(screen: WDeutschScreen) {
        _bottomBarState.value = screen
    }
}