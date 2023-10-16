// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:19
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseStudentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def addStudent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StudentController.addStudent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addStudent"})
        }
      """
    )
  
    // @LINE:7
    def getStudentById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StudentController.getStudentById",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getStudentById"})
        }
      """
    )
  
    // @LINE:16
    def getAllStudents: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StudentController.getAllStudents",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllStudents"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseAttendanceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def addAttendance: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttendanceController.addAttendance",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addAttendance"})
        }
      """
    )
  
    // @LINE:9
    def addBulkAttendance: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttendanceController.addBulkAttendance",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBulkAttendance"})
        }
      """
    )
  
    // @LINE:15
    def getAttendanceByRollNo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttendanceController.getAttendanceByRollNo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAttendanceByRollNo"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseTeacherController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def addTeacher: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TeacherController.addTeacher",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addTeacher"})
        }
      """
    )
  
    // @LINE:13
    def getTeacherById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TeacherController.getTeacherById",
      """
        function(teacherId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTeacherById/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("teacherId", teacherId0))})
        }
      """
    )
  
    // @LINE:14
    def getAllTeachers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TeacherController.getAllTeachers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllTeachers"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def authenticateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.authenticateUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticateUser"})
        }
      """
    )
  
    // @LINE:12
    def registerUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.registerUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registerUser"})
        }
      """
    )
  
  }


}
