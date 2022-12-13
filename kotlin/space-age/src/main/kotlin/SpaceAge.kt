import kotlin.math.roundToInt

object PlanetConstants {
    const val EARTH_YEAR_SECONDS = 31557600.0
    const val MERCURY_FACTOR = 0.2408467
    const val VENUS_FACTOR = 0.61519726
    const val MARS_FACTOR = 1.8808158
    const val JUPITER_FACTOR = 11.862615
    const val SATURN_FACTOR = 29.447498
    const val URANUS_FACTOR = 84.016846
    const val NEPTUNE_FACTOR = 164.79132
}

class SpaceAge(private var seconds: Int) {

    private val earthYears: Double
        get() = this.seconds / PlanetConstants.EARTH_YEAR_SECONDS

    fun onEarth(): Double = roundDouble(earthYears)
    fun onMercury(): Double = roundDouble(earthYears / PlanetConstants.MERCURY_FACTOR)
    fun onVenus(): Double = roundDouble(earthYears / PlanetConstants.VENUS_FACTOR)
    fun onMars(): Double = roundDouble(earthYears / PlanetConstants.MARS_FACTOR)
    fun onJupiter(): Double = roundDouble(earthYears / PlanetConstants.JUPITER_FACTOR)
    fun onSaturn(): Double = roundDouble(earthYears / PlanetConstants.SATURN_FACTOR)
    fun onUranus(): Double = roundDouble(earthYears / PlanetConstants.URANUS_FACTOR)
    fun onNeptune(): Double = roundDouble(earthYears / PlanetConstants.NEPTUNE_FACTOR)

    private fun roundDouble(value: Double): Double {
        return (value * 100.0).roundToInt() / 100.0
    }
}
