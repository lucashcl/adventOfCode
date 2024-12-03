package dayTwo

import utils.absolute

val THRESHOLD = 1 to 3

fun parseLine(line: String): List<Int> {
    return line.split(" ").map { it.trim().toInt() }
}

sealed class Trend(open val value: Int) {
    data class Increase(override val value: Int): Trend(value)
    data class Decrease(override val value: Int): Trend(value)
}

fun List<Trend>.differentKind(): Boolean {
    if(this.isEmpty()) return false
    return this.any { it::class != this[0]::class }

}

fun isSafe(difference: Int): Boolean {
    val (lower, upper) = THRESHOLD
    return difference in lower..upper
}

fun isReportSafe(report: List<Int>): Boolean {
    val trends = report
        .zipWithNext { cur, next ->
            val diff = cur - next
            if(diff < 0) Trend.Decrease(diff.absolute()) else Trend.Increase(diff)
        }

    if(trends.differentKind()) {
        return false
    }

    return trends.all { isSafe(it.value) }
}

fun main() {
    input
        .lines()
        .map(::parseLine)
        .map(::isReportSafe)
        .count { it }
        .let(::println)
}