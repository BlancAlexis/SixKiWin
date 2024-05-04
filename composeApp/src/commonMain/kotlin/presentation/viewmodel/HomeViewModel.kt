package presentation.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel :  ScreenModel{

    private val _uiState = MutableStateFlow(HomeUiState(listOf("moi","pasmoi","moi","desmoi")))
    val uiState = _uiState.asStateFlow()

    init {

    }
}