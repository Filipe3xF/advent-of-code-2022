package utils

import arrow.core.Either
import utils.DayInputSupplier
import utils.readFile

class FileDayInputSupplier : DayInputSupplier {
    override fun getDayInput(dayNumber: Int): Either<Throwable, List<String>> =
        readFile("Day$dayNumber", "txt", "src/kotlin.main/resources/")
}
