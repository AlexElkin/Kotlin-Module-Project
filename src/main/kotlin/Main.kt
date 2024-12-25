import java.util.Scanner

fun main() {
    val dbArchive: MutableMap<Int, ArchiveData> = HashMap()
    val app = Archive()
    app.createArchive(dbArchive)
}

fun Scanner.checkingIntInput(): Int? {
    return when (val input = this.nextLine().toIntOrNull()) {
        null -> {
            null
        }

        else -> input
    }
}

fun <T> menu(type: TypeDefinition, db: MutableMap<Int, T>, archiveName: String = ""): Int {
    var num = 0
    if (type == TypeDefinition.ARCHIVE) {
        println("${type.getTypeForString(1)}0.${type.getTypeForString(2)}")
    } else println("${type.getTypeForString(1)}$archiveName.\n0.${type.getTypeForString(2)}")

    if (db.isNotEmpty()) {
        for ((key, value) in db) {
            println("${key + 1}.${value.toString()}.")
            num++
        }
    }
    println("${++num}.Выход.")
    return num
}

