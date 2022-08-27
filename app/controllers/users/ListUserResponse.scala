package controllers.users

import java.time.Instant
import java.util.UUID

final case class ListUserResponse(users: Seq[ListUserResponse.User])

object ListUserResponse {
  import play.api.libs.json.{Json, OFormat}
  implicit val format: OFormat[ListUserResponse] = Json.format[ListUserResponse]

  final case class User(userId: UUID, username: String, createdAt: Instant)

  object User {
    implicit val format: OFormat[User] = Json.format[User]
  }
}
