package uk.co.harnick.troupetent.core.ui.presentation

interface Event {
    sealed interface UI
    sealed interface VM
}