data class Year(val yearValue: Int) {

    val isLeap: Boolean = (yearValue % 4 == 0 && (yearValue % 100 != 0 || yearValue % 400 == 0))
}
