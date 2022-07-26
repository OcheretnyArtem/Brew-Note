package by.data.parsres

interface Mapper<F, T> {
    fun map(from: F) : T
}
