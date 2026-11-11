package model
import java.util.Date

data class Reptile (
    val scientific: String,
    var name: String,
    var specie: String,
    var sex: String,
    var age: Int,
    var morphs: String,
    var adoption: Date,
    var weight: Double,
    var size: Double,
    var diet: String,
    var health: String,
    var friendliness: Int,
    var terrarium: Int,
    var habitat: String,
    var temperatureH: Double,
    var temperatureC: Double,
    var humidity: Double,
    var isArchived: Boolean = false
)
