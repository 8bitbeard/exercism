object Hamming {

    @Throws(IllegalArgumentException::class)
    fun compute(leftStrand: String, rightStrand: String): Int {
        if(leftStrand.length != rightStrand.length) {
            throw IllegalArgumentException("left and right strands must be of equal length")
        }
        var counter = 0
        leftStrand.forEachIndexed { index, _ ->
            if (leftStrand[index] != rightStrand[index]) {
                counter++
            }
        }

        return counter
    }
}
