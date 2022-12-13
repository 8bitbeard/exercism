class Dna(private val dna: String) {

    private val validNucleotides = listOf('A', 'C', 'G', 'T')

    init {
        require(dna.all { validNucleotides.contains(it) })
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            val outputMap = validNucleotides.associateWith { 0 }.toMutableMap()

            dna.forEach { outputMap[it] = outputMap[it]!! + 1 }

            return outputMap
        }
}
