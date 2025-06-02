enum class TypeDefinition {
    ARCHIVE,
    NOTES;

    fun getTypeForString(num:Int): String {
        val result  =when (this) {
            ARCHIVE -> {
                when(num){
                    1 -> "Список архивов:\n"
                    2 ->   "Создать архив."
                    else -> "архива"
                }
            }

            NOTES -> {
                when(num){
                    1 ->  "Выбран архив: "
                    else ->  "Создать заметку."
                }
            }
        }

        return result
    }
}