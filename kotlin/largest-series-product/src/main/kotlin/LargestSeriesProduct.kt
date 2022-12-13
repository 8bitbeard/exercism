class Series(private val input: String) {

    init {
        require(this.input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0)
        require(span <= this.input.length)

        if(span == 0) {
            return 1
        }

        val products = mutableListOf<Long>()
        val iterations = this.input.length - span

        (0 .. iterations).forEach {
            val substring = this.input.substring(it, it + span)

            products.add(substring.toList().map { c -> c.digitToInt() }.reduce { acc, c -> acc * c }.toLong())
        }

        return products.maxOrNull() ?: 1
    }
}
