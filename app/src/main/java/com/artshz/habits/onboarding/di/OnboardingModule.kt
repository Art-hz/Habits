package com.artshz.habits.onboarding.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.artshz.habits.onboarding.data.OnboardingRepositoryImpl
import com.artshz.habits.onboarding.domain.repository.OnboardingRepository
import com.artshz.habits.onboarding.domain.usecase.CompleteOnbUseCase
import com.artshz.habits.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object OnboardingModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("habits_onb_preferences", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideOnboardingRepository(sharedPrefs: SharedPreferences): OnboardingRepository {
        return OnboardingRepositoryImpl(sharedPrefs)
    }

    @Provides
    @Singleton
    fun provideHasSeenOnboardingUseCase(repository: OnboardingRepository): HasSeenOnboardingUseCase =
         HasSeenOnboardingUseCase(repository)

    @Provides
    @Singleton
    fun provideCompleteOnboardingUseCase(repository: OnboardingRepository): CompleteOnbUseCase =
        CompleteOnbUseCase(repository)

}