package com.example.instadev.view.auth.login


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

// UI State
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)

// ViewModel
class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update { state ->
            state.copy(email = email)
        }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { state ->
            state.copy(password = password)
        }
        verifyLogin()
    }

    private fun verifyLogin() {
        val enabledLogin: Boolean = isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update { state ->
            state.copy(isLoginEnabled = enabledLogin)
        }
    }


    private fun isEmailValid(email: String): Boolean {
        return email.isNotBlank()
    }


    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
