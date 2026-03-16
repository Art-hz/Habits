package com.artshz.habits.navigation

sealed class NavigationRoute(val route: String) {
    object Onboarding : NavigationRoute("onboarding")

}