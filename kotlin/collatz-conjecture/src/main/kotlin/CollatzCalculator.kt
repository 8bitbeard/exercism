object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0)

        var stepCounter = 0
        var value = start

        while (value != 1) {
            if(value % 2 == 0) value /= 2 else value = value * 3 + 1
            stepCounter++
        }

        return stepCounter
    }
}
