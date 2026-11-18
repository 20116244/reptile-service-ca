package model
import java.time.LocalDate

data class Reptile (
    val scientificName: String,
    var name: String,
    var species: String,
    var sex: String,
    var age: Int,
    var morphs: String,
    var adoptionDate: LocalDate,
    var weightGrams: Double,
    var lengthCm: Double,
    var diet: String,
    var health: String,
    var friendliness: Int,
    var terrariumSizeCm: Int,
    var habitat: String,
    var hotSideTempC: Double,
    var coolSideTempC: Double,
    var humidityPercent: Double,
    var isArchived: Boolean = false
)
