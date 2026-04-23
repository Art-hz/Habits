package com.artshz.habits.authentication.login.domain.usecase

class ValidatePasswordUseCase {
    operator fun invoke(password: String): PasswordResult {
        if (password.length < 8) return PasswordResult.Invalid("Debe contener al menos 8 caracteres")
        if (password.none { it.isUpperCase() }) return PasswordResult.Invalid("Debe contener al menos una letra mayúscula")
        if (password.none { it.isLowerCase() }) return PasswordResult.Invalid("Debe contener al menos una letra minúscula")
        if (password.none { it.isDigit() }) return PasswordResult.Invalid("Debe contener al menos un número")
        return PasswordResult.Valid
    }
}

sealed class PasswordResult {
    object Valid: PasswordResult()
    data class Invalid(val message: String): PasswordResult()
}