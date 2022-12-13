import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(birthDateTime: LocalDateTime) {

    constructor(birthDateTime: LocalDate) : this(birthDateTime.atStartOfDay())

    object GigasecondConstants {
        const val GIGASECOND_VALUE = 1_000_000_000L
    }

    val date: LocalDateTime = birthDateTime.plusSeconds(GigasecondConstants.GIGASECOND_VALUE)
}
