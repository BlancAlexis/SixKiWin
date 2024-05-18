package presentation.screen.login

import androidx.compose.foundation.ExperimentalFoundationApi
import data.datasource.UserDataSource
import data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import presentation.Route
import util.Ressource

@OptIn(ExperimentalFoundationApi::class)
class LoginViewModel(
    private val userDataSource: UserDataSource
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    init {
        println("init")
getUsersAvailable()
        println("initFinish")
    }

    fun createUser(firstname : String){
        viewModelScope.launch {
            when(userDataSource.addNewUser(User(firstname = firstname))){
                is Ressource.Error -> println("error")
                is Ressource.Loading -> println("loading")
                is Ressource.Success -> getUsersAvailable()
            }

        }
    }

    fun getUsersAvailable(){
        viewModelScope.launch {
            userDataSource.getUsers().collect {
                when (it) {
                    is Ressource.Error -> println(it.error)
                    is Ressource.Loading -> println("loading")
                    is Ressource.Success ->{
                        println(it.data)
                        updateUserName(it.data!!)
                    }
                }
            }
        }
    }
    fun updateUserName(ListUser: List<User>) {
        _uiState.update {
            it.copy(listUser = ListUser)
        }
    }

    fun test() {
        println("cc c moi")
    }

    fun onEvent(startEvent: StartEvent) {
        when(startEvent){
            StartEvent.create -> createUser(uiState.value.textFieldState.text.toString())

        }
    }


}

sealed interface StartEvent {
    object create : StartEvent

}