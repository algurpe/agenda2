package agenda;

import java.util.List;
/**
 * Clase tipo Data Transfer Object
 * Clase que representa a cada contacto que contiene la BD 'agenda'.
 * @author usuario
 *
 */
public class Contacto implements Comparable{
/**
 * Atributo privado 'id' :
 * Tipo entro 'int',
 * UNICO para cada contacto
 */
	private Integer id;//Cambiar a Integer (Wrapper)
/**
 * Atributos privados  'nombre', 'apellidos', 'email' : 
 * tipo String
 */
	private String nombre;
	private String apellidos;
	private String email;
/**
 * Atributo privado 'telefono' :
 * estructura de datos tipo ArrayList<String>
 */
	private List<String> telefono;
/**
 * Atributo privado 'sueldo' :
 * tipo String	
 */
	private String sueldo;
	
	/*Constructor por defecto, sin parámetros
	 * 
	 */
	public Contacto(){
		
	}
	
	/*Constructor sobrecargado de la clase	Contacto	con los 4 parámetros imprescindibles. Nombre, apellidos, email y sueldo.
	 * Se introducirá el contacto en la BD, que generará un 'id' único.
	 * Antes de crear un nuevo contacto, se comprobará que no exista en la BD 'agenda'.
	 * @param String nombre,String apellidos,String email,String sueldo
	 * @see ContactoDAO
	 */
	public Contacto(String nombre,String apellidos,String email,String sueldo){
			this.nombre=nombre;
			this.apellidos=apellidos;
			this.email=email;
			this.sueldo=sueldo;
	}
	
	/**Sobreescritura: metodo 'equals' de la clase 'Contacto'.
	 * Un 'contacto' es igual a otro si tiene el mismo 'id'.
	 */
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Contacto other = (Contacto) obj;				
		if(this.id.equals(other.id)){   //acordarse de q id es Integer, ¿funciona?, creo q si por ser un (hereda de) Object
			return true;
		}			
		return false;
	}
	
	/**Implementación del método: CompareTO.
	 * Para ordenar los contactos alfabéticamente, PRIMERO, por 'nombre'; luego por 'apellidos'; por último, por 'email'.
	 */
	public int compareTo(Object obj){
		/**Compara un objeto de la clase Contacto con otro objeto de la misma clase, los compara y devuelve un valor tipo entero para conseguir una ordenacion alfabetica.
		 * Debe devolver POSITIVO (1) si es mayor alfabeticamente, NEGATIVO (-1) si es menor y cero (0) si 'nombre', 'apellidos' y 'email' son iguales.	 
		*/
		if (this==obj){
			return 0;
		}	
		Contacto other = (Contacto) obj;
		if (this.id.equals(other.id)){  //acordarse de q id es Integer, ¿funciona?, creo q si por ser un (hereda de) Object
			return 0;
		}
		if (nombre.compareTo(other.nombre)>0){
			return 1;
		}
		else if (nombre.compareTo(other.nombre)<0){
			return -1;
		}
		else {
			if (apellidos.compareTo(other.apellidos)>0){
				return 1;
			}
			else if (apellidos.compareTo(other.apellidos)<0){
				return -1;
			}
			else{
				if (email.compareTo(other.email)>0){
					return 1;					
				}
				if (email.compareTo(other.email)<0){
					return-1;
				}
					else {
						return 0;
					}
				}
			}		
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telefono
	 */
	public List<String> getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(List<String> telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the sueldo
	 */
	public String getSueldo() {
		return sueldo;
	}
	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}
	
	public void toStringPorConsola(){
		String cadena;
		cadena=this.id+" "+this.nombre+" "+this.apellidos+" "+this.email+" "+this.sueldo;
		System.out.println(cadena);
		
	}
}
