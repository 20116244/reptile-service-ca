import java.io.File
import model.Reptile
import utils.readNextInt
import utils.readNextLine
import utils.readNextDouble
import utils.readNextBoolean
import service.ReptileNote
import persistance.JSONSerializer
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import io.github.oshai.kotlinlogging.KotlinLogging

private val reptileNote = ReptileNote(JSONSerializer(File("reptiles.json")))
private var loadFailed = false
private val logger = KotlinLogging.logger {}

fun main(){
    logger.info { " Reptile Database Starting " }
    if (File("reptiles.json").exists()){
        loadFailed =!loadReptileProfile()
    }
    runMenu()
    logger.info { " Reptile Database Exiting " }
}
fun mainMenu(): Int {
    print("""
         > ----------------------------------
         > |     Reptile Database App       |
         > ----------------------------------
         > | NOTE MENU                      |
         > |   1) Add a Reptile             |
         > |   2) List All Reptiles         |
         > |   3) Update a Reptile Info     |
         > |   4) Delete a Reptile Info     |
         > |   5) Save a Reptile Profile    |
         > |   6) Load a Reptile Profile    |
         > |   7) Archive a Reptile Profile |
         > |   8) Search a Reptile          |
         > |   9) Restore a Reptile Profile |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > """.trimMargin(">"))
    return readNextInt("==>> ")
}
fun runMenu (){
    var input : Int
    do {
        input = mainMenu()
        when(input) {
            1 -> addReptile()
            2 -> listAllReptiles()
            3 -> updateReptileProfile()
            4 -> deleteReptileProfile()
            5 -> saveReptileInfos()
            6 -> loadReptileProfile()
            7 -> archiveReptileInfo()
            8 -> searchBySpecs()
            9 -> restoreReptileProfile()
            0 -> {
                if (loadFailed) {
                    println("Notes were not loaded, so they were not saved (to protect your file)")
                } else {
                    saveReptileInfos()
                }
                logger.info { "Exiting App" }
            }
            else -> println("Invalid Option")
        }
    } while (input != 0)
}
fun restoreReptileProfile() {
    reptileNote.getDeletedReptiles().forEach { println(it) }
    val id = readNextInt("Enter the index of the reptile to restore: ")
    if (reptileNote.restoreReptile(id))
        println("Restored")
    else
        println("Not found")
}
fun searchBySpecs() {
    val species = readNextLine("Enter species to search: ")
    if (species != "") {
        reptileNote.searchReptilesBySpecies(species).forEach { println(it) }
    }
}
fun archiveReptileInfo() {
    reptileNote.getActiveReptiles().forEachIndexed { index, reptile -> println("$index: $reptile") }
    val id = readNextInt("Enter the index of the reptile to archive: ")
    if (reptileNote.archiveReptile(id))
        println("Archived")
    else
        println("Not found")
}
fun loadReptileProfile(): Boolean {
    try {
        reptileNote.load()
        return true
    } catch (e: Exception) {
        System.err.println("Error reading from file: $e")
        return false
    }
}
fun saveReptileInfos() {
    try {
        reptileNote.store()
    } catch (e: Exception) {
        System.err.println("Error writing to file: $e")
    }
}
fun deleteReptileProfile() {
    val id = readNextInt("Enter the index of the reptile to delete: ")

    if (reptileNote.deleteReptile(id)) {
        println("Deleted")
    } else {
        println("Not found")
    }
}
fun updateReptileProfile() {
    val id = readNextInt("Index of the reptile to update: ")
    val scientificName = readNextLine("New Scientific Name: ")
    val name = readNextLine("New Nickname: ")
    val species = readNextLine("New Species: ")
    val sex = readNextLine("New Sex (Male/Female/Unknown): ")
    val age = readNextInt("New Age (Years): ")
    val morphs = readNextLine("New Morphs: ")
    val adoptionDate = LocalDate.parse(
        readNextLine("New Adoption date (day.month.year): "),
        DateTimeFormatter.ofPattern("d.M.yyyy"))
    val weightGrams = readNextDouble("New Weight (Grams): ")
    val lengthCm = readNextDouble("New Length (Cm): ")
    val diet = readNextLine("New Diet: ")
    val health = readNextLine("New Health: ")
    val friendliness = readNextInt("New Friendliness (0-10): ")
    val terrariumSizeCm = readNextInt("New Terrarium size (Cm): ")
    val habitat = readNextLine("New Habitat: ")
    val hotSideTempC = readNextDouble("New Hot side temperature (°C): ")
    val coolSideTempC = readNextDouble("New Cool side temperature (°C): ")
    val humidityPercent = readNextDouble("New Humidity (%): ")
    val isArchived = readNextBoolean("Archive the reptile (y/n): ")

    val updated = Reptile(
        scientificName = scientificName,
        name = name,
        species = species,
        sex = sex,
        age = age,
        morphs = morphs,
        adoptionDate = adoptionDate,
        weightGrams = weightGrams,
        lengthCm = lengthCm,
        diet = diet,
        health = health,
        friendliness = friendliness,
        terrariumSizeCm = terrariumSizeCm,
        habitat = habitat,
        hotSideTempC = hotSideTempC,
        coolSideTempC = coolSideTempC,
        humidityPercent = humidityPercent,
        isArchived = isArchived
    )

    if (reptileNote.updateReptile(id, updated)) {
        println("Updated")
    } else {
        println("Not found")
    }
}
fun addReptile(){
    val scientificName = readNextLine("Scientific name: ")
    val name = readNextLine("Nickname: ")
    val species = readNextLine("Sub Species: ")
    val sex = readNextLine("Sex (Male/Female/Unknown: ")
    val age = readNextInt("Age (Years): ")
    val morphs = readNextLine("Morphs: ")
    val adoptionDate = LocalDate.parse(
        readNextLine("Adoption date (day.month.year): "),
        DateTimeFormatter.ofPattern("d.M.yyyy"))
    val weightGrams = readNextDouble("Weight (Grams): ")
    val lengthCm =  readNextDouble("Length (Cm): ")
    val diet = readNextLine("Diet: ")
    val health = readNextLine("Health:")
    val friendliness = readNextInt("How friendly it is ? (0-10) ")
    val terrariumSizeCm = readNextInt("Terrarium size (cm): ")
    val habitat = readNextLine("Habitat: ")
    val hotSideTempC = readNextDouble("Temperature in Hot side: ")
    val coolSideTempC= readNextDouble("Temperature in Cold side: ")
    val humidityPercent = readNextDouble("Humidity lvl: ")

    reptileNote.addReptile(
        Reptile(
            scientificName = scientificName,
            name = name,
            species = species,
            sex = sex,
            age = age,
            morphs = morphs,
            adoptionDate = adoptionDate,
            weightGrams = weightGrams,
            lengthCm = lengthCm,
            diet = diet,
            health = health,
            friendliness = friendliness,
            terrariumSizeCm = terrariumSizeCm,
            habitat = habitat,
            hotSideTempC = hotSideTempC,
            coolSideTempC = coolSideTempC,
            humidityPercent = humidityPercent
        )
    )
    println("Note added.")
}


fun listAllReptiles() {
    print("""
           > ----------------------------------
           > |   1) List all Reptiles                 |
           > |   2) List Reptile by name              |
           > |   3) List Reptile by species           |
           > |   4) List Reptile by size              |
           > |   5) List Reptile by morphs            |
           > |   6) List Reptile by diet              |
           > |   7) List Reptile by health            |     
           > |   8) List All Archived Reptile Notes   |
           > ----------------------------------
           > """.trimMargin(">"))

    when (readNextInt("==>> ")) {
        1 -> listAllReptiles()

        3 -> updateReptileProfile()
        4 -> deleteReptileProfile()
        5 -> saveReptileInfos()
        6 -> loadReptileProfile()
        7 -> archiveReptileInfo()
        8 -> searchBySpecs()
        9 -> restoreReptileProfile()
        else -> println("Invalid Option")
    }
}