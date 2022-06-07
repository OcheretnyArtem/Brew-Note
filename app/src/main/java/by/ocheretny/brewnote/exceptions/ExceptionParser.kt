package by.ocheretny.brewnote.exceptions

interface ExceptionParser {

    fun getExceptionNameId(throwable: Throwable?): Int
}
