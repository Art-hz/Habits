package com.artshz.habits.authentication.login.data.matcher

import android.util.Patterns
import com.artshz.habits.authentication.login.domain.matcher.EmailMatcher

class EmailMatcherImpl: EmailMatcher {
    override fun isValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}