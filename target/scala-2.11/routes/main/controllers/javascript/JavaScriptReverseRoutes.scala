
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/hafsafatima/backendh/conf/routes
// @DATE:Tue Mar 14 15:38:23 IST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseRestaurantController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def deleteRestaurant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.deleteRestaurant",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:18
    def addRestaurant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.addRestaurant",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants"})
        }
      """
    )
  
    // @LINE:19
    def updateRestaurant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.updateRestaurant",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:21
    def restaurantFilters: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.restaurantFilters",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants"})
        }
      """
    )
  
  }

  // @LINE:73
  class ReverseContactController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:73
    def sendMail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContactController.sendMail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mail"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:50
  class ReverseCuisineController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def getCuisines: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CuisineController.getCuisines",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuisines"})
        }
      """
    )
  
  }

  // @LINE:25
  class ReverseOwnerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def getAllOwners: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.getAllOwners",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "owners"})
        }
      """
    )
  
    // @LINE:28
    def deleteOwner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.deleteOwner",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "owners"})
        }
      """
    )
  
    // @LINE:31
    def signOut: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.signOut",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ownerSignOut"})
        }
      """
    )
  
    // @LINE:32
    def getOwnerByAuthToken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.getOwnerByAuthToken",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ownerByAuth"})
        }
      """
    )
  
    // @LINE:34
    def checkAns: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.checkAns",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "temPwd"})
        }
      """
    )
  
    // @LINE:35
    def verifyEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.verifyEmail",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "verify"})
        }
      """
    )
  
    // @LINE:27
    def updatePassword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.updatePassword",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "owners"})
        }
      """
    )
  
    // @LINE:33
    def forgotPwd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.forgotPwd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotPwd"})
        }
      """
    )
  
    // @LINE:29
    def getResByOwnerID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.getResByOwnerID",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ownersRes"})
        }
      """
    )
  
    // @LINE:26
    def addOwner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.addOwner",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "owners"})
        }
      """
    )
  
    // @LINE:30
    def signIn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OwnerController.signIn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ownerSignIn"})
        }
      """
    )
  
  }

  // @LINE:69
  class ReverseReviewsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:70
    def getReviewsByUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ReviewsController.getReviewsByUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reviews"})
        }
      """
    )
  
    // @LINE:69
    def addReview: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ReviewsController.addReview",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reviews"})
        }
      """
    )
  
  }

  // @LINE:64
  class ReverseRatingsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:65
    def getRatingByUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RatingsController.getRatingByUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ratings"})
        }
      """
    )
  
    // @LINE:64
    def addRating: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RatingsController.addRating",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ratings"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:53
  class ReverseAreaController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def getAreas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AreaController.getAreas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "areas"})
        }
      """
    )
  
  }

  // @LINE:58
  class ReverseImageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:59
    def downloadImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ImageController.downloadImage",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "images/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0))})
        }
      """
    )
  
    // @LINE:60
    def deleteImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ImageController.deleteImage",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "images/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0))})
        }
      """
    )
  
    // @LINE:58
    def uploadImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ImageController.uploadImage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "images"})
        }
      """
    )
  
  }

  // @LINE:76
  class ReverseFavouritesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:76
    def addFavourite: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FavouritesController.addFavourite",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "favourites"})
        }
      """
    )
  
    // @LINE:77
    def getUserFavs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FavouritesController.getUserFavs",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "favourites"})
        }
      """
    )
  
  }

  // @LINE:38
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:41
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.deleteUser",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:43
    def signOut: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.signOut",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userSignOut"})
        }
      """
    )
  
    // @LINE:46
    def checkAns: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.checkAns",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "temPwdUser"})
        }
      """
    )
  
    // @LINE:47
    def verifyEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.verifyEmail",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "verifyUser"})
        }
      """
    )
  
    // @LINE:44
    def getUserByAuthToken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUserByAuthToken",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userByAuth"})
        }
      """
    )
  
    // @LINE:40
    def updatePassword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updatePassword",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:45
    def forgotPwd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.forgotPwd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotPwdUser"})
        }
      """
    )
  
    // @LINE:38
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:42
    def signIn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.signIn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userSignIn"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }


}
