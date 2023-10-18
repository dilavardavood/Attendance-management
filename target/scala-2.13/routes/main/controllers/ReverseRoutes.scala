// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:26
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseStudentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def addStudent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addStudent")
    }
  
    // @LINE:7
    def getStudentById(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getStudentById")
    }
  
    // @LINE:17
    def getAllStudents(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllStudents")
    }
  
  }

  // @LINE:8
  class ReverseAttendanceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def addBulkAttendance(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addBulkAttendance")
    }
  
    // @LINE:13
    def getAttendanceCountByStatus(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAttendanceCountByStatus")
    }
  
    // @LINE:18
    def getAllAttendance(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllAttendance")
    }
  
    // @LINE:19
    def getAttendanceByFilter(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAttendanceByFilter")
    }
  
    // @LINE:16
    def getAttendanceByRollNo(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAttendanceByRollNo")
    }
  
    // @LINE:8
    def addAttendance(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addAttendance")
    }
  
  }

  // @LINE:10
  class ReverseTeacherController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def addTeacher(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addTeacher")
    }
  
    // @LINE:14
    def getTeacherById(teacherId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getTeacherById/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("teacherId", teacherId)))
    }
  
    // @LINE:15
    def getAllTeachers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllTeachers")
    }
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def authenticateUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "authenticateUser")
    }
  
    // @LINE:12
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "registerUser")
    }
  
  }


}
