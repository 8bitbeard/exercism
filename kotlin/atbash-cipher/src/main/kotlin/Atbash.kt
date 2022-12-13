object Atbash {

    fun encode(s: String): String{
        val range = ('a'..'z')
        return s
            .lowercase()
            .filter { it.isLetter() || it.isDigit() }
            .map { if(it.isLetter()) range.reversed().elementAt(range.indexOf(it)) else it }
            .chunked(5).joinToString(" ") { it.joinToString("") }
    }

    fun decode(s: String): String{
        val range = ('a'..'z')
        return s
            .replace(" ", "")
            .map { if(it.isLetter()) range.reversed().elementAt(range.indexOf(it)) else it }
            .joinToString("")
    }
}
