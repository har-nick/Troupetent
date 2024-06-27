package uk.co.harnick.troupetent.core.util.compose

import androidx.compose.ui.text.intl.Locale
import uk.co.harnick.troupetent.core.settings.domain.model.general.Language

fun Locale.toLanguage(): Language {
    val localeTag = toLanguageTag()
    val tagLanguage = localeTag.substringBefore("-")

    with(Language.entries) {
        return firstOrNull { it.tag == localeTag } ?: first { it.languageAcronym == tagLanguage }
    }
}
