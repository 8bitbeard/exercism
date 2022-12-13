class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> {
        return normalizeStringMatrix()
            .map { it[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return normalizeStringMatrix()[rowNr - 1]
    }

    private fun normalizeStringMatrix(): List<List<Int>> = matrixAsString.split("\n")
        .map { it.split(" ") }
        .map { it.filter(String::isNotEmpty).map(String::toInt) }
}
