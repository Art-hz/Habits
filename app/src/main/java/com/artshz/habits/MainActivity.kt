package com.artshz.habits

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.artshz.habits.navigation.NavigationHost
import com.artshz.habits.navigation.NavigationRoute
import com.artshz.habits.onboarding.data.OnboardingRepositoryImpl
import com.artshz.habits.ui.theme.HabitsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            HabitsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        NavigationHost(
                            navController = navController,
                            startDestination = getStartDestination()
                        )
                    }

                }
            }
        }
    }

    private fun getStartDestination(): NavigationRoute {
        if (viewModel.isLoggedIn) {
            return NavigationRoute.Home
        }
        if (viewModel.hasSeenOnb) {
            return NavigationRoute.Login
        }
        return NavigationRoute.Onboarding

    }
}

