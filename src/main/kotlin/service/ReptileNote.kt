package service

import model.Reptile
import persistance.Serializer

class ReptileNote(private val serializer: Serializer) {
    private val reptiles = ArrayList<Reptile>()
    private val deletedReptiles = ArrayList<Reptile>()

    fun load() {
        reptiles.clear()
        reptiles.addAll(serializer.read())
    }

    fun store() {
        serializer.write(reptiles)
    }
    fun addReptile(reptile: Reptile): Boolean =
        reptiles.add(reptile)
    fun updateReptile(index: Int, updated: Reptile): Boolean {
        if (index !in reptiles.indices) return false
        reptiles[index] = updated
        return true
    }
    fun deleteReptile(index: Int): Boolean {
        if (index !in reptiles.indices) return false
        deletedReptiles.add(reptiles.removeAt(index))
        return true
    }
    fun getDeletedReptiles(): List<Reptile> = deletedReptiles
    fun restoreReptile(index: Int): Boolean {
        if (index !in deletedReptiles.indices) return false
        reptiles.add(deletedReptiles.removeAt(index))
        return true
    }
    fun getActiveReptiles(): List<Reptile> =
        reptiles.filter { !it.isArchived }
    fun archiveReptile(index: Int): Boolean {
        val active = getActiveReptiles()
        if (index !in active.indices) return false
        active[index].isArchived = true
        return true
    }
    fun searchReptilesBySpecies(species: String): List<Reptile> =
        reptiles.filter { it.species.contains(species, ignoreCase = true) }
}