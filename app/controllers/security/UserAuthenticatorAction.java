package controllers.security;

/**
 * Created by Sivani on 25/02/17.
 */

import models.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Http;
import play.mvc.Result;
import services.UserService;


import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class UserAuthenticatorAction extends play.mvc.Action.Simple {
    private final UserService userService;

    @Inject
    public UserAuthenticatorAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public CompletionStage<Result> call(Http.Context ctx) {


        Logger.info("Running UserAuthenticatorAction");

        final Http.Request request = ctx.request();

        final String authorized = request.getHeader("Authorization");
        Logger.debug("Authorized header: {}", authorized);

        if (!authorized.startsWith("Bearer ")) {
            return CompletableFuture.completedFuture(unauthorized());
        }

        final String authToken = authorized.substring(7);
        if (authorized.isEmpty()) {
            return CompletableFuture.completedFuture(unauthorized());
        }

        Logger.debug("auth_token: {}", authToken);

        final User user = userService.findUserByAuthToken(authToken);

        if (null == user) {
            return CompletableFuture.completedFuture(unauthorized("in user action"));
        }

        if(user.getExpTime().getTime() < System.currentTimeMillis()){
            return CompletableFuture.completedFuture(unauthorized("Time period expired. Please login again"));
        }

        Logger.debug("user: {}", user);

        ctx.args.put("user", user);

        return delegate.call(ctx);
    }
}
