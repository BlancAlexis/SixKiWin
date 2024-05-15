package data.model

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4

data class DataPlayer(
    val uuid: Uuid = uuid4(),
    val idPlayer: String,
    val pointsRound: List<Int>
)
