object RunLengthEncoding {

    fun encode(input: String): String {
        val chunks = mutableListOf<String>()
        var buffer = ""

        if (input.isEmpty()) {
            return ""
        }

        input.forEach { c ->
            when {
                buffer.contains(c) || buffer.isEmpty() -> buffer += c
                else -> {
                    chunks.add(buffer)
                    buffer = c.toString()
                }
            }
        }
        chunks.add(buffer)

        return chunks.map { chunk ->
            if(chunk.length > 1) {
                chunk.length.toString() + chunk[0]
            } else {
                chunk[0]
            }
        }.joinToString("")
    }

    fun decode(input: String): String {
        var decodedString = ""
        var buffer = ""
        input.forEach { c ->
            when {
                c.isDigit() -> buffer += c.toString()
                buffer.isEmpty() -> decodedString += c
                else -> {
                    decodedString += c.toString().repeat(buffer.toInt())
                    buffer = ""
                }
            }
        }

        return decodedString
    }
}
