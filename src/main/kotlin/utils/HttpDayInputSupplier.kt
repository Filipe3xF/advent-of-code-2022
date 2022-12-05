package kotlin.utils

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlin.config.Configuration

class HttpDayInputSupplier(
    private val configuration: Configuration = Configuration.readConfiguration()
) : DayInputSupplier {

    private val client = HttpClient(CIO) { expectSuccess = false }

    override fun getDayInput(dayNumber: Int): Either<Throwable, List<String>> = runBlocking {
        client.use { httpClient ->
            httpClient.get("${configuration.host}/${configuration.year}/day/$dayNumber/input") {
                cookie("session", configuration.sessionCookie)
            }.run {
                val body: String = body()

                if (status == HttpStatusCode.OK)
                    handleSuccessResponse(body).right()
                else
                    handleFailureResponse(body).left()
            }
        }
    }

    private fun handleSuccessResponse(responseContent: String) = responseContent.trim().split("\n")

    private fun handleFailureResponse(responseContent: String) = HttpDayInputRequestError(responseContent)

    class HttpDayInputRequestError(message: String) : Throwable(message)
}
