package com.artshz.habits.authentication.register.presentation

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artshz.habits.authentication.login.domain.usecase.PasswordResult
import com.artshz.habits.authentication.login.domain.usecase.ValidateMailUseCase
import com.artshz.habits.authentication.login.domain.usecase.ValidatePasswordUseCase
import com.artshz.habits.authentication.register.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val validateEmailUseCase: ValidateMailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
): ViewModel() {
    var signUpState by mutableStateOf(SignUpState())
        private set

    fun handleEvent(event: SignUpEvent) {
        when(event) {
            is SignUpEvent.OnEmailChange -> {
                signUpState = signUpState.copy(email = event.email)
            }
            is SignUpEvent.OnPasswordChange -> {
                signUpState = signUpState.copy(password = event.password)
            }
            SignUpEvent.OnSignUp -> {
                signUp()
            }
            SignUpEvent.OnGoToSignIn -> {
                signUpState = signUpState.copy(
                    goToSignIn = true
                )
            }
        }
    }

    private fun signUp() {
        viewModelScope.launch {
            if(!validateEmailUseCase.invoke(signUpState.email)){
                signUpState = signUpState.copy(emailError = "Email inválido")
                return@launch
            } else signUpState = signUpState.copy(emailError = null)
            val passValidation = validatePasswordUseCase.invoke(signUpState.password)
            if(passValidation !is PasswordResult.Valid) {
                signUpState = signUpState.copy(
                    passwordError = (passValidation as PasswordResult.Invalid).message
                )
                return@launch
            } else signUpState = signUpState.copy(passwordError = null)
            signUpState = signUpState.copy(
                isLoading =  true
            )
            val resultSignUp = signUpUseCase.invoke(signUpState.email, signUpState.password)
            if(resultSignUp.isFailure) {
                signUpState = signUpState.copy(
                    errorMessage = resultSignUp.exceptionOrNull()?.message ?: "Unknown error"
                )
            } else if(resultSignUp.isSuccess) {
                signUpState = signUpState.copy(
                    signUp = true
                )
            }
            signUpState = signUpState.copy(
                isLoading =  true
            )
        }
    }
}