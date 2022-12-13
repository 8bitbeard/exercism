enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {

    if (naturalNumber < 1) {
        throw RuntimeException()
    }

    val properDivisors = (1 .. naturalNumber / 2).filter { naturalNumber % it == 0 }
    val aliquotSum = properDivisors.sum()

    return when (aliquotSum.compareTo(naturalNumber)) {
        1 -> Classification.ABUNDANT
        -1 -> Classification.DEFICIENT
        else -> Classification.PERFECT
    }
}

