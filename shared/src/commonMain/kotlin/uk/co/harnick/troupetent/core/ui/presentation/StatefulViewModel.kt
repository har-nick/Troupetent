package uk.co.harnick.troupetent.core.ui.presentation

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class StatefulViewModel<State, Event>(
    initialState: State
) : StateScreenModel<State>(initialState) {
    protected val vmScope = screenModelScope
    protected val vmContext = vmScope.coroutineContext

    private val _uiEvent = Channel<Event>()
    val uiEvent = _uiEvent.receiveAsFlow()

    open fun onEvent(event: Event) {}
    protected fun sendEvent(event: Event) = vmScope.launch { _uiEvent.send(event) }
}
