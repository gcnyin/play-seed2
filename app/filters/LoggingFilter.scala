package filters

import akka.stream.Materializer
import akka.util.ByteString
import play.api.Logging
import play.api.libs.streams.Accumulator
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class LoggingFilter @Inject() (implicit val mat: Materializer, ec: ExecutionContext) extends EssentialFilter with Logging {
  def apply(nextFilter: EssentialAction): EssentialAction = (requestHeader: RequestHeader) => {
    val startTime = System.currentTimeMillis
    val accumulator: Accumulator[ByteString, Result] = nextFilter(requestHeader)
    accumulator.map { result =>
      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime
      logger.info(s"${result.header.status} ${requestHeader.method} ${requestHeader.uri} ${requestTime}ms")
      result.withHeaders("X-Response-Time" -> requestTime.toString)
    }
  }
}
