package presentation.screen.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import data.model.User

data class LoginUiState @OptIn(ExperimentalFoundationApi::class) constructor(
    val listUser: List<User> = listOf(),
    val textFieldState: TextFieldState = TextFieldState()
)
