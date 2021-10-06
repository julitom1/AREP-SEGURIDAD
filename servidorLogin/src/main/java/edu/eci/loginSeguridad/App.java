package edu.eci.loginSeguridad;

import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class App {

	private static Service service;
	
    public static void main(String [] args){
    	secure("keystores/ecikeystore.p12", "123456", null, null);
    	port(getPort());
        staticFiles.location("/public");
        service=new Service();
        post("login", (req,res) -> enviarLogin(req,res));
  }



private static String enviarLogin(Request req, Response res) {
		ObjectMapper mapper = new ObjectMapper();
		LoginDto logindto = new LoginDto();
		try {
			logindto = mapper.readValue(req.body(), LoginDto.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if(service.comparate(logindto)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		return "";
		
	}



private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5001;
  }
  
  
}
