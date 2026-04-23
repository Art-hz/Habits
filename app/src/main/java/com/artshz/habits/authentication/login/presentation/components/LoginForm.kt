package com.artshz.habits.authentication.login.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.artshz.habits.authentication.login.presentation.LoginEvent
import com.artshz.habits.authentication.login.presentation.LoginState
import com.artshz.habits.core.presentation.HabitButton
import com.artshz.habits.core.presentation.HabitPasswordTextfield
import com.artshz.habits.core.presentation.HabitTextfield

@Composable
fun LoginForm(
    state: LoginState,
    modifier: Modifier = Modifier,
    onLoginEvent: (LoginEvent) -> Unit
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier.background(Color.White, shape = RoundedCornerShape(9.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login with email",
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        Divider(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), color = MaterialTheme.colorScheme.background)
        HabitTextfield(
            value = state.email,
            onValueChange = {
                onLoginEvent(LoginEvent.OnEmailChange(it))
            },
            placeholder = "Email",
            contentDescription = "",
            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp).padding(horizontal = 20.dp),
            leadingIcon = Icons.Outlined.Email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, autoCorrect = false, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions {
                focusManager.moveFocus(FocusDirection.Next)
            },
            errorMessage = state.emailError,
            isEnabled = !state.isLoading
        )

        HabitPasswordTextfield(
            value = state.password,
            onValueChange = {
                onLoginEvent(LoginEvent.OnPasswordChange(it))
            },
            contentDescription = "",
            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp).padding(horizontal = 20.dp),
            errorMessage = state.passwordError,
            isEnabled = !state.isLoading,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, autoCorrect = false, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions {
                focusManager.clearFocus()
                onLoginEvent(LoginEvent.OnLogin)
            }
        )

        HabitButton(
            text = "Login",
            enabled = state.email.isNotBlank() && state.password.isNotBlank() && !state.isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            onLoginEvent(LoginEvent.OnLogin)
        }

        TextButton(onClick = {}) {
            Text(text = "Forgot Password", color = MaterialTheme.colorScheme.tertiary, textDecoration = TextDecoration.Underline)
        }

        TextButton(onClick = {
            onLoginEvent(LoginEvent.OnSignUp)
        }) {
            Text(
                text = buildAnnotatedString {
                    append("Don't have an account? ")
                    withStyle(SpanStyle(fontWeight = Bold)) {
                        append("Sign up")
                    }
                },
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}