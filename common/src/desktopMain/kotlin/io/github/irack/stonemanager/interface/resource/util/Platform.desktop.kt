package io.github.irack.stonemanager.`interface`.resource.util


class DesktopPlatform : Platform {
    private val os = System.getProperty("os.name").lowercase(java.util.Locale.getDefault())
    private val version = System.getProperty("java.version")
    override val name: String = "JVM $version Desktop on ${getSystem()}"

    private fun getSystem(): String = when {
        os.contains("win") -> "Windows"
        os.contains("mac") -> "Mac"
        (os.contains("nix") || os.contains("nux") || os.contains("aix")) -> "Unix"
        os.contains("linux") -> "Linux"
        os.contains("sunos") -> "Solaris"
        else -> "Unknown"
    }
}

actual fun getPlatform(): Platform = DesktopPlatform()
