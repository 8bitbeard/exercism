import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val powNumber = input.toString().length
        val digits = input.toString().map { (it.digitToInt() * 1.0).pow(powNumber) }

        return (digits.sum().toInt() == input)
    }

}
