package presentation.screen.home

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import moe.tlaster.precompose.viewmodel.ViewModel

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(listOf("moi", "pasmoi", "moi", "desmoi")))
    val uiState = _uiState.asStateFlow()

    init {

    }
}