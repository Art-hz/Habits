package com.artshz.habits.authentication.register.presentation

sealed interface SignUpEvent {
    data class OnEmailChange(val email: String) : SignUpEvent
    data class OnPasswordChange(val password: String) : SignUpEvent
    object OnSignUp : SignUpEvent
    object OnGoToSignIn: SignUpEvent
}