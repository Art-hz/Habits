package com.artshz.habits.authentication.register.presentation

data class SignUpState(
    val email: String = "",
    val password: String = "",
    val emailValid: Boolean = true,
    val passwordValid: Boolean = true,
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val signUp: Boolean = false,
    val goToSignIn: Boolean = false
)
