package yose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import com.google.gson.Gson;


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
    	
    	get("/primeFactors", (request,response) -> {
    		response.type("application/json");
    		
    		String param = request.queryParams("number");

    		int number = Integer.parseInt(param);

    		PowerOfTwo power = new PowerOfTwo();
    		power.listOfTwo.clear();
    		
    		List<Integer> decomposition = power.calculatePowerOfTwo(number);
    		
    		PowerOfTwoJson powerOfTwoJson = new PowerOfTwoJson(number, decomposition);
    		System.out.println(powerOfTwoJson);
    		return powerOfTwoJson;
    		
    	},gson::toJson);
    	
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