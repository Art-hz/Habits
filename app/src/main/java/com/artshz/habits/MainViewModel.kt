package com.artshz.habits

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.artshz.habits.authentication.login.domain.usecase.GetUserIdUseCase
import com.artshz.habits.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hasSeenOnboardingUseCase: HasSeenOnboardingUseCase,
    private val getUserIdUseCase: GetUserIdUseCase
): ViewModel() {
    var hasSeenOnb by mutableStateOf(hasSeenOnboardingUseCase())
        private set

    var isLoggedIn by mutableStateOf(getUserIdUseCase() != null)
        private set

}