package by.ocheretny.brewnote.exceptions

import by.ocheretny.brewnote.R
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ExceptionParserImpl @Inject constructor() : ExceptionParser {

    override fun getExceptionNameId(throwable: Throwable?): Int = when (throwable) {

        is UnknownHostException -> R.string.no_internet_connection

        is SocketTimeoutException -> R.string.no_internet_connection

        else -> R.string.something_went_wrong
    }
}
