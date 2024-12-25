import java.util.*
import kotlin.collections.HashMap

class Archive {

    private fun addArchive(dbArchive: MutableMap<Int, ArchiveData>, num:Int) {
        println("Введите название архива.")
        val nameArchive = Scanner(System.`in`).nextLine()
        if (nameArchive.isEmpty()) println("Отсутствует название архива.") else dbArchive[num - 1] =
            ArchiveData(nameArchive, HashMap())
    }

    private fun printArchive(dbArchive: MutableMap<Int, ArchiveData>, input: Int) {
        val notes = Notes()
        dbArchive[input - 1]?.let { notes.createNotes(it.nameArchive, it.notes) }
            ?: println("Ошибка индексации")
    }
    fun createArchive(dbArchive: MutableMap<Int, ArchiveData>) {
        while (true) {
            val num = menu(TypeDefinition.ARCHIVE, dbArchive)
            when (val input = Scanner(System.`in`).checkingIntInput()) {
                null -> println("Следует вводить цифру.")
                num -> break
                0 -> {addArchive(dbArchive,num)
                    continue}
                in 1 until num -> printArchive(dbArchive,input)

                else -> {
                    println("Такой цифры нет.")
                    continue
                }
            }


        }
    }


}