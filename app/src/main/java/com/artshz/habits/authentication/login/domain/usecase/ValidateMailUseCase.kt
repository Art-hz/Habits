package com.artshz.habits.authentication.login.domain.usecase

import com.artshz.habits.authentication.login.domain.matcher.EmailMatcher


class ValidateMailUseCase(private val emailMatcher: EmailMatcher) {
    operator fun invoke(mail: String): Boolean {
        return emailMatcher.isValid(mail)
    }
}