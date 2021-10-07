package edu.eci.seguridad;

public class Estudiante {
	
	private String nombre;
	private char sexo;
	private String correo;
	
	public Estudiante(){}

	public Estudiante(String nombre,char sexo, String correo) {
		this.nombre=nombre;
		this.sexo=sexo;
		this.correo=correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
