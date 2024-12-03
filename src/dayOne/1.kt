package dayOne

import utils.absolute
import java.io.File

fun readInputFile(name: String): String {
    val file = File(name)
    return file.readText()
}

fun parseLines(lines: List<String>): List<Pair<Int, Int>> {
    return lines.map { line ->
        line.split("   ").map { it.trim().toInt() }.let { it[0] to it[1] }
    }
}

fun main() {
    readInputFile("./input.txt")
    .let(CharSequence::lines)
    .let(::parseLines)
        .unzip() // separate list of pairs into two lists
        .let { it.first.sorted() to it.second.sorted() }
        .let { (first, second) -> first zip second } // merge two pair lists into a list of pairs
        .map { (a, b) -> (a - b).absolute() }
        .fold(0) { acc, diff -> acc + diff }
        .let(::println)
}
