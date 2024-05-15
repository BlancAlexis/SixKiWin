package data.model

import dev.gitlive.firebase.firestore.Timestamp

data class Game(
    //val id: UUID = UUID.randomUUID(),
    val date: Timestamp,
    val playersDatas: List<DataPlayer>, // Use JoueurData instead of Joueur to avoid circular reference
    val winner: String
)