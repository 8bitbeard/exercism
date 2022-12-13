data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(matrix: List<List<Int>>) {

    var saddlePoints: MutableSet<MatrixCoordinate> = mutableSetOf()

    init {
        if (matrix[0].isNotEmpty()) {
            for (row in matrix.indices) {
                val max = matrix[row].maxOf { it }
                for (column in matrix[0].indices) {
                    if (matrix.map { it[column] }.minOf { it } == max)
                        saddlePoints.add(MatrixCoordinate(row + 1, column + 1))
                }
            }
        }
    }
}
