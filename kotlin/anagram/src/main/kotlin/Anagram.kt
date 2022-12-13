class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { w ->
            wordToMap(this.source) == wordToMap(w)
                    && w.lowercase() != this.source.lowercase()
        }.toSet()
    }

    private fun wordToMap(input: String): Map<Char, Int> {
        return input.groupingBy { it.lowercaseChar() }.eachCount()
    }
}
