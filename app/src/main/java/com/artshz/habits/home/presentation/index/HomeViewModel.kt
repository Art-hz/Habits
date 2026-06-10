package com.artshz.habits.home.presentation.index

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artshz.habits.home.domain.usecases.CompleteHabitUseCase
import com.artshz.habits.home.domain.usecases.GetHabitsForDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.time.LocalDate
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val insertHabitUseCase: CompleteHabitUseCase,
    private val getHabitsForDateUseCase: GetHabitsForDateUseCase
): ViewModel() {

    init {
        getHabitsForDate()
    }

    var state by mutableStateOf(HomeState())
        private set

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.OnDateSelected -> {
                state = state.copy(
                    selectedDate = event.date
                )
               getHabitsForDate()
            }
            is HomeEvent.OnSetCompleteForCertainDate -> {
                viewModelScope.launch {
                    insertHabitUseCase(event.habit, state.selectedDate)
                }
            }
        }
    }

    private fun getHabitsForDate() {
        viewModelScope.launch {
            getHabitsForDateUseCase(state.selectedDate).collectLatest { habits ->
                state = state.copy(
                    habits = habits
                )
            }
        }
        }
}