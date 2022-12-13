object Acronym {
    fun generate(phrase: String) : String {
       return phrase
           .split(" ", "-", "_")
           .filter(String::isNotEmpty)
           .map {
               it.uppercase().first()
           }.joinToString("")
    }
}
