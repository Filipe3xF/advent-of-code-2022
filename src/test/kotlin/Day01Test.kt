import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day01Test {

    private val input = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
    """.trimIndent()

    private val totalCaloriesOfEachElf = listOf(
        6000,
        4000,
        11000,
        24000,
        10000
    )

    @Test
    fun `should get list of calories of each elf from input`() {
        getTotalCaloriesOfEachElf(input) shouldBe totalCaloriesOfEachElf
    }

    @Test
    fun `should get the sum of the total calories of the top elf with most calories`() {
        totalCaloriesOfEachElf.getSumOfTheTotalCaloriesOfTheTopNElves(1) shouldBe 24000
    }

    @Test
    fun `should get the sum of the total calories of the top 3 elves with most calories`() {
        totalCaloriesOfEachElf.getSumOfTheTotalCaloriesOfTheTopNElves(3) shouldBe 45000
    }
}
