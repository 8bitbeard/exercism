object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val wordMap = mutableMapOf<String, Int>()

        val words = Regex("'([a-zA-Z'\\d]+)'|([a-zA-Z'\\d]+)").findAll(phrase)
            .map { it.groupValues.last {
                    g -> g.isNotEmpty()
                }.lowercase()
            }.toList()

        words.distinct().forEach { word ->
            wordMap[word] = words.count { it == word }
        }

        return wordMap
    }
}
