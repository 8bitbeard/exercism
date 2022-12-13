import kotlin.math.floor

class DiamondPrinter {

    fun printToList(letter: Char): List<String> {
        val listSize = (('A'..'Z').toList().indexOf(letter) * 2) + 1
        val outputList = MutableList(listSize) { " ".repeat(listSize) }
        val listOfIndexes = mutableListOf<Pair<Int, Int>>()
        (0..floor(listSize / 2.0).toInt()).forEach {
            listOfIndexes.add(Pair(
                floor(listSize / 2.0).toInt() + it,
                floor(listSize / 2.0).toInt() - it
            ))
        }

        val result = listOfIndexes
                .mapIndexed { index, s ->
            StringBuilder(outputList[index]).also {
                it.setCharAt(s.first, letter - floor(listSize / 2.0).toInt() + index)
                it.setCharAt(s.second, letter - floor(listSize / 2.0).toInt() + index)
            }.toString()
        }

        val tempList = result.toMutableList()
        tempList.removeLast()

        return result.plus(tempList.reversed())
    }
}
