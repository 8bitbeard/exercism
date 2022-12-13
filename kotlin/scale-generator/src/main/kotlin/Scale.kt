class Scale(private val tonic: String) {

    companion object {
        val notesWithMinors = listOf("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B")
        val notesWithMajors = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    }

    fun chromatic(): List<String> {
        return interval("mmmmmmmmmmmm")
    }

    fun interval(intervals: String): List<String> {
        var currentNote = tonic.replaceFirstChar { it.uppercase() }
        val outputScale = mutableListOf(currentNote)
        val iterableScale = if (tonic.contains('b')) notesWithMinors else notesWithMajors

        intervals.toCharArray().forEach {
            val addFactor = when (it) {
                'm' -> 1
                'M' -> 2
                else -> 3
            }

            currentNote = iterableScale[(iterableScale.indexOf(currentNote) + addFactor) % iterableScale.size]
            outputScale.add(currentNote)
        }

        return outputScale.dropLast(1)
    }

}
