object Luhn {

    fun isValid(candidate: String): Boolean {
        val filteredCandidate = candidate.reversed().filterNot { it.isWhitespace() }.toList()
        if (filteredCandidate.any { !it.isDigit() } || filteredCandidate.size == 1) {
            return false
        }

        return filteredCandidate
            .mapIndexed { index, c -> if ((index + 1) % 2 == 0) c.digitToInt() * 2 else c.digitToInt() }
            .sumOf { if (it > 9) it - 9 else it } % 10 == 0
    }
}
