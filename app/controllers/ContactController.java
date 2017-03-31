package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Contact;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import play.libs.Json;
import play.mvc.Result;


import static play.mvc.Controller.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by Sivani on 03/03/17.
 */
public class ContactController {
    public ContactController() {
    }

    public Result sendMail(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest();
        }

        Contact c = Json.fromJson(json,Contact.class);

        SimpleEmail email = new SimpleEmail();
        try {
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("hungerquest.mail@gmail.com","code4route"));
            email.setSSLOnConnect(true);
            email.setFrom("hungerquest.mail@gmail.com");
            email.addTo("hungerquest.mail@gmail.com");
            email.setSubject("Query");
            email.setMsg(c.getMessage() + "\n\n" + "From:\n" +c.getName() + "\n" + c.getEid() + "\n" + c.getPhno());
            email.send();
        }
        catch (Exception e){
            return badRequest(e.getMessage());
        }

        return ok();
    }
}
