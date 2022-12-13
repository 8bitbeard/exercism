fun transcribeToRna(dna: String): String {
    val transcribeMap: Map<Char, Char> = mapOf(
        'G' to 'C',
        'C' to 'G',
        'T' to 'A',
        'A' to 'U'
    )

    return dna.map { c -> transcribeMap[c] ?: "" }.joinToString(separator = "")
}
