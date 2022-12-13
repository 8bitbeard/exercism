object ResistorColorTrio {

    fun text(vararg input: Color): String {
        var outputString = ""
        input.forEachIndexed { index, color ->
            if (index < 2) {
                outputString += color.ordinal
            } else {
                outputString += "0".repeat(color.ordinal)
            }
        }

        return when {
            outputString.contains("000000") -> appendUnit(6, outputString)
            outputString.contains("000") -> appendUnit(3, outputString)
            else -> appendUnit(0, outputString)
        }
    }

    private fun appendUnit(factor: Int, outputString: String): String {
        val index = factor/3
        return outputString.dropLast(factor)
            .plus(" ")
            .plus(Unit.values()[index]
                .name
                .lowercase()
            )
    }
}
