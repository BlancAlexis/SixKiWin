import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class User(
    //TODO le @contextual sert à quoi?
    @Contextual
    val uuid: Uuid =  uuid4(),
    val podium : Int = 0,
    val totalPoints : Int = 0,
    val firstname : String,
) {
}