package controllers

import javax.inject.{Singleton, Inject}
import akka.actor.ActorSystem
import com.radiance.actors.dummy.HelloActor
import com.radiance.actors.dummy.HelloActor.SayHello
import com.radiance.actors.sources.{DataSource}
import com.radiance.actors.sources.DataSource.addCurrentDataSource
import com.radiance.param.sources.DataSourceRow
import play.api._
import play.api.libs.json.JsValue
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent.duration._
import akka.pattern.ask


class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}
@Singleton
class dummyapp @Inject() (system: ActorSystem) extends Controller {

  implicit val timeout = akka.util.Timeout(5 seconds)
  val helloActor = system.actorOf(HelloActor.props, "hello-actor")

  def dummyHello= Action.async {
    (helloActor ? SayHello).mapTo[String].map { message =>
      Ok(message)
    }
  }

  val dataSourceActor = system.actorOf(DataSource.props,"datasource-actor")

  def addDataSource = Action.async {request => {

    val body: AnyContent = request.body
    val jsonBody = body.asJson

    var aa:DataSourceRow = null
    println("json dataaa --> ", jsonBody)

    var jsonPayLoad: Map[String, String] = Map()
    jsonBody.map(JsValue=>{

      val ip = JsValue \ "IP"
      val name = JsValue \ "name"

      jsonPayLoad = Map(
      "IP" -> ip.get.toString,
      "Name" -> name.get.toString
      )

      aa = DataSourceRow(1,name.get.toString(),"hostname",ip.get.toString(),"ipv6","path")
    })

    println("jsonPayLoad ",jsonPayLoad)

    (dataSourceActor ? addCurrentDataSource(aa)).mapTo[String].map { message =>
      Ok(message)
    }
   }
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }



  def allservices = Action {

    Ok(views.html.services.service())
  }


}