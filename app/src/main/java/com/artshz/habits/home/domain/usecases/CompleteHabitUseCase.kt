package com.artshz.habits.home.domain.usecases

import com.artshz.habits.home.domain.models.Habit
import com.artshz.habits.home.domain.repository.IndexRepository
import java.time.ZonedDateTime

class CompleteHabitUseCase(private val indexRepository: IndexRepository) {
    suspend operator fun invoke(habit: Habit, date: ZonedDateTime) {
        val newHabit = if (habit.completedDates.contains(date.toLocalDate())) {
            habit.copy(completedDates = habit.completedDates - date.toLocalDate())
        } else {
            habit.copy(completedDates = habit.completedDates + date.toLocalDate())
        }
        indexRepository.insertHabit(newHabit)
    }
}