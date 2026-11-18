package persistance

import model.Reptile

interface Serializer {
    fun write(reptiles: List<Reptile>)
    fun read(): List<Reptile>
}