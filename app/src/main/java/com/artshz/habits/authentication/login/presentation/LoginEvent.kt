package com.artshz.habits.authentication.login.presentation

sealed interface LoginEvent {
    data class OnEmailChange(val email: String) : LoginEvent
    data class OnPasswordChange(val password: String) : LoginEvent
    object OnLogin: LoginEvent
    object OnSignUp: LoginEvent
}