package com.artshz.habits.authentication.login.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artshz.habits.authentication.login.domain.repository.AuthenticationRepository
import com.artshz.habits.authentication.login.domain.usecase.LoginUseCase
import com.artshz.habits.authentication.login.domain.usecase.PasswordResult
import com.artshz.habits.authentication.login.domain.usecase.ValidateMailUseCase
import com.artshz.habits.authentication.login.domain.usecase.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateMailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val loginUseCase: LoginUseCase
): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.OnEmailChange -> {

                state = state.copy(email = event.email)
            }
            is LoginEvent.OnPasswordChange -> {

                state = state.copy(password = event.password)
            }
            LoginEvent.OnLogin -> {
                login()
                state = state.copy(isLoggedIn = true)
            }
            LoginEvent.OnSignUp -> {
                state = state.copy(signUp = true)
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            val passwordResult = validatePasswordUseCase.invoke(state.password)
            if(passwordResult is PasswordResult.Invalid){
                state = state.copy(
                    passwordError = passwordResult.message
                )
            } else {
                state = state.copy(
                    passwordError = null
                )
            }

            if(!validateEmailUseCase.invoke(state.email)) {
                state = state.copy(emailError = "Email inválido")
            } else {
                state = state.copy(emailError = null)
            }

            if(state.emailError != null || state.passwordError != null) return@launch

            state = state.copy(isLoading = true)
            val result = loginUseCase.invoke(state.email, state.password)
            result.onSuccess {
                state = state.copy(isLoggedIn = true)
                Log.e("LoginViewModel", "login: success")
                //go to dashboard
            }
            result.onFailure {
             state = state.copy(
                 errorMessage = it.message
             )
            }
            state = state.copy(isLoading = false)
        }
        }
}
