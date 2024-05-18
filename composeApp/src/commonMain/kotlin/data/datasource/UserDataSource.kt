package data.datasource

import com.benasher44.uuid.uuidFrom
import data.model.User
import dev.gitlive.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import util.Ressource

class UserDataSource(private val firestoreInstance: FirebaseFirestore) {
    suspend fun addNewUser(user: User): Ressource<Unit> {
        return try {
            firestoreInstance.collection(USERS_COLLECTION).document(user.uuid.toString()).set(user)
            println("success")
            Ressource.Success(Unit)
        } catch (e: Exception) {
            println("catch ${e}")
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

    suspend fun getUsers(): Flow<Ressource<List<User>>> = flow {
        emit(Ressource.Loading())
        val documentSnapshot = firestoreInstance.collection(USERS_COLLECTION).get()
        val a: MutableList<User> = mutableListOf<User>()
        if (documentSnapshot.documents != null) {
            documentSnapshot.documents.map {
                val user = it.data<User>()
                user.uuid = uuidFrom(it.id)
                a.add(it.data<User>())
            }
            emit(Ressource.Success(a))
        } else {
            emit(Ressource.Error())
        }
    }


    suspend fun updateUser(user: User): Ressource<Unit> = try {
        firestoreInstance.collection(USERS_COLLECTION).document(user.uuid.toString()).update(
            hashMapOf<String, Any>(
                "uuid" to user.uuid,
                "firstname" to user.firstname,
                "podium" to user.podium,
                "totalPoints" to user.totalPoints
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
        const val USERS_COLLECTION = "USERS"
    }
}