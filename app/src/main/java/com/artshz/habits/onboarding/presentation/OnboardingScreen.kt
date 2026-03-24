package com.artshz.habits.onboarding.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.artshz.habits.R
import com.artshz.habits.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    LaunchedEffect(
        key1 = viewModel.hasSeenOnb,
    ) {
        if (viewModel.hasSeenOnb) {
            onFinish()
        }
    }

    val pagerPages = listOf(
        OnboardingPagerInfo(
            image = R.drawable.pager_img1,
            title = "Welcome to\nMonumental Habits",
            subtitle = "We can help you to be a better version of yourself."
        ),
        OnboardingPagerInfo(
            image = R.drawable.pager_img2,
            title = "Create new habit easily",
            subtitle = "We can help you to be a better version of yourself."
        ),
        OnboardingPagerInfo(
            image = R.drawable.pager_img3,
            title = "Keep track of your progress",
            subtitle = "We can help you to be a better version of yourself."
        ),
        OnboardingPagerInfo(
            image = R.drawable.pager_img4,
            title = "Join a supportive community",
            subtitle = "We can help you to be a better version of yourself."
        ),
    )
    OnboardingPager(pagerPages, modifier = Modifier.fillMaxSize()) {
       viewModel.completeOnboarding()
    }
}