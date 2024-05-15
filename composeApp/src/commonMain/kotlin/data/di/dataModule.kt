package data.di

import data.datasource.UserDataSource
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import org.koin.dsl.module

val dataModule = module {
    single { UserDataSource(get()) }
}

val firebaseModule = module {
    single<FirebaseFirestore> { Firebase.firestore }
}