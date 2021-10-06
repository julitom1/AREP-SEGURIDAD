package edu.eci.seguridad;

import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class App {

	
    public static void main(String [] args){;
    	secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        //sc= initSecureContext();
        get("/hello",(req,res) -> "hello world");
  }





private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5001;
  }
  
  
}
