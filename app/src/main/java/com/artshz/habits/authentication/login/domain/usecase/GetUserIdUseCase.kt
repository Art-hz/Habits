package com.artshz.habits.authentication.login.domain.usecase

import com.artshz.habits.authentication.login.domain.repository.AuthenticationRepository

class GetUserIdUseCase(private val repository: AuthenticationRepository)  {
    operator fun invoke(): String? {
        return repository.getUserId()
    }
}