data class ArchiveData (val nameArchive:String, var notes: MutableMap<Int,NotesData>){
    override fun toString(): String {
        return nameArchive
    }
}