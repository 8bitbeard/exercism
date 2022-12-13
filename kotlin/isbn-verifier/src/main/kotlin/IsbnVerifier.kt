class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val filteredNumber = number.toList().filterNot { it == '-' }
        if(
            filteredNumber.any { it.isLetter() && it != 'X' }
            || filteredNumber.size != 10
            || (filteredNumber.indexOf('X') < filteredNumber.size - 1) && filteredNumber.indexOf('X') > 0) {
            return false
        }

        return filteredNumber
            .map { if(it.isDigit()) it.digitToInt() else 10 }
            .foldIndexed(0) { index, acc, i ->
                acc + (i * (10 - index))
            } % 11 == 0
    }
}
