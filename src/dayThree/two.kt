package dayThree

val iDo = "do\\(\\)".toRegex()
val iDont = "don't\\(\\)".toRegex()

fun Regex.union(vararg regexes: Regex): Regex {
    return "${this.pattern}|${regexes.joinToString("|") { it.pattern }}".toRegex()
}

fun executeInstructions(instructions: List<String>): Int {
    return instructions.fold(0 to true) { (acc, enabled), instruction ->
        when {
            iDo.matches(instruction) -> { acc to true }
            iDont.matches(instruction) -> { acc to false }
            iMult.matches(instruction) && enabled -> {
                acc + executeInstruction(instruction) to true
            }
            else -> { acc to enabled }
        }
    }.first
}

fun main() {
    recoverInstructions(input, iMult.union(iDo, iDont))
        .let(::executeInstructions)
        .let { println(it) }
}