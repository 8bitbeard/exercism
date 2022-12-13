import kotlin.math.pow

object Wordy {

    fun answer(input: String): Int {
        val validOperations = listOf("plus", "minus", "multiplied", "divided", "raised")
        val numbers = mutableListOf<Int>()
        val operations = mutableListOf<String>()
        val substring = input.removePrefix("What is ").removeSuffix("?").split(" ")

        require(substring.first().toIntOrNull() != null)
        require(substring.last().toIntOrNull() != null || substring.last() == "power")

        substring.forEach {
            when {
                validOperations.contains(it) -> operations.add(it)
                it.removeSuffix("th").toIntOrNull() != null -> numbers.add(it.removeSuffix("th").toInt())
            }
        }

        require(numbers.size == operations.size + 1)

        return numbers.reduceIndexed { index, acc, i ->
            when (operations[index - 1]) {
                "plus" -> acc + i
                "minus" -> acc - i
                "multiplied" -> acc * i
                "divided" -> acc / i
                "raised" -> acc.toDouble().pow(i).toInt()
                else -> acc
            }
        }
    }
}
