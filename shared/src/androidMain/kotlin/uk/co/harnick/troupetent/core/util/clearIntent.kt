package uk.co.harnick.troupetent.core.util

import android.content.Intent
import android.os.Bundle

fun Intent.clear() {
    replaceExtras(Bundle.EMPTY)
    action = ""
    data = null
    flags = 0
}
