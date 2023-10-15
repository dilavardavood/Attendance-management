// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  StudentController_0: controllers.StudentController,
  // @LINE:13
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    StudentController_0: controllers.StudentController,
    // @LINE:13
    Assets_1: controllers.Assets
  ) = this(errorHandler, StudentController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, StudentController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addStudent""", """controllers.StudentController.addStudent(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getStudentById""", """controllers.StudentController.getStudentById(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllStudents""", """controllers.StudentController.getAllStudents(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_StudentController_addStudent0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addStudent")))
  )
  private[this] lazy val controllers_StudentController_addStudent0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StudentController_0.addStudent(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "addStudent",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """addStudent""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_StudentController_getStudentById1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getStudentById")))
  )
  private[this] lazy val controllers_StudentController_getStudentById1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StudentController_0.getStudentById(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "getStudentById",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """getStudentById""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_StudentController_getAllStudents2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllStudents")))
  )
  private[this] lazy val controllers_StudentController_getAllStudents2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StudentController_0.getAllStudents(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "getAllStudents",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """getAllStudents""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_StudentController_addStudent0_route(params@_) =>
      call { 
        controllers_StudentController_addStudent0_invoker.call(
          req => StudentController_0.addStudent(req))
      }
  
    // @LINE:8
    case controllers_StudentController_getStudentById1_route(params@_) =>
      call { 
        controllers_StudentController_getStudentById1_invoker.call(
          req => StudentController_0.getStudentById(req))
      }
  
    // @LINE:10
    case controllers_StudentController_getAllStudents2_route(params@_) =>
      call { 
        controllers_StudentController_getAllStudents2_invoker.call(
          req => StudentController_0.getAllStudents(req))
      }
  
    // @LINE:13
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
