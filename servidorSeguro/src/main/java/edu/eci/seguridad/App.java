package edu.eci.seguridad;

import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;




public class App {

	private static List<Estudiante> companeros;
    public static void main(String [] args){;
    	secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        companeros=new ArrayList<>();
        llenarCompaneros();
        URLReader.init();
        get("/obtenerinfo",(req,res) -> obtenerInfo(req,res));
    }

    private static void llenarCompaneros() {
		companeros.add(new Estudiante("Juan Garcia",'M',"juan.garcia-h@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Juan Mina",'M',"juan.mina@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Juan Herrera",'M',"juan.herrera-m@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Leidy Ducuara",'F',"leidy.ducuara@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Miguel Fuquene",'M',"miguel.fuquene@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Luis Amaya",'M',"luis.amaya-o@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Richard Urrera",'M',"richard.urrea@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Ricardo Amaya",'M',"ricardo.amaya@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Laura Bernal",'F',"laura.bernal-h@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Laura Izquierdo",'F',"laura.izquierdo@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Cristian Pineros",'M',"cristian.pineros@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Javier Lopez",'M',"javier.lopez-p@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Yarit Villalobos",'M',"yarit.villalobos@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Juan Posso",'M',"juan.posso@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Angelica Alfaro",'F',"maria.alfaro@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Santiago Lopez",'M',"santiago.lopez-o@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Daniel Ducuara",'M',"daniel.ducuara@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Kevin Garzon",'M',"kevin.garzon@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Johan Garrido",'M',"johan.garrido@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Lina Buitrago",'F',"lina.buitrago@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Angie Medina",'F',"angie.medina@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Ana Salazar",'F',"ana.salazar-b@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Jose Castro",'M',"jose.castro-o@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Juan Caceres",'M',"juan.caceres-l@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Crhystian Molano",'M',"crhystian.molano@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Cesar Ortiz",'M',"cesar.ortiz@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Jose Perez",'M',"jose.perez-le@mail.escuelaing.edu.co"));
		companeros.add(new Estudiante("Juan Contreras",'M',"juan.contreras-a@mail.escuelaing.edu.co"));		
	}

	public static String obtenerInfo(Request req, Response res) {
		res.type("application/json");
		Gson gson=new Gson();
		String JSON= gson.toJson(companeros);
    	return JSON;
    }




private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5001;
  }
  
  
}
