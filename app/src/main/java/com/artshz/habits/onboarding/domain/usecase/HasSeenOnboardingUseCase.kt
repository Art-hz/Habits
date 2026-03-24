package com.artshz.habits.onboarding.domain.usecase

import com.artshz.habits.onboarding.domain.repository.OnboardingRepository

class HasSeenOnboardingUseCase(
    private val repository: OnboardingRepository
){
    operator fun invoke(): Boolean = repository.hasSeenOnboarding()
}
