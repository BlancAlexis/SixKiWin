package presentation.screen.login

import User
import data.firestore.DataSource
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class LoginViewModel constructor(dataSource: DataSource
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()
    init {
        /*println("init")
        viewModelScope.launch {
            dataSource.addNewUser(User("ss", "Alexis"))
        }*/
        viewModelScope.launch {
            dataSource.getUser("mxDyfZn9znGm1FLWVD9q").collect{
                when(it){
                    is Ressource.Error -> println(it.error)
                    is Ressource.Loading -> println("loading")
                    is Ressource.Success -> println(it.data)
                }
            }
        }
        println("initFinish")
    }

    fun test(){
        println("cc c moi")
    }

   /* fun createUser(){
        viewModelScope.launch {
            dataSource.addNewUser(User("d","Alexis", listOf(3)))

        }
    }*/
}
