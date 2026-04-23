package com.artshz.habits.authentication.login.domain.usecase

import com.artshz.habits.authentication.login.domain.repository.AuthenticationRepository

class LoginUseCase(private val repository: AuthenticationRepository) {
    suspend operator fun invoke(email: String, pass: String): Result<Unit> {
        return repository.login(email, pass)
    }
}