import kotlin.math.pow

class Squares(private val naturalNumbers: Int) {

    fun sumOfSquares(): Int {
        return (naturalNumbers * (naturalNumbers + 1) * (2 * naturalNumbers + 1)) / 6
    }

    fun squareOfSum(): Int {
        return ((naturalNumbers * (naturalNumbers + 1)) / 2).let { it * it }
    }

    fun difference(): Int {
        return this.squareOfSum() - this.sumOfSquares()
    }
}
