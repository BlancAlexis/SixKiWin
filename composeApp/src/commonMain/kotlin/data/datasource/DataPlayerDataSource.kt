package data.datasource

import data.model.DataPlayer
import dev.gitlive.firebase.firestore.FirebaseFirestore
import util.Ressource

class DataPlayerDataSource(private val firestoreInstance: FirebaseFirestore) {
    suspend fun getDataplayer(dataId : String) : Ressource<DataPlayer> {
         val documentSnapshot = firestoreInstance.collection(PLAYERS_COLLECTION).document(dataId).get()
        return  if (documentSnapshot.exists){
                  Ressource.Success(documentSnapshot.data<DataPlayer>())
             }
             else{
                  Ressource.Error()
             }
    }

    companion object{
        const val PLAYERS_COLLECTION = "PLAYER"
    }
}