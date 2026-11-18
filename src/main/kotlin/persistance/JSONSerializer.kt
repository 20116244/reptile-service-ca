package persistance

import model.Reptile
import tools.jackson.databind.json.JsonMapper
import tools.jackson.module.kotlin.kotlinModule
import tools.jackson.module.kotlin.readValue
import java.io.File

class JSONSerializer(private val file: File) : Serializer {
    private val mapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .build()

    override fun write(reptiles: List<Reptile>) {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, reptiles)
    }

    override fun read(): List<Reptile> {
        return mapper.readValue<List<Reptile>>(file)
    }
}