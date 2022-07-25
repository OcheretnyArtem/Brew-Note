package by.ocheretny.brewnote.base.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<VS : ViewState, AS : ActionState> : ViewModel(), CoroutineScope {

    protected abstract fun initViewState(): VS

    private val _viewState = MutableStateFlow(initViewState())
    val viewState: StateFlow<VS> = _viewState

    private val actionChannel = Channel<AS>(Channel.BUFFERED)
    val actionFlow: Flow<AS> get() = actionChannel.receiveAsFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.d(throwable)
        consumeError(throwable)
    }

    override val coroutineContext: CoroutineContext =
        viewModelScope.coroutineContext + exceptionHandler

    protected fun safeLaunch(
        exceptionHandler: (Throwable?) -> Unit = {},
        block: suspend CoroutineScope.() -> Unit,
    ) = launch {
        block()
    }.apply {
        invokeOnCompletion { throwable ->
            throwable?.run {
                exceptionHandler(this)
            }
        }
    }

    protected open fun consumeError(throwable: Throwable?) = Unit

    protected fun reduceState(reducer: (oldState: VS) -> VS) {
        val state = _viewState.value
        _viewState.value = reducer(state)
    }
}
