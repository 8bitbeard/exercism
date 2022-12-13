class RotationalCipher(private var key: Int) {

    fun encode(text: String): String {
        return text.map {
            when {
                it.isLowerCase() -> ('a'..'z').toList()[(('a'..'z').indexOf(it) + key) % 26]
                it.isUpperCase() -> ('A'..'Z').toList()[(('A'..'Z').indexOf(it) + key) % 26]
                else -> it
            }
        }.joinToString("")
    }
}
