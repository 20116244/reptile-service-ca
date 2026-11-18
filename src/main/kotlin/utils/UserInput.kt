package utils

fun readNextInt(prompt: String = ""): Int {
    while (true){
        print(prompt)
        val value = readln().trim().toIntOrNull()
        if (value != null) {
            return value
        }
        println("Please enter a valid integer.")
    }
}

fun readNextLine(prompt: String = ""): String {
    print(prompt)
    return readln()
}
fun readNextDouble(prompt: String = ""): Double {
    while (true) {
        print(prompt)

        val value = readln().trim().toDoubleOrNull()
        if (value != null) {
            return value
        }

        println("Please enter a valid double.")
    }
}
fun readNextBoolean(prompt: String = ""): Boolean {
    print(prompt)
    return when (readlnOrNull()?.lowercase()) {
        "y", "yes", "true" -> true
        else -> false
    }
}