package data.di

import data.firestore.DataSource
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import org.koin.dsl.module

val dataModule = module {
    single { DataSource(get()) }
}

val firebaseModule = module {
    single<FirebaseFirestore> { Firebase.firestore }
}