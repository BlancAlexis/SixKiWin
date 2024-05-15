package data.di

import org.koin.dsl.module
import presentation.screen.home.HomeViewModel
import presentation.screen.login.LoginViewModel
import presentation.screen.startgame.StartGameViewModel

val vmModule = module {
    factory { LoginViewModel(get()) }
    factory { HomeViewModel() }
    factory { StartGameViewModel() }
}