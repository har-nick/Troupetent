package uk.co.harnick.troupetent.core.design.icons.material

import uk.co.harnick.troupetent.core.design.icons.IconDesign
import uk.co.harnick.troupetent.core.design.icons.IconTokens
import uk.co.harnick.troupetent.core.design.icons.IconTokens.IconSet
import uk.co.harnick.troupetent.core.design.icons.material.filled.Close
import uk.co.harnick.troupetent.core.design.icons.material.filled.CloseFullscreen
import uk.co.harnick.troupetent.core.design.icons.material.filled.FormatPaint
import uk.co.harnick.troupetent.core.design.icons.material.filled.Language
import uk.co.harnick.troupetent.core.design.icons.material.filled.LibraryMusic
import uk.co.harnick.troupetent.core.design.icons.material.filled.MenuOpen
import uk.co.harnick.troupetent.core.design.icons.material.filled.Minimize
import uk.co.harnick.troupetent.core.design.icons.material.filled.MoreVert
import uk.co.harnick.troupetent.core.design.icons.material.filled.OpenInFull
import uk.co.harnick.troupetent.core.design.icons.material.filled.PhotoSizeSelectSmall
import uk.co.harnick.troupetent.core.design.icons.material.filled.QueueMusic
import uk.co.harnick.troupetent.core.design.icons.material.filled.Radio
import uk.co.harnick.troupetent.core.design.icons.material.filled.Settings
import uk.co.harnick.troupetent.core.design.icons.material.outlined.Close
import uk.co.harnick.troupetent.core.design.icons.material.outlined.CloseFullscreen
import uk.co.harnick.troupetent.core.design.icons.material.outlined.FormatPaint
import uk.co.harnick.troupetent.core.design.icons.material.outlined.Language
import uk.co.harnick.troupetent.core.design.icons.material.outlined.LibraryMusic
import uk.co.harnick.troupetent.core.design.icons.material.outlined.MenuOpen
import uk.co.harnick.troupetent.core.design.icons.material.outlined.Minimize
import uk.co.harnick.troupetent.core.design.icons.material.outlined.MoreVert
import uk.co.harnick.troupetent.core.design.icons.material.outlined.OpenInFull
import uk.co.harnick.troupetent.core.design.icons.material.outlined.PhotoSizeSelectSmall
import uk.co.harnick.troupetent.core.design.icons.material.outlined.QueueMusic
import uk.co.harnick.troupetent.core.design.icons.material.outlined.Radio
import uk.co.harnick.troupetent.core.design.icons.material.outlined.Settings

object MaterialIcons : IconDesign {
    object Filled
    object Outlined

    override fun toTokens(): IconTokens = IconTokens(
        actionMenu = IconSet(
            filled = Filled.MoreVert,
            outlined = Outlined.MoreVert
        ),
        close = IconSet(
            filled = Filled.Close,
            outlined = Outlined.Close
        ),
        formatPaint = IconSet(
            filled = Filled.FormatPaint,
            outlined = Outlined.FormatPaint
        ),
        fullscreen = IconSet(
            filled = Filled.OpenInFull,
            outlined = Outlined.OpenInFull
        ),
        fullscreenExit = IconSet(
            filled = Filled.CloseFullscreen,
            outlined = Outlined.CloseFullscreen
        ),
        language = IconSet(
            filled = Filled.Language,
            outlined = Outlined.Language
        ),
        menuOpen = IconSet(
            filled = Filled.MenuOpen,
            outlined = Outlined.MenuOpen
        ),
        minimize = IconSet(
            filled = Filled.Minimize,
            outlined = Outlined.Minimize
        ),
        musicLibrary = IconSet(
            filled = Filled.LibraryMusic,
            outlined = Outlined.LibraryMusic
        ),
        musicQueue = IconSet(
            filled = Filled.QueueMusic,
            outlined = Outlined.QueueMusic
        ),
        musicRadio = IconSet(
            filled = Filled.Radio,
            outlined = Outlined.Radio
        ),
        photoSizeSelect = IconSet(
            filled = Filled.PhotoSizeSelectSmall,
            outlined = Outlined.PhotoSizeSelectSmall
        ),
        settings = IconSet(
            filled = Filled.Settings,
            outlined = Outlined.Settings
        )
    )
}
