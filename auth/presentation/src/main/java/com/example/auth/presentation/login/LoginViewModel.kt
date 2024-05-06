@file:OptIn(ExperimentalFoundationApi::class)

package com.example.auth.presentation.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.domain.AuthRepository
import com.example.auth.domain.UserDataValidator
import com.example.auth.presentation.registration.RegisterEvent
import com.example.core.domain.util.DataError
import com.example.core.domain.util.Result
import com.example.core.presentation.ui.UiText
import com.example.core.presentation.ui.asUiText
import com.milemarkert.auth.presentation.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userDataValidator: UserDataValidator,
    private val repository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val eventChannel = Channel<LoginEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        combine(state.email.textAsFlow(), state.password.textAsFlow()) { email, password ->
            state = state.copy(
                canLogin = userDataValidator.isValidEmail(email.toString().trim()) && password.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> register()
            LoginAction.OnRegisterClick -> Unit
            LoginAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            state = state.copy(isLoggingIn = true)
            val result = repository.login(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isLoggingIn = false)

            when (result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.UNAUTHORIZED) {
                        eventChannel.send(
                            LoginEvent.Error(
                                UiText.StringResource(R.string.error_email_password_incorrect)
                            )
                        )
                    }
                    eventChannel.send(LoginEvent.Error(result.error.asUiText()))
                }

                is Result.Success -> eventChannel.send(LoginEvent.LoginSuccess)
            }
        }
    }
}