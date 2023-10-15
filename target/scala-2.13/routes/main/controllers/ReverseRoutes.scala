// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

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
  
    // @LINE:11
    def getAllStudents(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllStudents")
    }
  
  }

  // @LINE:8
  class ReverseAttendanceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def addAttendance(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addAttendance")
    }
  
    // @LINE:9
    def addBulkAttendance(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addBulkAttendance")
    }
  
    // @LINE:10
    def getAttendanceByRollNo(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAttendanceByRollNo")
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
