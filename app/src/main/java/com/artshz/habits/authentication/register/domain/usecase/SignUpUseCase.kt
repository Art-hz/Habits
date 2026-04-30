package com.artshz.habits.authentication.register.domain.usecase

import com.artshz.habits.authentication.login.domain.repository.AuthenticationRepository

class SignUpUseCase(private val repository: AuthenticationRepository) {

    suspend operator fun invoke(email: String, password: String): Result<Unit> {
          return repository.signUp(email = email, password = password)
    }
}