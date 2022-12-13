object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val flatList = mutableListOf<Any?>()
        recursive(source, flatList)


        return flatList.filterNotNull()
    }

    private fun recursive(source: Collection<Any?>, outputList: MutableList<Any?>) {
        source.forEach {
            if (it is Collection<*>) {
                recursive(it, outputList)
            } else {
                outputList.add(it)
            }
        }
    }
}

