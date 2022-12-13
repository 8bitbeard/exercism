class PhoneNumber(private val input: String) {

    private var parsedInput = this.input.filter { it.isDigit() }

    init {
        require(parsedInput.length > 9)
        require(parsedInput.length < 12)
        require(parsedInput.reversed()[9].digitToInt() > 1)
        require(parsedInput.reversed()[6].digitToInt() > 1)
        if(parsedInput.length == 11) {
            require(parsedInput.first() == '1')
        }
    }

    val number: String? = parsedInput.takeLast(10)
}
