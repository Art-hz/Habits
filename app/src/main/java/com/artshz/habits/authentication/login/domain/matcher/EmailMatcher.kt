package com.artshz.habits.authentication.login.domain.matcher

import java.util.regex.Pattern

interface EmailMatcher {
    fun isValid(email: String): Boolean
}