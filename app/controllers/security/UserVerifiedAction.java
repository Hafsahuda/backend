package controllers.security;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import play.Logger;
import play.mvc.Http;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.request;

/**
 * Created by Sivani on 09/03/17.
 */
public class UserVerifiedAction extends play.mvc.Action.Simple{


    private final UserService userService;

    @Inject
    public UserVerifiedAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CompletionStage<Result> call(Http.Context ctx){
        JsonNode json = request().body().asJson();
        Logger.debug(""+json);
        final User user = userService.getUserByName(json.get("uname").asText());
        if (null == user) {
            return CompletableFuture.completedFuture(unauthorized("Invalid credentials"));
        }
        if(user.getVerified() == 0){
            return CompletableFuture.completedFuture(forbidden("Your email id is not verified."));
        }
        return delegate.call(ctx);
    }
}


