class Triangle(a: Double, b: Double, c: Double) {

    private val sides = listOf(a, b, c).sorted()

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    init {
        require(sides.all { it > 0 })
        require(sides.all { sides.minus(it).sum() >= it })
    }

    val isEquilateral: Boolean = sides.distinct().size == 1
    val isIsosceles: Boolean = sides.distinct().size <= 2
    val isScalene: Boolean = sides.distinct().size == 3
}
