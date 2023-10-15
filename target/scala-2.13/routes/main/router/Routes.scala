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
  // @LINE:8
  AttendanceController_1: controllers.AttendanceController,
  // @LINE:14
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    StudentController_0: controllers.StudentController,
    // @LINE:8
    AttendanceController_1: controllers.AttendanceController,
    // @LINE:14
    Assets_2: controllers.Assets
  ) = this(errorHandler, StudentController_0, AttendanceController_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, StudentController_0, AttendanceController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addStudent""", """controllers.StudentController.addStudent(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getStudentById""", """controllers.StudentController.getStudentById(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addAttendance""", """controllers.AttendanceController.addAttendance(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addBulkAttendance""", """controllers.AttendanceController.addBulkAttendance(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttendanceByRollNo""", """controllers.AttendanceController.getAttendanceByRollNo(request:Request)"""),
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

  // @LINE:7
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

  // @LINE:8
  private[this] lazy val controllers_AttendanceController_addAttendance2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addAttendance")))
  )
  private[this] lazy val controllers_AttendanceController_addAttendance2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AttendanceController_1.addAttendance(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "addAttendance",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """addAttendance""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AttendanceController_addBulkAttendance3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addBulkAttendance")))
  )
  private[this] lazy val controllers_AttendanceController_addBulkAttendance3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AttendanceController_1.addBulkAttendance(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "addBulkAttendance",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """addBulkAttendance""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AttendanceController_getAttendanceByRollNo4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttendanceByRollNo")))
  )
  private[this] lazy val controllers_AttendanceController_getAttendanceByRollNo4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AttendanceController_1.getAttendanceByRollNo(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "getAttendanceByRollNo",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """getAttendanceByRollNo""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_StudentController_getAllStudents5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllStudents")))
  )
  private[this] lazy val controllers_StudentController_getAllStudents5_invoker = createInvoker(
    
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

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
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
  
    // @LINE:7
    case controllers_StudentController_getStudentById1_route(params@_) =>
      call { 
        controllers_StudentController_getStudentById1_invoker.call(
          req => StudentController_0.getStudentById(req))
      }
  
    // @LINE:8
    case controllers_AttendanceController_addAttendance2_route(params@_) =>
      call { 
        controllers_AttendanceController_addAttendance2_invoker.call(
          req => AttendanceController_1.addAttendance(req))
      }
  
    // @LINE:9
    case controllers_AttendanceController_addBulkAttendance3_route(params@_) =>
      call { 
        controllers_AttendanceController_addBulkAttendance3_invoker.call(
          req => AttendanceController_1.addBulkAttendance(req))
      }
  
    // @LINE:10
    case controllers_AttendanceController_getAttendanceByRollNo4_route(params@_) =>
      call { 
        controllers_AttendanceController_getAttendanceByRollNo4_invoker.call(
          req => AttendanceController_1.getAttendanceByRollNo(req))
      }
  
    // @LINE:11
    case controllers_StudentController_getAllStudents5_route(params@_) =>
      call { 
        controllers_StudentController_getAllStudents5_invoker.call(
          req => StudentController_0.getAllStudents(req))
      }
  
    // @LINE:14
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
