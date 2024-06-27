package uk.co.harnick.troupetent.core.util

import java.awt.Desktop
import java.io.File
import java.net.URI

object Desktop {
    fun browse(uri: URI) =
        runCatching { Desktop.getDesktop().browse(uri) }
            .onFailure { openSystemSpecific(uri.toString()) }
            .getOrElse { }

    fun open(file: File) =
        runCatching { Desktop.getDesktop().open(file) }
            .onFailure { openSystemSpecific(file.path) }
            .getOrElse { }

    fun edit(file: File) =
        runCatching { Desktop.getDesktop().edit(file) }
            .onFailure { openSystemSpecific(file.path) }
            .getOrElse { }

    private fun openSystemSpecific(what: String): Boolean {
        return listOf("xdg-open", "kde-open", "gnome-open", "open", "explorer")
            .asSequence()
            .map { runCommand(it, "%s", what) }
            .find { it } ?: false
    }

    private fun runCommand(command: String, args: String, file: String): Boolean {
        val parts = prepareCommand(command, args, file)

        return runCatching {
            val p = Runtime.getRuntime().exec(parts) ?: return false
            runCatching { p.exitValue() != 0 }.getOrElse { true }
        }.getOrElse { false }
    }

    private fun prepareCommand(command: String, args: String?, file: String): Array<String> {
        val parts: MutableList<String> = ArrayList()
        parts.add(command)

        val splitArgs = args?.split(" ".toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray()

        splitArgs?.forEach { char ->
            val s = String.format(char, file)
            parts.add(s.trim { it <= ' ' })
        }

        return parts.toTypedArray<String>()
    }
}
