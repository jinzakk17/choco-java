package yose;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

import com.google.gson.Gson;

//import jdk.internal.org.objectweb.asm.*;

public class YoseGame {
    public static void main(String[] args) {
    	port(getHerokuAssignedPort());
    	
    	Gson gson = new Gson();
    	
    	get("/", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "index.ftl");
        }, new FreeMarkerEngine());

    	get("/astroport", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "chocoastroport.ftl");
        }, new FreeMarkerEngine());
    	
    	get("/ping", (request, response) -> {
    		response.type("application/json");
    		
    		return new Status(true); 
    	}, gson::toJson);
    	
    	get("/contact", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "contact.ftl");
        }, new FreeMarkerEngine());
    	
    	get("/primefactors", (request,response) -> {
    		String param = request.queryParams("number");
    		return "Hello: " + param;
    	});
    	
    	get("/minesweeper", (request, response) -> {
    		response.type("text/html");
            return new ModelAndView(new Object(), "minesweeper.ftl");
        }, new FreeMarkerEngine());
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
