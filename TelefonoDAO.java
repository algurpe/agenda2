package agenda;

import java.sql.*;
import java.util.*;

/**Descripción: Clase que contiene los métodos necesarios para
 * implementar el acceso a los datos de los telefonos de los contactos en la BD 'agenda'.
 * 
 * @author Alberto Gurpegui
 *
 */
public class TelefonoDAO {
	/**Atributo 'conexion, tipo Connection.
	 * Almacenara la conexion con la BD 'agenda'
	 */
	private Connection conexion;
	/**Constructor de la clase telefonoDAO asociado a una conexion, tipo Connection, a la BD 'agenda'.
	 * @param conexion, tipo Connection.
	 */
	public TelefonoDAO(Connection conexion){
		this.conexion=conexion;
	}
	
	/** Metodo: getTelefono
	 * @param id	tipo Integer, 'id' del contacto de esa lista de telefonos.
	 * @return		tipo ArrayList, contiene los telefonos del contacto con ese 'id'.
	 */
	public ArrayList<String> getTelefono(Integer id){
		ArrayList<String> lista=new ArrayList<String>();
		return lista;
	}
	
	/** Metodo: eliminarTelefono 
	 * @param id_telefono
	 */
	public void eliminarTelefono(Integer id_telefono){
		
	}
	public void insertarTelefono(Integer id_telefono){
		
	}

}
