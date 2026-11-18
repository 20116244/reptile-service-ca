import java.io.File
import model.Reptile
import utils.readNextInt
import utils.readNextLine
import utils.readNextDouble
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val logger = KotlinLogging.logger {}

fun main(){
    logger.info { " Reptile Database Starting " }
    if (File("notes.json").exists()){
        loadFailed =!loadNote()
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
        2 -> listActiveReptileNotes
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