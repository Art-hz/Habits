package com.artshz.habits.home.presentation.index

import com.artshz.habits.home.domain.models.Habit
import java.time.ZonedDateTime

data class HomeState(
    val habits: List<Habit> = emptyList(),
    val selectedDate: ZonedDateTime = ZonedDateTime.now(),
    val currentDate: ZonedDateTime = ZonedDateTime.now(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)


