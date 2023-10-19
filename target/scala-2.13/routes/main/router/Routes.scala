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
  // @LINE:10
  TeacherController_2: controllers.TeacherController,
  // @LINE:11
  UserController_3: controllers.UserController,
  // @LINE:28
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    StudentController_0: controllers.StudentController,
    // @LINE:8
    AttendanceController_1: controllers.AttendanceController,
    // @LINE:10
    TeacherController_2: controllers.TeacherController,
    // @LINE:11
    UserController_3: controllers.UserController,
    // @LINE:28
    Assets_4: controllers.Assets
  ) = this(errorHandler, StudentController_0, AttendanceController_1, TeacherController_2, UserController_3, Assets_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, StudentController_0, AttendanceController_1, TeacherController_2, UserController_3, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addStudent""", """controllers.StudentController.addStudent(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getStudentById""", """controllers.StudentController.getStudentById(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addAttendance""", """controllers.AttendanceController.addAttendance(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addBulkAttendance""", """controllers.AttendanceController.addBulkAttendance(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addTeacher""", """controllers.TeacherController.addTeacher(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authenticateUser""", """controllers.UserController.authenticateUser(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registerUser""", """controllers.UserController.registerUser(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttendanceCountByStatus""", """controllers.AttendanceController.getAttendanceCountByStatus(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getStatusCountByDateRange""", """controllers.AttendanceController.getStatusCountByDateRange(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllClassNames""", """controllers.StudentController.getAllClassNames()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTeacherById/""" + "$" + """teacherId<[^/]+>""", """controllers.TeacherController.getTeacherById(teacherId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllTeachers""", """controllers.TeacherController.getAllTeachers()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttendanceByRollNo""", """controllers.AttendanceController.getAttendanceByRollNo(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllStudents""", """controllers.StudentController.getAllStudents(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllAttendance""", """controllers.AttendanceController.getAllAttendance()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttendanceByFilter""", """controllers.AttendanceController.getAttendanceByFilter(request:Request)"""),
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
  private[this] lazy val controllers_TeacherController_addTeacher4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addTeacher")))
  )
  private[this] lazy val controllers_TeacherController_addTeacher4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TeacherController_2.addTeacher(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TeacherController",
      "addTeacher",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """addTeacher""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_authenticateUser5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticateUser")))
  )
  private[this] lazy val controllers_UserController_authenticateUser5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.authenticateUser(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "authenticateUser",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """authenticateUser""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_registerUser6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registerUser")))
  )
  private[this] lazy val controllers_UserController_registerUser6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.registerUser(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "registerUser",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """registerUser""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_AttendanceController_getAttendanceCountByStatus7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttendanceCountByStatus")))
  )
  private[this] lazy val controllers_AttendanceController_getAttendanceCountByStatus7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AttendanceController_1.getAttendanceCountByStatus(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "getAttendanceCountByStatus",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """getAttendanceCountByStatus""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_AttendanceController_getStatusCountByDateRange8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getStatusCountByDateRange")))
  )
  private[this] lazy val controllers_AttendanceController_getStatusCountByDateRange8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AttendanceController_1.getStatusCountByDateRange(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "getStatusCountByDateRange",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """getStatusCountByDateRange""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_StudentController_getAllClassNames9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllClassNames")))
  )
  private[this] lazy val controllers_StudentController_getAllClassNames9_invoker = createInvoker(
    StudentController_0.getAllClassNames(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "getAllClassNames",
      Nil,
      "GET",
      this.prefix + """getAllClassNames""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_TeacherController_getTeacherById10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTeacherById/"), DynamicPart("teacherId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TeacherController_getTeacherById10_invoker = createInvoker(
    TeacherController_2.getTeacherById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TeacherController",
      "getTeacherById",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """getTeacherById/""" + "$" + """teacherId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_TeacherController_getAllTeachers11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllTeachers")))
  )
  private[this] lazy val controllers_TeacherController_getAllTeachers11_invoker = createInvoker(
    TeacherController_2.getAllTeachers(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TeacherController",
      "getAllTeachers",
      Nil,
      "GET",
      this.prefix + """getAllTeachers""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_AttendanceController_getAttendanceByRollNo12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttendanceByRollNo")))
  )
  private[this] lazy val controllers_AttendanceController_getAttendanceByRollNo12_invoker = createInvoker(
    
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

  // @LINE:19
  private[this] lazy val controllers_StudentController_getAllStudents13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllStudents")))
  )
  private[this] lazy val controllers_StudentController_getAllStudents13_invoker = createInvoker(
    
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

  // @LINE:20
  private[this] lazy val controllers_AttendanceController_getAllAttendance14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllAttendance")))
  )
  private[this] lazy val controllers_AttendanceController_getAllAttendance14_invoker = createInvoker(
    AttendanceController_1.getAllAttendance(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "getAllAttendance",
      Nil,
      "GET",
      this.prefix + """getAllAttendance""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_AttendanceController_getAttendanceByFilter15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttendanceByFilter")))
  )
  private[this] lazy val controllers_AttendanceController_getAttendanceByFilter15_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AttendanceController_1.getAttendanceByFilter(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttendanceController",
      "getAttendanceByFilter",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """getAttendanceByFilter""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Assets_versioned16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned16_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
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
    case controllers_TeacherController_addTeacher4_route(params@_) =>
      call { 
        controllers_TeacherController_addTeacher4_invoker.call(
          req => TeacherController_2.addTeacher(req))
      }
  
    // @LINE:11
    case controllers_UserController_authenticateUser5_route(params@_) =>
      call { 
        controllers_UserController_authenticateUser5_invoker.call(
          req => UserController_3.authenticateUser(req))
      }
  
    // @LINE:12
    case controllers_UserController_registerUser6_route(params@_) =>
      call { 
        controllers_UserController_registerUser6_invoker.call(
          req => UserController_3.registerUser(req))
      }
  
    // @LINE:13
    case controllers_AttendanceController_getAttendanceCountByStatus7_route(params@_) =>
      call { 
        controllers_AttendanceController_getAttendanceCountByStatus7_invoker.call(
          req => AttendanceController_1.getAttendanceCountByStatus(req))
      }
  
    // @LINE:14
    case controllers_AttendanceController_getStatusCountByDateRange8_route(params@_) =>
      call { 
        controllers_AttendanceController_getStatusCountByDateRange8_invoker.call(
          req => AttendanceController_1.getStatusCountByDateRange(req))
      }
  
    // @LINE:15
    case controllers_StudentController_getAllClassNames9_route(params@_) =>
      call { 
        controllers_StudentController_getAllClassNames9_invoker.call(StudentController_0.getAllClassNames())
      }
  
    // @LINE:16
    case controllers_TeacherController_getTeacherById10_route(params@_) =>
      call(params.fromPath[Int]("teacherId", None)) { (teacherId) =>
        controllers_TeacherController_getTeacherById10_invoker.call(TeacherController_2.getTeacherById(teacherId))
      }
  
    // @LINE:17
    case controllers_TeacherController_getAllTeachers11_route(params@_) =>
      call { 
        controllers_TeacherController_getAllTeachers11_invoker.call(TeacherController_2.getAllTeachers())
      }
  
    // @LINE:18
    case controllers_AttendanceController_getAttendanceByRollNo12_route(params@_) =>
      call { 
        controllers_AttendanceController_getAttendanceByRollNo12_invoker.call(
          req => AttendanceController_1.getAttendanceByRollNo(req))
      }
  
    // @LINE:19
    case controllers_StudentController_getAllStudents13_route(params@_) =>
      call { 
        controllers_StudentController_getAllStudents13_invoker.call(
          req => StudentController_0.getAllStudents(req))
      }
  
    // @LINE:20
    case controllers_AttendanceController_getAllAttendance14_route(params@_) =>
      call { 
        controllers_AttendanceController_getAllAttendance14_invoker.call(AttendanceController_1.getAllAttendance())
      }
  
    // @LINE:21
    case controllers_AttendanceController_getAttendanceByFilter15_route(params@_) =>
      call { 
        controllers_AttendanceController_getAttendanceByFilter15_invoker.call(
          req => AttendanceController_1.getAttendanceByFilter(req))
      }
  
    // @LINE:28
    case controllers_Assets_versioned16_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned16_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
