package com.artshz.habits.authentication.login.di

import com.artshz.habits.authentication.login.data.matcher.EmailMatcherImpl
import com.artshz.habits.authentication.login.data.repository.AuthenticationRepositoryImpl
import com.artshz.habits.authentication.login.domain.matcher.EmailMatcher
import com.artshz.habits.authentication.login.domain.repository.AuthenticationRepository
import com.artshz.habits.authentication.login.domain.usecase.LoginUseCase
import com.artshz.habits.authentication.login.domain.usecase.ValidateMailUseCase
import com.artshz.habits.authentication.login.domain.usecase.ValidatePasswordUseCase
import com.artshz.habits.authentication.register.domain.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AuthenticationModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(): AuthenticationRepository = AuthenticationRepositoryImpl()

    @Provides
    @Singleton
    fun provideEmailMatcher(): EmailMatcher = EmailMatcherImpl()

    @Provides
    @Singleton
    fun provideValidateEmailUseCase(emailMatcher: EmailMatcher): ValidateMailUseCase = ValidateMailUseCase(emailMatcher)

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase = ValidatePasswordUseCase()

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthenticationRepository): LoginUseCase = LoginUseCase(repository)

    @Provides
    @Singleton
    fun provideSignUpUseCase(repository: AuthenticationRepository): SignUpUseCase = SignUpUseCase(repository)
}