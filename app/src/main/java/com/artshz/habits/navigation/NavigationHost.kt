package com.artshz.habits.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.artshz.habits.authentication.login.presentation.LoginScreen
import com.artshz.habits.onboarding.domain.repository.OnboardingRepository
import com.artshz.habits.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(NavigationRoute.Onboarding.route) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OnboardingScreen() {
                    navController.popBackStack()
                    navController.navigate(NavigationRoute.Login.route)
                }
            }
        }

        composable(NavigationRoute.Login.route) {
            LoginScreen()
        }
    }
}