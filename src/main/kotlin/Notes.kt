import java.util.*

class Notes {

    private fun addNotes(notes: MutableMap<Int, NotesData>) {
        println("Введите название заметки.")
        val nameNotes = Scanner(System.`in`).nextLine()
        if (nameNotes.isEmpty()) println("Отсутствует название заметки.") else {
            println("Введите текст заметки.")
            val textNotes = Scanner(System.`in`).nextLine()
            if (textNotes.isEmpty()) println("Отсутствует текст заметки.") else {
                val newIndex = if (notes.isEmpty()) 0 else notes.size
                notes[newIndex] = NotesData(nameNotes, textNotes)
            }
        }
    }

    private fun printNotes(notes: MutableMap<Int, NotesData>, input: Int){
        println("Заметка: ${notes[input - 1]?.nameNotes}\nТекст: ${notes[input - 1]?.textNotes}")
        println("0.Выход")
        while (true) {
            val testInput = Scanner(System.`in`).nextLine()
            if (testInput == "0") break else println("Для выхода введите 0")
        }
    }

    fun createNotes(archiveName: String, notes: MutableMap<Int, NotesData>) {
        while (true) {
            val num = menu(TypeDefinition.NOTES, notes, archiveName)
            when (val input = Scanner(System.`in`).checkingIntInput()) {
                null -> println("Следует вводить цифру.")
                num -> break
                0 -> addNotes(notes)
                in 1 until num -> printNotes(notes,input)
                else -> println("Такой цифры нет.")

            }
        }
    }
}