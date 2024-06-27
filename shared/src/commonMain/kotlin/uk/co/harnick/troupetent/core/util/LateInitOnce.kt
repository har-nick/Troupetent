package uk.co.harnick.troupetent.core.util

import kotlin.reflect.KProperty

class LateInitOnce<T> {
    private var initialized = false
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        require(value != null) { "Val ${property.name} has not been initialized" }
        return value!!
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        require(!initialized) { "Val ${property.name} cannot be reassigned" }
        this.value = value
        initialized = true
    }
}
