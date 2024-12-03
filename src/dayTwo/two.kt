package dayTwo

fun <T> List<T>.partition(): List<List<T>> {
    return this.indices.map { i ->
        this.filterIndexed { j, _ ->
            i != j
        }
    }
}

fun main() {
    input
        .lines()
        .map(::parseLine)
        .map { report ->
            if(isReportSafe(report)) true
            else report.partition().any(::isReportSafe)
        }
        .count { it }
        .let(::println)
}