object Pangram {

    fun isPangram(input: String): Boolean = CharRange('a', 'z').all { input.lowercase().contains(it) }
}
