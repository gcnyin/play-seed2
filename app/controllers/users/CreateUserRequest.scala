package controllers.users

final case class CreateUserRequest(username: String)

object CreateUserRequest {
  import play.api.libs.json.{Json, OFormat}
  implicit val format: OFormat[CreateUserRequest] = Json.format[CreateUserRequest]
}
