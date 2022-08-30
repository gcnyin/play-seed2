package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class HomeController @Inject() (
    cc: ControllerComponents
)(implicit
    ec: ExecutionContext
) extends AbstractController(cc) {
  def home(): Action[AnyContent] = Action { Ok("ok") }
}
