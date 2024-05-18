package data.model

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import dev.gitlive.firebase.firestore.Timestamp

data class Game(
    val id: Uuid = uuid4(),
    val date: Timestamp,
    val playersDatas: List<DataPlayer>, // Use JoueurData instead of Joueur to avoid circular reference
    val winner: User? = null
){
}