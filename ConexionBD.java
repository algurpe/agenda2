/**
 * 
 */
package agenda;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author usuario
 * @see ContactoDAO
 */
public class ConexionBD {
	
/**Atributo 'conexion' : tipo Connection.
 * Almacena la conexion con la base de datos 'agenda'.
 */
	Connection conexion;
/**
 * Atributo de tipo Recursos. Busca recursos en el archivo conexionBD.properties.
 */
	ResourceBundle rbConexion= ResourceBundle.getBundle("agenda.conexionBD");
	/** Metodo conectar()
	 *  Crea la conexion con la base de datos tipo MySQL llamada 'agenda', con los recursos obtenidos en el atributo 'rbConexion'.
	 *  Recoge las excepciones 'ClassNotFoundException' y 'SQLException'.
	 */
	public void conectar(){	
		try {		
			Class.forName(rbConexion.getString("driver"));
			Connection conexion = DriverManager.getConnection(rbConexion.getString("url"),rbConexion.getString("user"),rbConexion.getString("password"));
			System.out.println("Conexión creada con éxito en ConexionBD");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el Driver: "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error SQL: "+e.getMessage());
		}
	}
	/**Metodo getConnection()
	 * 
	 * @return devuelve, como valor del atributo 'conexion', el DriverManager de la conexion creada por el metodo getConnection 
	 */
	public Connection getConnection(){
		
		return conexion;
	}
}
