object Raindrops {

    fun convert(n: Int): String {
        val soundMap: Map<Int, String> = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
        var outputString = ""

        soundMap.forEach { entry ->
            outputString += if (n % entry.key == 0) entry.value else ""
        }

        if (outputString.isEmpty()) return n.toString()
        return outputString
    }
}
