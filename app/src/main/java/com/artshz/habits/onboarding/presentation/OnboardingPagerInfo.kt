package com.artshz.habits.onboarding.presentation

import androidx.annotation.DrawableRes

data class OnboardingPagerInfo(
    @param:DrawableRes val image: Int,
    val title: String,
    val subtitle: String
)
