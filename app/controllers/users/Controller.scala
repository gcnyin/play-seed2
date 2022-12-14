package controllers.users

import dao.Tables._
import dao.Tables.profile.api._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.libs.json._
import play.api.mvc._
import slick.jdbc.JdbcProfile

import java.time.Instant
import java.util.UUID
import javax.inject._
import scala.concurrent.ExecutionContext

@Singleton
class Controller @Inject() (
    protected val dbConfigProvider: DatabaseConfigProvider,
    val controllerComponents: ControllerComponents
)(implicit
    ec: ExecutionContext
) extends BaseController
    with HasDatabaseConfigProvider[JdbcProfile] {

  def listUser(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    for {
      users <- db.run(User.result)
      res = ListUserResponse(users = users.map(u => ListUserResponse.User(u.userId, u.username, u.createdAt)))
    } yield Ok(Json.toJson(res))
  }

  def createUser(): Action[CreateUserRequest] = Action.async(parse.json[CreateUserRequest]) { implicit request =>
    val userId = UUID.randomUUID()
    val CreateUserRequest(username, password) = request.body
    val now = Instant.now()
    for {
      _ <- db.run(
        User.insertOrUpdate(
          UserRow(userId = userId, username = username.value, password = password.value, createdAt = now, updatedAt = now)
        )
      )
    } yield Ok(Json.toJson(CreateUserResponse(userId)))
  }
}
