package controllers;

import com.google.gson.Gson;
import java.util.Date;
import models.ByDesignEvent;
import org.apache.commons.lang.StringEscapeUtils;
import play.mvc.Controller;

public class ByDesignLogger extends Controller {
    public static void logEvent(){
        String body = params.get("body");
        body = StringEscapeUtils.unescapeJava(body);
        String target = body.substring(1, body.length() - 1);
        ByDesignEvent event = new Gson().fromJson(target, ByDesignEvent.class);
		event.eventDate = new Date();
        event.save();
    }
}
