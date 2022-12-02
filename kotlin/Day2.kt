import java.io.File

fun String.result() =
    when(this){
        "A X","B Y","C Z" -> 3
        "C X","B Z","A Y" -> 6
        else -> 0
    }

fun main() {
    val input = File("src/main/kotlin/Day2/input").readText().split("\n")

    val looseMap =  mapOf("A" to "Z", "B" to "X", "C" to "Y")
    val winMap =  mapOf("A" to "Y", "B" to "Z", "C" to "X")
    val drawMap =  mapOf("A" to "X", "B" to "Y", "C" to "Z")

    val selectMap =  mapOf("X" to 1, "Y" to 2, "Z" to 3)
    val resultMap =  mapOf("X" to 0, "Y" to 3, "Z" to 6)

    val ans1 = input.sumOf {
        val you = it.split(" ").last()
        selectMap[you]!! + it.result()
    }

    val ans2 = input.sumOf {
        val opp = it.split(" ").first()
        val you = it.split(" ").last()
        val result = resultMap[you]!!
        val selection = when(result){
            0 -> selectMap[looseMap[opp]]
            3 -> selectMap[drawMap[opp]]
            else -> selectMap[winMap[opp]]
        }!!
        result + selection
    }

    println(ans1)
    println(ans2)
}