package com.artshz.habits.authentication.register.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.artshz.habits.R
import com.artshz.habits.authentication.login.presentation.LoginEvent
import com.artshz.habits.core.presentation.HabitButton
import com.artshz.habits.core.presentation.HabitPasswordTextfield
import com.artshz.habits.core.presentation.HabitTextfield
import com.artshz.habits.core.presentation.HabitTitle


@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel<SignUpViewModel>(),
    onGoToSignIn: () -> Unit,
    onSignUp: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val signUpState: SignUpState = signUpViewModel.signUpState
    LaunchedEffect(signUpState) {
        if(signUpState.signUp){
            onSignUp()
        }

        if(signUpState.goToSignIn){
            onGoToSignIn()
        }

        if(signUpState.errorMessage.isNotBlank()){
            snackbarHostState.showSnackbar(
                message = signUpState.errorMessage,
                duration = SnackbarDuration.Short
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            val focusManager = LocalFocusManager.current
            Image(
                painter = painterResource(R.drawable.create_acc_logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.5f),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HabitTitle(
                    title = "Create your account",
                    modifier = Modifier.fillMaxWidth(0.7f).padding(vertical = 20.dp),
                    textSize = 19.sp
                )
            }


            HabitTextfield(
                value = signUpState.email,
                onValueChange = {
                    signUpViewModel.handleEvent(SignUpEvent.OnEmailChange(it))
                },
                placeholder = "Email",
                backgroundColor = Color.White,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(bottom = 7.dp),
                leadingIcon = Icons.Outlined.Email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, autoCorrect = false, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                errorMessage = signUpState.emailError,
                isEnabled = true
            )

            HabitPasswordTextfield(
                value = signUpState.password,
                onValueChange = {
                    signUpViewModel.handleEvent(SignUpEvent.OnPasswordChange(it))
                },
                contentDescription = "",
                backgroundColor = Color.White,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp).padding(horizontal = 20.dp),
                errorMessage = signUpState.passwordError,
                isEnabled = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, autoCorrect = false, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus()
                    signUpViewModel.handleEvent(event = SignUpEvent.OnSignUp)
                }
            )

            HabitButton(
                text = "Create Account",
                enabled = signUpState.email.isNotBlank() && signUpState.password.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                signUpViewModel.handleEvent(SignUpEvent.OnSignUp)
            }
            TextButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {

                }) {
                Text(
                    text = buildAnnotatedString {
                        append("Already have an account? ")
                        withStyle(SpanStyle(fontWeight = Bold)) {
                            append("Sign in")
                        }
                    },
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }

        if(signUpState.isLoading) {
            CircularProgressIndicator()
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

}