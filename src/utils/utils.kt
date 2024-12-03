package utils

fun Int.absolute(): Int {
    return if (this < 0) this * -1 else this
}

fun <T> debugPipeline(value: T): T {
    println(value)
    return value
}