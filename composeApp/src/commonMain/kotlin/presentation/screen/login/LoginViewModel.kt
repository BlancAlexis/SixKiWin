package presentation.screen.login

import User
import data.firestore.DataSource
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class LoginViewModel constructor(
): ViewModel() {
    init {
        println("init")
Firebase.firestore
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
