package utils

fun Int.absolute(): Int {
    return if (this < 0) this * -1 else this
}