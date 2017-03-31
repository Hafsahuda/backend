package controllers.security;

import com.fasterxml.jackson.databind.JsonNode;
import models.Owner;
import play.Logger;
import play.mvc.Http;
import play.mvc.Result;
import services.OwnerService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.request;

/**
 * Created by Sivani on 09/03/17.
 */
public class OwnerVerifiedAction extends play.mvc.Action.Simple{


    private final OwnerService ownerService;

    @Inject
    public OwnerVerifiedAction(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public CompletionStage<Result> call(Http.Context ctx){
        JsonNode json = request().body().asJson();
        Logger.debug(""+json);
        final Owner owner = ownerService.getOwnerByName(json.get("oname").asText());
        if (null == owner) {
            return CompletableFuture.completedFuture(unauthorized("Invalid credentials"));
        }
        if(owner.getVerified() == 0){
            return CompletableFuture.completedFuture(forbidden("Your email id is not verified."));
        }
        return delegate.call(ctx);
    }
}

