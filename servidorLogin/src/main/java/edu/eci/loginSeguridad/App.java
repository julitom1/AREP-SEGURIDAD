package edu.eci.loginSeguridad;


import spark.Request;
import spark.Response;

import static spark.Spark.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;





public class App {

	private static Service service;
	
	/**
	 * Inicio de la aplicación y contiene los endPoint
	 * @param args args
	 */
    public static void main(String [] args){
    	
    	secure("keystores/ecikeystore.p12", "123456", null, null);
    	
    	port(getPort());
    	URLReader.init();
    	service=new Service();
    	
        staticFiles.location("/public");
        post("/login", (req,res) -> enviarLogin(req,res));
        
  }

/**
 * 
 * @param req Lo que le llevo al servidor
 * @param res Lo que devolvera el servidor
 * @return Devuelve los datos del otro servidor, si es que puso las credenciales correctas 
 */
private static String enviarLogin(Request req, Response res) {		
		res.type("application/json");
		ObjectMapper mapper = new ObjectMapper();
		LoginDto logindto = new LoginDto();
		try {
			logindto = mapper.readValue(req.body(), LoginDto.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String devolver="";
		if(service.comparate(logindto)) {
			devolver=URLReader.readURL("https://ec2-3-92-208-215.compute-1.amazonaws.com:5001/obtenerinfo");
		}else {
			System.out.println(false);
		}
		return devolver;
		
	}


/**
 * Mira si existe un puerto, si no devuelve el 5000
 * @return   un puerto disponible
 */
private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5000;
  }





}
