import java.io.File

fun main() {
    File("src/main/kotlin/Day1/input")
        .readText()
        .split("\n\n")
        .map { it.split("\n").sumOf { it.toInt() } }
        .sorted()
        .let {
            println(it.last()) // part 1
            println(it.subList(it.size-3, it.size).sumOf { it }) // part 2
        }
}