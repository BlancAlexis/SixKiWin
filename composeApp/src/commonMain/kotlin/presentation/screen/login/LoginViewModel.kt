package presentation.screen.login

import User
import data.firestore.DataSource
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class LoginViewModel constructor(
    private val dataSource: DataSource
): ViewModel() {
    init {

    }

    fun test(){
        println("cc c moi")
    }

    fun createUser(){
        viewModelScope.launch {
            dataSource.addNewUser(User("d","Alexis", listOf(3)))

        }
    }
}
