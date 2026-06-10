package com.artshz.habits.home.domain.usecases

import com.artshz.habits.home.domain.models.Habit
import com.artshz.habits.home.domain.repository.IndexRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.ZonedDateTime

class GetHabitsForDateUseCase(private val indexRepository: IndexRepository) {
    suspend operator fun invoke(date: ZonedDateTime): Flow<List<Habit>> {
        return indexRepository.getHabitsForSelectedDate(date)
    }
}