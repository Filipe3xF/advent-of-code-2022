package utils

import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test
import java.io.FileNotFoundException

class FileTest {

    @Test
    fun `reads files contents`() {
        val input = readFile("HelloWorld", "txt", "src/test/resources")

        assertSoftly {
            val inputLines = input.shouldBeRight()
            inputLines shouldBe """
                Hello,
                World!
            """.trimIndent()
        }
    }

    @Test
    fun `catches errors on reading files contents`() {
        val input = readFile("nonExistentFile", "nonExistentExtension", "non/existent/path")

        input.shouldBeLeft().shouldBeTypeOf<FileNotFoundException>()
    }
}
