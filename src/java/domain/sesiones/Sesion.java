package domain.sesiones;

import domain.enums.ProductividadSesion;
import domain.tareas.Tarea;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que alberga la informaci�n y caracter�sticas
 * de una sesi�n de una tarea.
 * @author Jon�s Urbano Romero.
 * @see Tarea
 */
@XmlRootElement(name="sesion")
public class Sesion {
	private static double[] FACTORES_PRODUCTIVIDAD = {0.2, 0.6, 1};
	
	private long id;
	
	/**
	 * Fecha y hora a la que se realiz� la sesi�n.
	 */
	private Date fecha;
	
	/**
	 * N�mero de horas empleadas en la sesi�n de la tarea.
	 * Este campo debe ser especificado. No 0.0.
	 */
	private double duracion;
	private ProductividadSesion productividad;
	
	/**
	 * Tarea a la que pertenece la sesi�n.
	 * Necesario para Hibernate.
	 */
	private Tarea tarea;
	
	private Sesion() {};
	
	/**
	 * Constructor del tipo Sesion.
	 * @param fecha
	 * @param horasEmpleadas
	 * @param productividad
	 */
	public Sesion(Date fecha,double horasEmpleadas,ProductividadSesion productividad) {
		this.fecha = fecha;
		this.duracion = horasEmpleadas;
		this.productividad = productividad;
	}
	
	/**
	 * Obtiene el identificador de la sesi�n.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Establece el identificador de la sesi�n.
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Obtiene la fecha y hora de realizaci�n de la sesi�n.
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * Establece la fecha y hora de realizaci�n de la sesi�n.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene el n�mero de horas empleadas 
	 * en la tarea durante la sesi�n.
	 */
	public double getDuracion() {
		return duracion;
	}
	
	/**
	 * Establece el n�mero de horas empleadas
	 * en la tarea durante la sesi�n.
	 */
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * Obtiene la productividad de la sesi�n.
	 */
	public ProductividadSesion getProductividad() {
		return productividad;
	}
	
	/**
	 * Establece la productividad de la sesi�n.
	 */
	public void setProductividad(ProductividadSesion productividad) {
		this.productividad = productividad;
	}
	

	/**
	 * Devuelve el tipo Tarea al que se ha asignado
	 * la sesi�n.
	 */
	public Tarea getTarea() {
		return tarea;
	}

	/**
	 * Establece el tipo Tarea al que se le asigna
	 * la sesi�n. 
	 */
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	
	/**
	 * Transcripci�n de la sesi�n.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(id);
		sb.append(" ");
		sb.append(fecha);
		sb.append(" ");
		sb.append(duracion);
		sb.append(" ");
		sb.append(productividad);
		sb.append(". Productividad real: ");
		sb.append(horasProductivas());
		
		return sb.toString();
	}
	
	/**
	 * Calcula un valor m�s cercano a la realidad de horasEmpleadas
	 * dependiendo de la productividad alcanzada.
	 * @return
	 */
	public double horasProductivas() {
		return FACTORES_PRODUCTIVIDAD[productividad.ordinal()] * duracion;
	}


}
