package data.firestore

import User
import dev.gitlive.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import presentation.screen.login.Ressource

class DataSource(private val firestoreInstance: FirebaseFirestore) {
    suspend fun addNewUser(user: User): Ressource<Unit> {
        return try {
            firestoreInstance.collection(USERS_COLLECTION).document(user.uuid).set(user)
            Ressource.Success(Unit)
        } catch (e: Exception) {
            Ressource.Error(e)
        }
    }

    suspend fun getUser(uuidUser: String): Flow<Ressource<User>> = flow {
        emit(Ressource.Loading())

        val documentSnapshot =
            firestoreInstance.collection(USERS_COLLECTION).document(uuidUser).get()
        if (documentSnapshot.exists) {
            val user = documentSnapshot.data<User>()
            emit(Ressource.Success(user))
        } else {
            emit(Ressource.Error())
        }
    }


    suspend fun updateUser(user: User): Ressource<Unit> = try {
        firestoreInstance.collection(USERS_COLLECTION).document(user.uuid).update(
            hashMapOf<String, Any>(
                "uuid" to user.uuid,
                "prenom" to user.prenom,
                "point" to user.point,
            )
        )
        Ressource.Success(Unit)
    } catch (e: Exception) {
        Ressource.Error(e)
    }


    suspend fun deleteUser(uuid: String): Ressource<Unit> = try {
        firestoreInstance.collection("users").document(uuid).delete()
        Ressource.Success(Unit)
    } catch (e: Exception) {
        Ressource.Error(e)
    }

    companion object {
        const val USERS_COLLECTION = "users"
    }
}