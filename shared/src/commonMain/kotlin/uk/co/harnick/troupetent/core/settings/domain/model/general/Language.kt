package uk.co.harnick.troupetent.core.settings.domain.model.general

import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue

enum class Language(
    override val label: String,
    val languageAcronym: String,
    val regionAcronym: String,
    val flagUnicode: String,
    val tag: String = languageAcronym + regionAcronym
) : EnumSettingValue {
    Arabic(
        label = "Arabic",
        languageAcronym = "ar",
        regionAcronym = "SA",
        flagUnicode = "\uD83C\uDDE6\uD83C\uDDEA"
    ),
    Chinese(
        label = "Chinese",
        languageAcronym = "zh",
        regionAcronym = "CN",
        flagUnicode = "\uD83C\uDDE8\uD83C\uDDF3"
    ),
    English(
        label = "English",
        languageAcronym = "en",
        regionAcronym = "GB",
        flagUnicode = "\uD83C\uDDFA\uD83C\uDDF8"
    ),
    French(
        label = "French",
        languageAcronym = " fr",
        regionAcronym = "FR",
        flagUnicode = "\uD83C\uDDEB\uD83C\uDDF7"
    ),
    German(
        label = "German",
        languageAcronym = " de",
        regionAcronym = "DE",
        flagUnicode = "\uD83C\uDDE9\uD83C\uDDEA"
    ),
    Hindi(
        label = "Hindi",
        languageAcronym = "hi",
        regionAcronym = "IN",
        flagUnicode = "\uD83C\uDDED\uD83C\uDDF3"
    ),
    Japanese(
        label = "Japanese",
        languageAcronym = "ja",
        regionAcronym = "JP",
        flagUnicode = "\uD83C\uDDEF\uD83C\uDDF5"
    ),
    Portuguese(
        label = "Portuguese",
        languageAcronym = "pt",
        regionAcronym = "PT",
        flagUnicode = "\uD83C\uDDF5\uD83C\uDDF9"
    ),
    Russian(
        label = "Russian",
        languageAcronym = "ru",
        regionAcronym = "RU",
        flagUnicode = "\uD83C\uDDF7\uD83C\uDDFA"
    ),
    Spanish(
        label = "Spanish",
        languageAcronym = "es",
        regionAcronym = "ES",
        flagUnicode = "\uD83C\uDDEA\uD83C\uDDF8"
    )
}
