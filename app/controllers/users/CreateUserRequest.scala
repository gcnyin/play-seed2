package controllers.users

import eu.timepit.refined.api._
import eu.timepit.refined.string._
import io.circe._
import io.circe.generic.semiauto._
import io.circe.refined._ // Appears to be unused but is actually in use

final case class CreateUserRequest(
    username: String Refined MatchesRegex["^[a-zA-Z0-9]{6,18}$"],
    password: String Refined MatchesRegex["^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$"]
)

object CreateUserRequest {
  implicit val value: Decoder[CreateUserRequest] = deriveDecoder[CreateUserRequest]
}
