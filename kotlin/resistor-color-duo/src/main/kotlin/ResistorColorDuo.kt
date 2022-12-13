object ResistorColorDuo {

    fun value(vararg colors: Color): Int {

        val firstTwoColors = mutableListOf<Int>()
        colors.forEach { color: Color ->
            firstTwoColors.add(color.ordinal)
        }
        return firstTwoColors[0] * 10 + firstTwoColors[1]
    }
}
