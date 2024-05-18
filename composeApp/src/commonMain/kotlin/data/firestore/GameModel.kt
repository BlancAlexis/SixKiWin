package data.firestore

import dev.gitlive.firebase.firestore.Timestamp

data class GameModel (
    val date: Timestamp,
    val joueurs: List<String>,
    val vainqueur: String?= null
    )