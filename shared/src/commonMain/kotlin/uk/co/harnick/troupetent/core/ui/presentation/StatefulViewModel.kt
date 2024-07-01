package uk.co.harnick.troupetent.core.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class StatefulViewModel<State, Event>(
    initialState: State
) : ViewModel() {
    protected val mutableState = MutableStateFlow(initialState)
    val state = mutableState.asStateFlow()

    protected val vmScope = viewModelScope
    protected val vmContext = vmScope.coroutineContext

    private val _uiEvent = Channel<Event>()
    val uiEvents = _uiEvent.receiveAsFlow()

    private val _snackbar = Channel<Event>()
    val snackbars = _snackbar.receiveAsFlow()

    open fun onEvent(event: Event) {}
    protected fun sendEvent(event: Event) = vmScope.launch { _uiEvent.send(event) }
}
