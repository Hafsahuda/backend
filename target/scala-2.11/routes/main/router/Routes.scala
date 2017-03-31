
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/hafsafatima/backendh/conf/routes
// @DATE:Tue Mar 14 15:38:23 IST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_2: controllers.HomeController,
  // @LINE:9
  CountController_1: controllers.CountController,
  // @LINE:11
  AsyncController_3: controllers.AsyncController,
  // @LINE:14
  Assets_13: controllers.Assets,
  // @LINE:18
  RestaurantController_6: controllers.RestaurantController,
  // @LINE:25
  OwnerController_0: controllers.OwnerController,
  // @LINE:38
  UserController_9: controllers.UserController,
  // @LINE:50
  CuisineController_12: controllers.CuisineController,
  // @LINE:53
  AreaController_8: controllers.AreaController,
  // @LINE:58
  ImageController_5: controllers.ImageController,
  // @LINE:64
  RatingsController_11: controllers.RatingsController,
  // @LINE:69
  ReviewsController_10: controllers.ReviewsController,
  // @LINE:73
  ContactController_4: controllers.ContactController,
  // @LINE:76
  FavouritesController_7: controllers.FavouritesController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_2: controllers.HomeController,
    // @LINE:9
    CountController_1: controllers.CountController,
    // @LINE:11
    AsyncController_3: controllers.AsyncController,
    // @LINE:14
    Assets_13: controllers.Assets,
    // @LINE:18
    RestaurantController_6: controllers.RestaurantController,
    // @LINE:25
    OwnerController_0: controllers.OwnerController,
    // @LINE:38
    UserController_9: controllers.UserController,
    // @LINE:50
    CuisineController_12: controllers.CuisineController,
    // @LINE:53
    AreaController_8: controllers.AreaController,
    // @LINE:58
    ImageController_5: controllers.ImageController,
    // @LINE:64
    RatingsController_11: controllers.RatingsController,
    // @LINE:69
    ReviewsController_10: controllers.ReviewsController,
    // @LINE:73
    ContactController_4: controllers.ContactController,
    // @LINE:76
    FavouritesController_7: controllers.FavouritesController
  ) = this(errorHandler, HomeController_2, CountController_1, AsyncController_3, Assets_13, RestaurantController_6, OwnerController_0, UserController_9, CuisineController_12, AreaController_8, ImageController_5, RatingsController_11, ReviewsController_10, ContactController_4, FavouritesController_7, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, CountController_1, AsyncController_3, Assets_13, RestaurantController_6, OwnerController_0, UserController_9, CuisineController_12, AreaController_8, ImageController_5, RatingsController_11, ReviewsController_10, ContactController_4, FavouritesController_7, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants""", """controllers.RestaurantController.addRestaurant()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants/""" + "$" + """id<[^/]+>""", """controllers.RestaurantController.updateRestaurant(id:Integer)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants/""" + "$" + """id<[^/]+>""", """controllers.RestaurantController.deleteRestaurant(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants""", """controllers.RestaurantController.restaurantFilters()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """owners""", """controllers.OwnerController.getAllOwners()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """owners""", """controllers.OwnerController.addOwner()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """owners""", """controllers.OwnerController.updatePassword()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """owners""", """controllers.OwnerController.deleteOwner()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ownersRes""", """controllers.OwnerController.getResByOwnerID()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ownerSignIn""", """controllers.OwnerController.signIn()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ownerSignOut""", """controllers.OwnerController.signOut()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ownerByAuth""", """controllers.OwnerController.getOwnerByAuthToken()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotPwd""", """controllers.OwnerController.forgotPwd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """temPwd""", """controllers.OwnerController.checkAns()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """verify""", """controllers.OwnerController.verifyEmail()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getAllUsers()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.addUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.updatePassword()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.deleteUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userSignIn""", """controllers.UserController.signIn()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userSignOut""", """controllers.UserController.signOut()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userByAuth""", """controllers.UserController.getUserByAuthToken()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotPwdUser""", """controllers.UserController.forgotPwd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """temPwdUser""", """controllers.UserController.checkAns()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """verifyUser""", """controllers.UserController.verifyEmail()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cuisines""", """controllers.CuisineController.getCuisines()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """areas""", """controllers.AreaController.getAreas()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images""", """controllers.ImageController.uploadImage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """id<[^/]+>""", """controllers.ImageController.downloadImage(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """id<[^/]+>""", """controllers.ImageController.deleteImage(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ratings""", """controllers.RatingsController.addRating()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ratings""", """controllers.RatingsController.getRatingByUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reviews""", """controllers.ReviewsController.addReview()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reviews""", """controllers.ReviewsController.getReviewsByUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mail""", """controllers.ContactController.sendMail()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favourites""", """controllers.FavouritesController.addFavourite()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favourites""", """controllers.FavouritesController.getUserFavs()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_1.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_3.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_13.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_RestaurantController_addRestaurant4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants")))
  )
  private[this] lazy val controllers_RestaurantController_addRestaurant4_invoker = createInvoker(
    RestaurantController_6.addRestaurant(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "addRestaurant",
      Nil,
      "POST",
      """Restaurant""",
      this.prefix + """restaurants"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_RestaurantController_updateRestaurant5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RestaurantController_updateRestaurant5_invoker = createInvoker(
    RestaurantController_6.updateRestaurant(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "updateRestaurant",
      Seq(classOf[Integer]),
      "PUT",
      """""",
      this.prefix + """restaurants/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_RestaurantController_deleteRestaurant6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RestaurantController_deleteRestaurant6_invoker = createInvoker(
    RestaurantController_6.deleteRestaurant(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "deleteRestaurant",
      Seq(classOf[Integer]),
      "DELETE",
      """""",
      this.prefix + """restaurants/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_RestaurantController_restaurantFilters7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants")))
  )
  private[this] lazy val controllers_RestaurantController_restaurantFilters7_invoker = createInvoker(
    RestaurantController_6.restaurantFilters(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "restaurantFilters",
      Nil,
      "GET",
      """""",
      this.prefix + """restaurants"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_OwnerController_getAllOwners8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("owners")))
  )
  private[this] lazy val controllers_OwnerController_getAllOwners8_invoker = createInvoker(
    OwnerController_0.getAllOwners(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "getAllOwners",
      Nil,
      "GET",
      """Owner""",
      this.prefix + """owners"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_OwnerController_addOwner9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("owners")))
  )
  private[this] lazy val controllers_OwnerController_addOwner9_invoker = createInvoker(
    OwnerController_0.addOwner(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "addOwner",
      Nil,
      "POST",
      """""",
      this.prefix + """owners"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_OwnerController_updatePassword10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("owners")))
  )
  private[this] lazy val controllers_OwnerController_updatePassword10_invoker = createInvoker(
    OwnerController_0.updatePassword(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "updatePassword",
      Nil,
      "PUT",
      """""",
      this.prefix + """owners"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_OwnerController_deleteOwner11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("owners")))
  )
  private[this] lazy val controllers_OwnerController_deleteOwner11_invoker = createInvoker(
    OwnerController_0.deleteOwner(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "deleteOwner",
      Nil,
      "DELETE",
      """""",
      this.prefix + """owners"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_OwnerController_getResByOwnerID12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ownersRes")))
  )
  private[this] lazy val controllers_OwnerController_getResByOwnerID12_invoker = createInvoker(
    OwnerController_0.getResByOwnerID(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "getResByOwnerID",
      Nil,
      "GET",
      """""",
      this.prefix + """ownersRes"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_OwnerController_signIn13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ownerSignIn")))
  )
  private[this] lazy val controllers_OwnerController_signIn13_invoker = createInvoker(
    OwnerController_0.signIn(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "signIn",
      Nil,
      "POST",
      """""",
      this.prefix + """ownerSignIn"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_OwnerController_signOut14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ownerSignOut")))
  )
  private[this] lazy val controllers_OwnerController_signOut14_invoker = createInvoker(
    OwnerController_0.signOut(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "signOut",
      Nil,
      "GET",
      """""",
      this.prefix + """ownerSignOut"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_OwnerController_getOwnerByAuthToken15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ownerByAuth")))
  )
  private[this] lazy val controllers_OwnerController_getOwnerByAuthToken15_invoker = createInvoker(
    OwnerController_0.getOwnerByAuthToken(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "getOwnerByAuthToken",
      Nil,
      "GET",
      """""",
      this.prefix + """ownerByAuth"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_OwnerController_forgotPwd16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotPwd")))
  )
  private[this] lazy val controllers_OwnerController_forgotPwd16_invoker = createInvoker(
    OwnerController_0.forgotPwd(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "forgotPwd",
      Nil,
      "POST",
      """""",
      this.prefix + """forgotPwd"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_OwnerController_checkAns17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("temPwd")))
  )
  private[this] lazy val controllers_OwnerController_checkAns17_invoker = createInvoker(
    OwnerController_0.checkAns(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "checkAns",
      Nil,
      "POST",
      """""",
      this.prefix + """temPwd"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_OwnerController_verifyEmail18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("verify")))
  )
  private[this] lazy val controllers_OwnerController_verifyEmail18_invoker = createInvoker(
    OwnerController_0.verifyEmail(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OwnerController",
      "verifyEmail",
      Nil,
      "GET",
      """""",
      this.prefix + """verify"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_UserController_getAllUsers19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_getAllUsers19_invoker = createInvoker(
    UserController_9.getAllUsers(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAllUsers",
      Nil,
      "GET",
      """User""",
      this.prefix + """users"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_UserController_addUser20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_addUser20_invoker = createInvoker(
    UserController_9.addUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUser",
      Nil,
      "POST",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_UserController_updatePassword21_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_updatePassword21_invoker = createInvoker(
    UserController_9.updatePassword(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updatePassword",
      Nil,
      "PUT",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:41
  private[this] lazy val controllers_UserController_deleteUser22_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_deleteUser22_invoker = createInvoker(
    UserController_9.deleteUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Nil,
      "DELETE",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:42
  private[this] lazy val controllers_UserController_signIn23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userSignIn")))
  )
  private[this] lazy val controllers_UserController_signIn23_invoker = createInvoker(
    UserController_9.signIn(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "signIn",
      Nil,
      "POST",
      """""",
      this.prefix + """userSignIn"""
    )
  )

  // @LINE:43
  private[this] lazy val controllers_UserController_signOut24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userSignOut")))
  )
  private[this] lazy val controllers_UserController_signOut24_invoker = createInvoker(
    UserController_9.signOut(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "signOut",
      Nil,
      "GET",
      """""",
      this.prefix + """userSignOut"""
    )
  )

  // @LINE:44
  private[this] lazy val controllers_UserController_getUserByAuthToken25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userByAuth")))
  )
  private[this] lazy val controllers_UserController_getUserByAuthToken25_invoker = createInvoker(
    UserController_9.getUserByAuthToken(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUserByAuthToken",
      Nil,
      "GET",
      """""",
      this.prefix + """userByAuth"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_UserController_forgotPwd26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotPwdUser")))
  )
  private[this] lazy val controllers_UserController_forgotPwd26_invoker = createInvoker(
    UserController_9.forgotPwd(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "forgotPwd",
      Nil,
      "POST",
      """""",
      this.prefix + """forgotPwdUser"""
    )
  )

  // @LINE:46
  private[this] lazy val controllers_UserController_checkAns27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("temPwdUser")))
  )
  private[this] lazy val controllers_UserController_checkAns27_invoker = createInvoker(
    UserController_9.checkAns(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "checkAns",
      Nil,
      "POST",
      """""",
      this.prefix + """temPwdUser"""
    )
  )

  // @LINE:47
  private[this] lazy val controllers_UserController_verifyEmail28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("verifyUser")))
  )
  private[this] lazy val controllers_UserController_verifyEmail28_invoker = createInvoker(
    UserController_9.verifyEmail(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "verifyEmail",
      Nil,
      "GET",
      """""",
      this.prefix + """verifyUser"""
    )
  )

  // @LINE:50
  private[this] lazy val controllers_CuisineController_getCuisines29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cuisines")))
  )
  private[this] lazy val controllers_CuisineController_getCuisines29_invoker = createInvoker(
    CuisineController_12.getCuisines(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CuisineController",
      "getCuisines",
      Nil,
      "GET",
      """Cuisine""",
      this.prefix + """cuisines"""
    )
  )

  // @LINE:53
  private[this] lazy val controllers_AreaController_getAreas30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("areas")))
  )
  private[this] lazy val controllers_AreaController_getAreas30_invoker = createInvoker(
    AreaController_8.getAreas(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AreaController",
      "getAreas",
      Nil,
      "GET",
      """Area""",
      this.prefix + """areas"""
    )
  )

  // @LINE:58
  private[this] lazy val controllers_ImageController_uploadImage31_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images")))
  )
  private[this] lazy val controllers_ImageController_uploadImage31_invoker = createInvoker(
    ImageController_5.uploadImage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImageController",
      "uploadImage",
      Nil,
      "POST",
      """""",
      this.prefix + """images"""
    )
  )

  // @LINE:59
  private[this] lazy val controllers_ImageController_downloadImage32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImageController_downloadImage32_invoker = createInvoker(
    ImageController_5.downloadImage(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImageController",
      "downloadImage",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """images/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:60
  private[this] lazy val controllers_ImageController_deleteImage33_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImageController_deleteImage33_invoker = createInvoker(
    ImageController_5.deleteImage(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImageController",
      "deleteImage",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """images/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:64
  private[this] lazy val controllers_RatingsController_addRating34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ratings")))
  )
  private[this] lazy val controllers_RatingsController_addRating34_invoker = createInvoker(
    RatingsController_11.addRating(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RatingsController",
      "addRating",
      Nil,
      "POST",
      """""",
      this.prefix + """ratings"""
    )
  )

  // @LINE:65
  private[this] lazy val controllers_RatingsController_getRatingByUser35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ratings")))
  )
  private[this] lazy val controllers_RatingsController_getRatingByUser35_invoker = createInvoker(
    RatingsController_11.getRatingByUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RatingsController",
      "getRatingByUser",
      Nil,
      "GET",
      """""",
      this.prefix + """ratings"""
    )
  )

  // @LINE:69
  private[this] lazy val controllers_ReviewsController_addReview36_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reviews")))
  )
  private[this] lazy val controllers_ReviewsController_addReview36_invoker = createInvoker(
    ReviewsController_10.addReview(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewsController",
      "addReview",
      Nil,
      "POST",
      """Reviews""",
      this.prefix + """reviews"""
    )
  )

  // @LINE:70
  private[this] lazy val controllers_ReviewsController_getReviewsByUser37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reviews")))
  )
  private[this] lazy val controllers_ReviewsController_getReviewsByUser37_invoker = createInvoker(
    ReviewsController_10.getReviewsByUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewsController",
      "getReviewsByUser",
      Nil,
      "GET",
      """""",
      this.prefix + """reviews"""
    )
  )

  // @LINE:73
  private[this] lazy val controllers_ContactController_sendMail38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mail")))
  )
  private[this] lazy val controllers_ContactController_sendMail38_invoker = createInvoker(
    ContactController_4.sendMail(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ContactController",
      "sendMail",
      Nil,
      "POST",
      """Contact""",
      this.prefix + """mail"""
    )
  )

  // @LINE:76
  private[this] lazy val controllers_FavouritesController_addFavourite39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favourites")))
  )
  private[this] lazy val controllers_FavouritesController_addFavourite39_invoker = createInvoker(
    FavouritesController_7.addFavourite(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavouritesController",
      "addFavourite",
      Nil,
      "POST",
      """Favourites""",
      this.prefix + """favourites"""
    )
  )

  // @LINE:77
  private[this] lazy val controllers_FavouritesController_getUserFavs40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favourites")))
  )
  private[this] lazy val controllers_FavouritesController_getUserFavs40_invoker = createInvoker(
    FavouritesController_7.getUserFavs(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavouritesController",
      "getUserFavs",
      Nil,
      "GET",
      """""",
      this.prefix + """favourites"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:9
    case controllers_CountController_count1_route(params) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_1.count)
      }
  
    // @LINE:11
    case controllers_AsyncController_message2_route(params) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_3.message)
      }
  
    // @LINE:14
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_13.versioned(path, file))
      }
  
    // @LINE:18
    case controllers_RestaurantController_addRestaurant4_route(params) =>
      call { 
        controllers_RestaurantController_addRestaurant4_invoker.call(RestaurantController_6.addRestaurant())
      }
  
    // @LINE:19
    case controllers_RestaurantController_updateRestaurant5_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_RestaurantController_updateRestaurant5_invoker.call(RestaurantController_6.updateRestaurant(id))
      }
  
    // @LINE:20
    case controllers_RestaurantController_deleteRestaurant6_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_RestaurantController_deleteRestaurant6_invoker.call(RestaurantController_6.deleteRestaurant(id))
      }
  
    // @LINE:21
    case controllers_RestaurantController_restaurantFilters7_route(params) =>
      call { 
        controllers_RestaurantController_restaurantFilters7_invoker.call(RestaurantController_6.restaurantFilters())
      }
  
    // @LINE:25
    case controllers_OwnerController_getAllOwners8_route(params) =>
      call { 
        controllers_OwnerController_getAllOwners8_invoker.call(OwnerController_0.getAllOwners())
      }
  
    // @LINE:26
    case controllers_OwnerController_addOwner9_route(params) =>
      call { 
        controllers_OwnerController_addOwner9_invoker.call(OwnerController_0.addOwner())
      }
  
    // @LINE:27
    case controllers_OwnerController_updatePassword10_route(params) =>
      call { 
        controllers_OwnerController_updatePassword10_invoker.call(OwnerController_0.updatePassword())
      }
  
    // @LINE:28
    case controllers_OwnerController_deleteOwner11_route(params) =>
      call { 
        controllers_OwnerController_deleteOwner11_invoker.call(OwnerController_0.deleteOwner())
      }
  
    // @LINE:29
    case controllers_OwnerController_getResByOwnerID12_route(params) =>
      call { 
        controllers_OwnerController_getResByOwnerID12_invoker.call(OwnerController_0.getResByOwnerID())
      }
  
    // @LINE:30
    case controllers_OwnerController_signIn13_route(params) =>
      call { 
        controllers_OwnerController_signIn13_invoker.call(OwnerController_0.signIn())
      }
  
    // @LINE:31
    case controllers_OwnerController_signOut14_route(params) =>
      call { 
        controllers_OwnerController_signOut14_invoker.call(OwnerController_0.signOut())
      }
  
    // @LINE:32
    case controllers_OwnerController_getOwnerByAuthToken15_route(params) =>
      call { 
        controllers_OwnerController_getOwnerByAuthToken15_invoker.call(OwnerController_0.getOwnerByAuthToken())
      }
  
    // @LINE:33
    case controllers_OwnerController_forgotPwd16_route(params) =>
      call { 
        controllers_OwnerController_forgotPwd16_invoker.call(OwnerController_0.forgotPwd())
      }
  
    // @LINE:34
    case controllers_OwnerController_checkAns17_route(params) =>
      call { 
        controllers_OwnerController_checkAns17_invoker.call(OwnerController_0.checkAns())
      }
  
    // @LINE:35
    case controllers_OwnerController_verifyEmail18_route(params) =>
      call { 
        controllers_OwnerController_verifyEmail18_invoker.call(OwnerController_0.verifyEmail())
      }
  
    // @LINE:38
    case controllers_UserController_getAllUsers19_route(params) =>
      call { 
        controllers_UserController_getAllUsers19_invoker.call(UserController_9.getAllUsers())
      }
  
    // @LINE:39
    case controllers_UserController_addUser20_route(params) =>
      call { 
        controllers_UserController_addUser20_invoker.call(UserController_9.addUser())
      }
  
    // @LINE:40
    case controllers_UserController_updatePassword21_route(params) =>
      call { 
        controllers_UserController_updatePassword21_invoker.call(UserController_9.updatePassword())
      }
  
    // @LINE:41
    case controllers_UserController_deleteUser22_route(params) =>
      call { 
        controllers_UserController_deleteUser22_invoker.call(UserController_9.deleteUser())
      }
  
    // @LINE:42
    case controllers_UserController_signIn23_route(params) =>
      call { 
        controllers_UserController_signIn23_invoker.call(UserController_9.signIn())
      }
  
    // @LINE:43
    case controllers_UserController_signOut24_route(params) =>
      call { 
        controllers_UserController_signOut24_invoker.call(UserController_9.signOut())
      }
  
    // @LINE:44
    case controllers_UserController_getUserByAuthToken25_route(params) =>
      call { 
        controllers_UserController_getUserByAuthToken25_invoker.call(UserController_9.getUserByAuthToken())
      }
  
    // @LINE:45
    case controllers_UserController_forgotPwd26_route(params) =>
      call { 
        controllers_UserController_forgotPwd26_invoker.call(UserController_9.forgotPwd())
      }
  
    // @LINE:46
    case controllers_UserController_checkAns27_route(params) =>
      call { 
        controllers_UserController_checkAns27_invoker.call(UserController_9.checkAns())
      }
  
    // @LINE:47
    case controllers_UserController_verifyEmail28_route(params) =>
      call { 
        controllers_UserController_verifyEmail28_invoker.call(UserController_9.verifyEmail())
      }
  
    // @LINE:50
    case controllers_CuisineController_getCuisines29_route(params) =>
      call { 
        controllers_CuisineController_getCuisines29_invoker.call(CuisineController_12.getCuisines())
      }
  
    // @LINE:53
    case controllers_AreaController_getAreas30_route(params) =>
      call { 
        controllers_AreaController_getAreas30_invoker.call(AreaController_8.getAreas())
      }
  
    // @LINE:58
    case controllers_ImageController_uploadImage31_route(params) =>
      call { 
        controllers_ImageController_uploadImage31_invoker.call(ImageController_5.uploadImage())
      }
  
    // @LINE:59
    case controllers_ImageController_downloadImage32_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ImageController_downloadImage32_invoker.call(ImageController_5.downloadImage(id))
      }
  
    // @LINE:60
    case controllers_ImageController_deleteImage33_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ImageController_deleteImage33_invoker.call(ImageController_5.deleteImage(id))
      }
  
    // @LINE:64
    case controllers_RatingsController_addRating34_route(params) =>
      call { 
        controllers_RatingsController_addRating34_invoker.call(RatingsController_11.addRating())
      }
  
    // @LINE:65
    case controllers_RatingsController_getRatingByUser35_route(params) =>
      call { 
        controllers_RatingsController_getRatingByUser35_invoker.call(RatingsController_11.getRatingByUser())
      }
  
    // @LINE:69
    case controllers_ReviewsController_addReview36_route(params) =>
      call { 
        controllers_ReviewsController_addReview36_invoker.call(ReviewsController_10.addReview())
      }
  
    // @LINE:70
    case controllers_ReviewsController_getReviewsByUser37_route(params) =>
      call { 
        controllers_ReviewsController_getReviewsByUser37_invoker.call(ReviewsController_10.getReviewsByUser())
      }
  
    // @LINE:73
    case controllers_ContactController_sendMail38_route(params) =>
      call { 
        controllers_ContactController_sendMail38_invoker.call(ContactController_4.sendMail())
      }
  
    // @LINE:76
    case controllers_FavouritesController_addFavourite39_route(params) =>
      call { 
        controllers_FavouritesController_addFavourite39_invoker.call(FavouritesController_7.addFavourite())
      }
  
    // @LINE:77
    case controllers_FavouritesController_getUserFavs40_route(params) =>
      call { 
        controllers_FavouritesController_getUserFavs40_invoker.call(FavouritesController_7.getUserFavs())
      }
  }
}
