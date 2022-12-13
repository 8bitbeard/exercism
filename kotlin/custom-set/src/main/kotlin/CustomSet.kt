class CustomSet(vararg items: Int) {

    // TODO: implement proper constructor
    var storage = items.toList()

    fun isEmpty(): Boolean {
        return storage.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        storage.containsAll(other)
    }

    fun isDisjoint(other: CustomSet): Boolean {
        TODO("Implement this function to complete the task")
    }

    fun contains(other: Int): Boolean {
        return storage.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }

    fun add(other: Int) {
        TODO("Implement this function to complete the task")
    }

    override fun equals(other: Any?): Boolean {
        TODO("Implement this function to complete the task")
    }

    operator fun plus(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }

    operator fun minus(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }
}
