object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        if(plaintext.isEmpty()) {
            return plaintext
        }
        val normalizedString = normalize(plaintext)
        val rectangleValues = computeRectangleValues(normalizedString)
        val rectangle = convertToRectangle(normalizedString, rectangleValues)
        return encode(rectangle)
    }

    private fun normalize(plaintext: String): String {
        return plaintext.lowercase().filter { ('a'..'z').contains(it) || ('0'..'9').contains(it) }
    }

    private fun computeRectangleValues(normalizedString: String): Pair<Int, Int> {
        var c = 1
        var r = 1
        var flag = true
        while (c * r < normalizedString.length) {
            flag = if(flag) {
                c++
                false
            } else {
                r++
                true
            }
        }
        return Pair(c, r)
    }

    private fun convertToRectangle(normalizedString: String, rectangleValues: Pair<Int, Int>): List<String> {
        return normalizedString.chunked(rectangleValues.first).map { it.padEnd(rectangleValues.first, ' ') }
    }

    private fun encode(rectangle: List<String>): String {
        val outputList = MutableList(rectangle[0].length) { "" }
        rectangle.forEach { line ->
            line.forEachIndexed { index, char ->
                outputList[index] += char.toString()
            }
        }
        return outputList.joinToString(" ")
    }
}
