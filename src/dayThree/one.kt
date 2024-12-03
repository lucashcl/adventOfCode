package dayThree

val iMult = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()

fun recoverInstructions(corruptedInstructions: String, regex: Regex): List<String> {
    return regex
        .findAll(corruptedInstructions)
        .map { it.value }
        .toList()
}

fun executeInstruction(instruction: String): Int {
    return instruction
        .slice(4..<instruction.length -1)
        .split(",")
        .map(String::toInt)
        .let { it[0] * it[1] }
}

fun main() {
        recoverInstructions(input, iMult)
        .map(::executeInstruction)
        .fold(0) { acc, value ->
            acc + value
        }
        .let { println(it) }
}