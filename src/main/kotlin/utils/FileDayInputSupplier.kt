package utils

import arrow.core.Either

class FileDayInputSupplier : DayInputSupplier {
    override fun getDayInput(dayNumber: Int): Either<Throwable, String> =
        readFile("Day$dayNumber", "txt", "src/kotlin.main/resources/")
}
