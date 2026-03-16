package com.artshz.habits.onboarding.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.artshz.habits.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen() {
    val pagerPages = listOf(
        "Title1",
        "Title2",
        "Title3"
    )
    OnboardingPager(pagerPages, modifier = Modifier.fillMaxSize()) { }
}