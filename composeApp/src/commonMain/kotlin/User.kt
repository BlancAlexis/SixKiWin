import kotlinx.serialization.Serializable

@Serializable
data class User(
    val uuid : String,
    val prenom : String,
   // val point : List<Int>
) {
}