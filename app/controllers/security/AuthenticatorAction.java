package controllers.security;

import models.Owner;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Http;
import play.mvc.Result;
import services.OwnerService;


import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class AuthenticatorAction extends play.mvc.Action.Simple {

    private final OwnerService ownerService;

    @Inject
    public AuthenticatorAction(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    @Transactional
    public CompletionStage<Result> call(Http.Context ctx) {


        Logger.info("Running AuthenticatorAction");

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

        final Owner owner = ownerService.findUserByAuthToken(authToken);
        if (null == owner) {
            return CompletableFuture.completedFuture(unauthorized("in action"));
        }

        if(owner.getExpTime().getTime() < System.currentTimeMillis()){
            return CompletableFuture.completedFuture(unauthorized("Time period expired. Please login again"));
        }

        Logger.debug("user: {}", owner);

        ctx.args.put("user", owner);

        return delegate.call(ctx);
    }
}
