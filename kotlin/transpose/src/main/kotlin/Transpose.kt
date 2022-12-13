object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) {
            return input
        }

        val qtyLines = input.maxByOrNull { it.length }!!.length
        val outputList = MutableList(qtyLines) { "*".repeat(input.size) }

        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { columnIndex, column ->
                outputList[columnIndex] = StringBuilder(outputList[columnIndex])
                    .also { it.setCharAt(lineIndex, column) }.toString()
            }
        }

        outputList.forEachIndexed { lineIndex, line ->
            var convertToSpace = false
            var endOfString = line.length
            for ( charIndex in line.length - 1 downTo 0) {
                when {
                    line[charIndex] == '*' && !convertToSpace -> endOfString = charIndex
                    else -> convertToSpace = true
                }
            }
            outputList[lineIndex] = outputList[lineIndex].substring(0, endOfString).replace("*", " ")
        }

        return outputList
    }
}
