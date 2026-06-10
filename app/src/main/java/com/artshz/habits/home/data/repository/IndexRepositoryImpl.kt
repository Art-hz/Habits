package com.artshz.habits.home.data.repository

import com.artshz.habits.home.domain.models.Habit
import com.artshz.habits.home.domain.repository.IndexRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

class IndexRepositoryImpl: IndexRepository {

    private val mockHabits = (1..30).map {
        val dates = mutableListOf<LocalDate>()
        if(it % 2 == 0) {
            dates.add(LocalDate.now())
        }
        Habit(
            id = it.toString(),
            name = "Habit $it",
            frequency = listOf(),
            completedDates = dates,
            reminder = LocalTime.now(),
            startDate = ZonedDateTime.now()
        )
    }.toMutableList()

    override fun getHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>> {
        return flowOf(mockHabits)
    }

    override suspend fun insertHabit(habit: Habit) {
        val indexHab = mockHabits.indexOfFirst { it.id == habit.id }
        mockHabits.removeAt(indexHab)
        mockHabits.add(indexHab, habit)
    }
}