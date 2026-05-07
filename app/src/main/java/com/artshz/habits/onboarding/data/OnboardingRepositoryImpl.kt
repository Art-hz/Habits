package com.artshz.habits.onboarding.data

import android.content.SharedPreferences
import com.artshz.habits.onboarding.domain.repository.OnboardingRepository
import androidx.core.content.edit

class OnboardingRepositoryImpl(
    private val sharedPref: SharedPreferences
): OnboardingRepository {

    companion object {
        private const val HAS_SEEN_ONBOARDING = "has_seen_onboarding"
        private const val IS_LOGGED_IN = "is_logged_in"
    }

    override fun hasSeenOnboarding(): Boolean
        = sharedPref.getBoolean(
        HAS_SEEN_ONBOARDING,
            false
        )


    override fun completeOnboarding() {
        sharedPref.edit { putBoolean(HAS_SEEN_ONBOARDING, true) }
    }

}