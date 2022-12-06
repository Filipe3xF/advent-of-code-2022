import utils.Day

fun main() = Day(
    number = 1,
    inputTransformation = ::getTotalCaloriesOfEachElf,
    partOneSolution = { it.getSumOfTheTotalCaloriesOfTheTopNElves(1) },
    partTwoSolution = { it.getSumOfTheTotalCaloriesOfTheTopNElves(3) },
).printResult()


fun getTotalCaloriesOfEachElf(input: String): List<Int> = input.split("\n\n").map { elf ->
    elf.lines().sumOf { calories -> calories.toInt() }
}

fun List<Int>.getSumOfTheTotalCaloriesOfTheTopNElves(n: Int) = sortedDescending().take(n).sum()
