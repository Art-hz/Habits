package com.artshz.habits.home.presentation.index

import com.artshz.habits.home.domain.models.Habit
import java.time.ZonedDateTime

sealed interface HomeEvent {
    data class OnDateSelected(val date: ZonedDateTime): HomeEvent
    data class OnSetCompleteForCertainDate(val habit: Habit): HomeEvent
}