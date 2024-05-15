package presentation.screen.newPlayer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

data class NewPlayerUiState @OptIn(ExperimentalFoundationApi::class) constructor(
    val value : TextFieldState = TextFieldState(),
) {
}