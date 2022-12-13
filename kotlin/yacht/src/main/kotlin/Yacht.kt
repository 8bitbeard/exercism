object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        val diceValues = dices.toList()
        return when(category) {
            YachtCategory.YACHT -> yatchSolve(diceValues)
            YachtCategory.FULL_HOUSE -> fullHouseSolve(diceValues)
            YachtCategory.FOUR_OF_A_KIND -> fourOfAKindSolve(diceValues)
            YachtCategory.LITTLE_STRAIGHT -> littleStraightSolve(diceValues)
            YachtCategory.BIG_STRAIGHT -> bigStraightSolve(diceValues)
            YachtCategory.CHOICE -> choiceSolve(diceValues)
            else -> timesOfaKindSolve(category, diceValues)
        }
    }

    private fun yatchSolve(diceValues: List<Int>): Int {
        return if (diceValues.distinct().size == 1) 50 else 0
    }

    private fun fullHouseSolve(diceValues: List<Int>): Int {
        val diceMap = diceValues
            .groupingBy { it }
            .eachCount()

        return if (diceMap.any { it.value == 3 }) {
            diceValues.sum()
        } else {
            0
        }
    }

    private fun fourOfAKindSolve(diceValues: List<Int>): Int {
        return diceValues
            .groupingBy { it }
            .eachCount()
            .filter { it.value >= 4 }
            .keys
            .elementAtOrElse(0) { 0 }
            .times(4)
    }

    private fun littleStraightSolve(diceValues: List<Int>): Int {
        return if((1..5).all { i -> diceValues.contains(i) }) 30 else 0
    }

    private fun bigStraightSolve(diceValues: List<Int>): Int {
        return if((2..6).all { i -> diceValues.contains(i) }) 30 else 0
    }

    private fun choiceSolve(diceValues: List<Int>): Int {
        return diceValues.sum()
    }

    private fun timesOfaKindSolve(category: YachtCategory, diceValues: List<Int>): Int {
        return diceValues.fold(0) { acc, i -> if (i == category.ordinal) acc + i else acc }
    }
}
