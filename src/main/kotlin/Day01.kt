import utils.Day

fun main() = Day(
    number = 1,
    inputTransformation = ::getTotalCaloriesOfEachElf,
    partOneSolution = { it.getTotalOfElfWithMostCalories() },
    partTwoSolution = { it.getSumOfTheTotalOfTheTopThreeElvesWithMostCalories() },
).printResult()


fun getTotalCaloriesOfEachElf(input: String): List<Int> = input.split("\n\n").map { elf ->
    elf.lines().sumOf { calories -> calories.toInt() }
}

fun List<Int>.getTotalOfElfWithMostCalories() = max()

fun List<Int>.getSumOfTheTotalOfTheTopThreeElvesWithMostCalories() = sortedDescending().take(3).sum()
