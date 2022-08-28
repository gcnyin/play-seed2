package controllers.users

import eu.timepit.refined.api._
import eu.timepit.refined.string._

final case class CreateUserRequest(
    username: String Refined MatchesRegex["^[a-zA-Z0-9]{6,18}$"],
    password: String Refined MatchesRegex["^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$"]
)

object CreateUserRequest {
  import play.api.libs.json._
  import be.venneborg.refined.play.RefinedJsonFormats._ // Appears to be unused but is actually in use

  implicit val format: OFormat[CreateUserRequest] = Json.format[CreateUserRequest]
}
