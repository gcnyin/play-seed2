package controllers.users

import java.util.UUID

final case class CreateUserResponse(userId: UUID)

object CreateUserResponse {
  import play.api.libs.json.{Json, OFormat}
  implicit val format: OFormat[CreateUserResponse] = Json.format[CreateUserResponse]
}
