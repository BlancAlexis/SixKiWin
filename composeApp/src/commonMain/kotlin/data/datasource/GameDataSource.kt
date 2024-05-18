package data.datasource

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuidFrom
import data.datasource.UserDataSource.Companion.USERS_COLLECTION
import data.firestore.GameModel
import data.model.DataPlayer
import data.model.Game
import data.model.User
import dev.gitlive.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import util.Ressource

class GameDataSource(private val firestoreInstance: FirebaseFirestore, private val userDataSource: UserDataSource, private val dataSource: DataPlayerDataSource) {

    suspend fun addNewPartie(partie: Game): Ressource<Unit> {
        return try {
            firestoreInstance.collection(PARTIES_COLLECTION).document(partie.id.toString()).set(partie)
            Ressource.Success(Unit)
        } catch (e: Exception) {
            Ressource.Error(e)
        }
    }

    suspend fun getPartie(partieId: String): Flow<Ressource<Game>> = flow {
        emit(Ressource.Loading())
        val documentSnapshot = firestoreInstance.collection(PARTIES_COLLECTION).document(partieId).get()
        if (documentSnapshot.exists) {
            val model = documentSnapshot.data<GameModel>()

            val players = model.joueurs.map { joueurId -> dataSource.getDataplayer(joueurId).data!! }.toList()
            // Handle Joueur references
            val winners = model.vainqueur?.let {
               userDataSource.getUser(it).collect {
                   it.data
               }
              /*      if (it is Ressource.Success) {
                        it.data
                    } else {
                        null
                    }
                }*/
            }

            val partie = Game(
                id = uuidFrom(partieId),
                date = model.date,
                playersDatas = players,
                //Faire joueur winner
            )
            emit(Ressource.Success(partie))
        } else {
            emit(Ressource.Error())
        }
    }


/*
    suspend fun updatePartie(partie: Game): Ressource<Unit> = try {
        firestoreInstance.collection(PARTIES_COLLECTION).document(partie.id.toString()).update(
            hashMapOf<String, Any>(
                "date" to partie.date,
                "joueurs" to partie.joueurs,
                "vainqueur" to partie.vainqueur
            )
        )
        Ressource.Success(Unit)
    } catch (e: Exception) {
        Ressource.Error(e)
    }
*/

    suspend fun deletePartie(partieId: String): Ressource<Unit> = try {
        firestoreInstance.collection(PARTIES_COLLECTION).document(partieId).delete()
        Ressource.Success(Unit)
    } catch (e: Exception) {
        Ressource.Error(e)
    }

    companion object {
        const val PARTIES_COLLECTION = "GAMES"
    }
}