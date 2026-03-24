package com.artshz.habits.onboarding.domain.usecase

import com.artshz.habits.onboarding.domain.repository.OnboardingRepository

class CompleteOnbUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke() {
        repository.completeOnboarding()
    }
}