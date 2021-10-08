package edu.eci.loginSeguridad;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Service {
	
	private HashMap<String,User> usuarios;
	static char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
	
	/**
	 * Constructor y crea un usuario 
	 */
	public Service() {
		usuarios= new HashMap<String,User>();
		usuarios.put("yarit",new User("yarit",hashPassword("yaritvillalobos")));
	}
	
	/**
	 * Compara Si el usuario existe y la contrasena es la correcta 
	 * @param logindto credenciales que se enviaron
	 * @return si el usuario es valido o no
	 */

	public boolean comparate(LoginDto logindto) {
		
		return usuarios.containsKey(logindto.getUsuario()) && 
				hashPassword(logindto.getContrasena()).equals(usuarios.get(logindto.getUsuario()).getContrasena());
	}
	
	/**
	 * Vuelve en hash la clave
	 * @param clave   es la clave que le mandan
	 * @return vuelve la clave pero en hash
	 */
	private String hashPassword(String clave) {
		MessageDigest digest;
		String rtahash="";
		try {
			digest = MessageDigest.getInstance("SHA-256");
			digest.update(clave.getBytes("UTF-8"));
			byte[] hash = digest.digest();
			StringBuilder sb = new StringBuilder(hash.length * 2);
			for (byte b : hash) {
			    sb.append(HEX_CHARS[(b & 0xF0) >> 4]);
			    sb.append(HEX_CHARS[b & 0x0F]);
			}
			rtahash= sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return rtahash;
	}

}
