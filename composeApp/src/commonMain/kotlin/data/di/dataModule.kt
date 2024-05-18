package data.di

import com.benasher44.uuid.Uuid
import data.datasource.UserDataSource
import data.model.UuidSerializer
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import org.koin.dsl.module

val dataModule = module {
    single { UserDataSource(get()) }
}

val firebaseModule = module {
    single<FirebaseFirestore> { Firebase.firestore }
}
