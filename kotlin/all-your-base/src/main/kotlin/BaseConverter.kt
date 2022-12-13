import kotlin.math.pow

class BaseConverter(val base: Int, val digits: IntArray) {

    fun convertToBase(newBase: Int): IntArray {
        val onBaseTen = digits.reversed().reduceIndexed { index, acc, i ->
            println(index)
            acc
        }

        return intArrayOf(1)
    }
}

fun main() {
    val sum = intArrayOf(1, 0, 1, 1).reversed().reduceIndexed { index, acc, i ->
        println(index)
        acc + i * 2.toDouble().pow(index).toInt()
    }

    println(sum)
}
