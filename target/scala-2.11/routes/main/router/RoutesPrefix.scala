
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/hafsafatima/backendh/conf/routes
// @DATE:Tue Mar 14 15:38:23 IST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
