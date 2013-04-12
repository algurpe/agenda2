/**
 * 
 */
package agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Alberto Gurpegui
 *
 */
public class Agenda extends JFrame{
	/*Objeto de ConexionBD*/
	private ConexionBD conexionBD;
	/*Objeto de ContactoDAO*/
	private ContactoDAO contactoDAO;
	/*Objeto de Contacto*/
	private Contacto contacto;
	
	/*Elementos (lado Izquierdo) para el panel de Textos y sus etiquetas para introducir/presentar los datos*/
	private JTextField[] campoTexto;
	private JLabel[] etiqueta;
	private JPanel panelTextoEtiquetas;
	/*Elementos (lado Derecho)para el panel de los botones de funcionalidad(Insertar,Modificar,Borrar,Listar,Buscar)*/
	private JButton[] botones;	
	private JPanel panelBotones;
		
	/*Elementos (Centro) para el panel central: area para mostrar telefonos,botones siguiente y anterior y texto-etiqueta para Nº de contactos*/
	private JTextField campoTextoNumeroContactos;
	private JLabel etiquetaNumeroContactos;
	private JLabel etiquetaTelefono;
	private JTextArea areaTelefono;
	private JPanel panelCentral;
	private JButton botonSiguiente;
	private JButton botonAnterior;
	
	/**
	 * Constructor de Agenda. Clase que sera una ventana ejecutable.
	 */
	public Agenda(){
		super("Agenda");
		Container contenedor=getContentPane();
		/*añadir 5 etiquetas y 5 campos de texto y añadirlos al panel, que colocaremos ala izquierda de la ventana.*/
		campoTexto=new JTextField[5];
		etiqueta=new JLabel[5];
		panelTextoEtiquetas=new JPanel();
		panelTextoEtiquetas.setLayout(new GridLayout(5,2));
		for (int i=0;i<5;i++){
			String cadena="";
			switch(i){
			case 0:cadena="Id";break;
			case 1:cadena="Nombre";break;
			case 2:cadena="Apellidos";break;
			case 3:cadena="Email";break;
			case 4:cadena="Sueldo";break;
			}
			campoTexto[i]=new JTextField(10);
			etiqueta[i]=new JLabel(cadena);
			panelTextoEtiquetas.add(etiqueta[i]);	
			panelTextoEtiquetas.add(campoTexto[i]);					
		}		
		contenedor.add(panelTextoEtiquetas,BorderLayout.WEST);
		/*añadir 5 botones en un panellBotones*/
		botones=new JButton[5];
		panelBotones=new JPanel();
		panelBotones.setLayout(new GridLayout(5,1));
		for (int i=0;i<5;i++){
			String cadena="";
			switch(i){
			case 0:cadena="Insertar";break;
			case 1:cadena="Modificar";break;
			case 2:cadena="Borrar";break;
			case 3:cadena="Listar";break;
			case 4:cadena="Buscar";break;
			}
			botones[i]=new JButton(cadena);
			panelBotones.add(botones[i]);
		}
		contenedor.add(panelBotones,BorderLayout.EAST);
		
		/*Añadir panel Central*/
		JTextField campoTextoNumeroContactos=new JTextField(3);
		JLabel etiquetaNumeroContactos=new JLabel("Nº Contactos:");	
		JButton botonSiguiente=new JButton("Siguiente");
		JButton botonAnterior=new JButton("Anterior");
		JLabel etiquetaTelefono=new JLabel("Teléfonos");
		JTextArea areaTelefono=new JTextArea(7,10);		
		JPanel panelCentral=new JPanel();
		panelCentral.setLayout(new FlowLayout());
		panelCentral.add(etiquetaNumeroContactos);
		panelCentral.add(campoTextoNumeroContactos);
		panelCentral.add(botonSiguiente);
		panelCentral.add(botonAnterior);
		panelCentral.add(etiquetaTelefono);
		panelCentral.add(areaTelefono);
		contenedor.add(panelCentral,BorderLayout.CENTER);
		
		/*Escuchadores*/
		ManejadorBoton0_Insertar manejadorBoton0=new ManejadorBoton0_Insertar();
		botones[0].addActionListener(manejadorBoton0);
		
		/*Tamaño del formulario*/
		setSize(500,230);
		setVisible(true);	
		
		
		
		
	}
		/*Clases internas privadas para manejar los eventos de los botones*/
	private class ManejadorBoton0_Insertar implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			/*Implementar regEx y campos obligatorios*/
			campoTexto[0].setText("");
			campoTexto[0].setEditable(false);
			Contacto contacto=new Contacto(campoTexto[1].getText(),campoTexto[2].getText(),campoTexto[3].getText(),campoTexto[4].getText());
			ConexionBD conexionBD=new ConexionBD();
			conexionBD.conectar();
			ContactoDAO contactoDAO=new ContactoDAO(conexionBD.getConnection());
			contactoDAO.insertContacto(contacto);
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agenda aplicacion=new Agenda();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
