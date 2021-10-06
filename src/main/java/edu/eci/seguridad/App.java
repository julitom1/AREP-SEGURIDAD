package edu.eci.seguridad;

import spark.Filter;
import static spark.Spark.*;




public class App {

	
    public static void main(String [] args){;
    //secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        staticFiles.location("/public");
      //  after((Filter) (request, response) -> {
    	//	response.header("Access-Control-Allow-Origin","*");
    		//response.header("Access-Control-Allow-Methods","GET");
    	//});
        //sc= initSecureContext();
        post("hello", (req,res) -> "Hello Dockerrr!");
        //get("login",(req,res) -> sc.valida);
  }



private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5001;
  }
  
  
}
