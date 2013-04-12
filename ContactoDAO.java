/**
 * 
 */
package agenda;
import java.sql.*;
import java.text.MessageFormat;
import java.util.*;


/**Descripción: Clase que contiene los métodos necesarios para
 * implementar el acceso a los datos de los contactos en la BD 'agenda'.
 * 
 * @author Alberto Gurpegui
 *
 */
public class ContactoDAO {
	private Contacto contacto;
	
	/**Atributo privado	  'connection'	 tipo Connection. Contiene la conexion con la base de datos 'agenda', generada
	 * en la clase ConexionBD
	 * @see ConexionBD
	 */	
	private Connection connection;
	
	/*Atributo privado	'objetoConexionBD'	  es una instancia de la clase ConexionBD. Mediante su método 
	 *  'getConnection()', el atributo 'connection' recibe el DriverManager que maneja la conexión con la BD 'agenda'
	 *  @see  ConexionBD
	 */
	private ConexionBD objetoConexionBD;
	
	/*Constructor de la clase ContactoDAO(Connection connection) con un parametro tipo Connection
	 * @param	connecion	tipo Connection. 
	 */
	public ContactoDAO(Connection connection){		
		this.connection=connection;
	}
	/**Atributo privado		'rbContactoDAO'		tipo ResourceBundle.
	 * Obtiene recursos del archivo tipo properties 'contactoDAO.properties'.
	 * En ese archivo se deben (re)escribir las sentencias SQL necesarias en cada metodo.
	 */
	private ResourceBundle rbContactoDAO = ResourceBundle.getBundle("agenda.contactoDAO");
	private ResourceBundle rbConexionBD=ResourceBundle.getBundle("agenda.conexionBD");
	/*Metodo 	List getListaContactos(), devuelve una lista de contactos
	 * @return 	ArrayList
	 */	
	
	/*Metodo 	Contacto getContacto(String id)		devuelve el objeto Contacto que corresponde a su Id (su número identificativo)
	 * @param	id	 tipo String
	 * @return	objeto tipo Contacto
	 */
	public Contacto getContacto(Integer id){
		//contacto=new Contacto();
		//Sentencia SQL
																										//comprobar si es int, Integer, o String
		String sentencia=MessageFormat.format(rbContactoDAO.getString("obtenerContactoConId"), new Object[]{contacto.getId().intValue()});
		try{
			Statement st=connection.createStatement();
			ResultSet resultado=st.executeQuery(sentencia);
			contacto.setId(Integer.valueOf(resultado.getInt("id")));
			contacto.setNombre(resultado.getString("nombre"));
			contacto.setApellidos(resultado.getString("apellidos"));
			contacto.setEmail(resultado.getString("email"));
			contacto.setSueldo(resultado.getString("sueldo"));
			st.close();
		}
		catch(SQLException e){
			System.out.println("Error SQL en el metodo getContacto: "+e.getMessage());
		}
		
			contacto.toStringPorConsola();/*Comprobacion*/
		
		
		return contacto;
	}
	
	/*Metodo 	updateContacto(	Contacto contacto)
	 * @param	contacto	tipo Contacto
	 */
	public void updateContacto(	Contacto contacto){
		//Sentencia SQL
		String sentencia=MessageFormat.format(
				rbContactoDAO.getString("actualizarContacto"),
				new Object[]{Integer.valueOf(contacto.getId()),contacto.getNombre(),contacto.getApellidos(),contacto.getEmail(),contacto.getSueldo()});
	}
	
	/*Metodo 	deleteContacto(Contacto contacto)
	 * @param	contacto	tipo Contacto
	 */
	public void deleteContacto(Contacto contacto){
		//Sentencia SQL
	}
	
	/*Metodo 	insertContacto(Contacto contacto)
	 * @param	contacto	tipo Contacto creado con el constructor con los 4 parámetros introducidos.
	 * @return	contacto	tipo Contacto devuelto por la BD con el 'id' único correspondiente, creado al inertarlo en la BD.
	 * @see Contacto
	 */
	public Contacto insertContacto(Contacto contacto){		
		//sentencia SQL
		//IMPLEMENTAR el caso de que el contacto YA EXISTA en la BD		
		try {
			System.out.println(rbContactoDAO.getString("insertarContactoPorPreparedStatement"));
            PreparedStatement ps = connection.prepareStatement("INSERT INTO contactos VALUES(null,\"dd\",\"dd\",\"dd\",\"dd\")",
                    PreparedStatement.RETURN_GENERATED_KEYS);
     /*       ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellidos());
            ps.setString(3,contacto.getEmail());
            ps.setString(4, contacto.getSueldo());            
            ps.executeUpdate();	*/
            // Se obtiene la clave generada
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                contacto.setId(Integer.valueOf(rs.getInt(1)));                
            }
        } catch (SQLException e) {
        	System.out.println("Fallo en insertarContacto()"+e.getMessage());
            e.printStackTrace();
        }
		//prueba interna
		contacto.toStringPorConsola();
		return contacto;
		//return contacto;
	}
}
