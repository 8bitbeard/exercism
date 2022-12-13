object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(n > 0)
        require(s.isNotEmpty())
        require(s.length >= n)

        val outputList = mutableListOf<List<Int>>()
        val iterations = s.length - n
        (0..iterations).forEach {
            outputList.add(s.substring(it, it + n).toList().map(Char::digitToInt))
        }

        return outputList
    }
}
