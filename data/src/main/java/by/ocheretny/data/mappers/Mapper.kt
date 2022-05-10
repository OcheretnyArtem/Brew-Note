package by.ocheretny.data.mappers

interface Mapper<F, T> {

    fun map(from: F): T

}