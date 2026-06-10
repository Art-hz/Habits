package com.artshz.habits.home.domain.repository

import com.artshz.habits.home.domain.models.Habit
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.ZonedDateTime

interface IndexRepository {
    fun getHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)

}