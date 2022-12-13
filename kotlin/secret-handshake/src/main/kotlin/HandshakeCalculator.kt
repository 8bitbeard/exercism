object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val outputList: MutableList<Signal> = mutableListOf()
        val binary: String = Integer.toBinaryString(number)

        binary.reversed().forEachIndexed { index, c ->
            if (c == '1' && index < 4) {
                outputList.add(Signal.values()[index])
            }
        }

        if(binary.length >= 5 && binary[4] == '1') {
            return outputList.reversed()
        }
        return outputList
    }
}
