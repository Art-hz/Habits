package com.artshz.habits.home.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {
     var detailState by mutableStateOf(DetailState())
         private set

    fun handleEvent(
        event: DetailEvents
    ) {
        when(event) {
            DetailEvents.DetailSave -> {
                detailState = detailState.copy(
                    isSaved = true
                )
            }
            is DetailEvents.FrequencyChange -> {
                detailState = detailState.copy(
                    frequency = event.list
                )
            }
            is DetailEvents.NameChange -> {
                detailState = detailState.copy(
                    habitName = event.name
                )
            }
            is DetailEvents.ReminderChange -> {
                detailState = detailState.copy(
                    reminder = event.time
                )
            }
        }
    }
}