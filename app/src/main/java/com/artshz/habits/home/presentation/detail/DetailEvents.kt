package com.artshz.habits.home.presentation.detail

import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZonedDateTime

sealed interface DetailEvents {
    data class ReminderChange(
        val time: LocalTime = LocalTime.now()
    ): DetailEvents

    data class FrequencyChange(
        val list: List<DayOfWeek> = emptyList()
    ): DetailEvents

    data class NameChange(
        val name: String
    ): DetailEvents

    object DetailSave: DetailEvents
}