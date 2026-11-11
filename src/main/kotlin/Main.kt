import java.io.File
import io.github.oshai.kotlinlogging.KotlinLogging
import model.Reptile
import utils.readNextInt

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
    val scientific = readNextLine("Scientific name: ")
    val name = readNextLine("Nickname: ")
    val specie = readNextLine("Sub Species: ")
    val sex = readNextLine("Sex: ")
    val age = readNextInt("Age: ")
    val morphs = readNextLine("Morphs: ")
    val adoption = readNextLine("Adoption (day/month/year): ")
    val weight = readNextLine("Weight (GRAMS): ")
    val size =  readNextInt("How long is the reptile ? (CM) ")
    val diet = readNextLine("What type of diet ? ")
    val health = readNextLine("Health:")
    val friendliness = readNextInt("How friendly it is ? (0-10) ")
    val terrarium = readNextInt("How big the terrarium should be? (CM) ")
    val habitat = readNextLine("Habitat:")
    val temperatureH = readNextInt("Temperature in Hot side: ")
    val temperatureC = readNextInt("Temperature in Cold side: ")
    val humidity = readNextLine("Humidity lvl: ")

    reptileNote.addReptile(
        Reptile(scientific, name, specie, sex, age, morphs, adoption, weight, size, diet, health, friendliness, terrarium, habitat, temperatureH, temperatureC, humidity)
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