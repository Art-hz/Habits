package com.artshz.habits.home.di

import com.artshz.habits.home.data.repository.IndexRepositoryImpl
import com.artshz.habits.home.domain.repository.IndexRepository
import com.artshz.habits.home.domain.usecases.CompleteHabitUseCase
import com.artshz.habits.home.domain.usecases.GetHabitsForDateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    fun provideIndexRepository(): IndexRepository {
        return IndexRepositoryImpl()
    }

    @Provides
    fun provideGetHabitsForDateUseCase(indexRepository: IndexRepository): GetHabitsForDateUseCase {
        return GetHabitsForDateUseCase(indexRepository)
    }

    @Provides
    fun provideCompleteHabitUseCase(indexRepository: IndexRepository): CompleteHabitUseCase {
        return CompleteHabitUseCase(indexRepository)
    }
}