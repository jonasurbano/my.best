package domain.tareas;

import java.util.Date;

/**
 * Tipo TareaFutura.
 * @author Jon�s Urbano Romero.
 * @see Tarea
 */
public class TareaFutura {

	private String tarea;
	private Date fechaAnotacion;
	
	/**
	 * Constructor del tipo TareaFutura.
	 * @param tarea
	 * @param fechaAnotacion
	 */
	public TareaFutura(String tarea,Date fechaAnotacion) {
		this.fechaAnotacion = fechaAnotacion;
		this.tarea = tarea;
	}
	
	/**
	 * Obtiene el nombre de la tarea futura.
	 */
	public String getTarea() {
		return tarea;
	}
	
	/**
	 * Obtiene la fecha de anotaci�n de la tarea futura.
	 * @return
	 */
	public Date getFechaAnotacion() {
		return fechaAnotacion;
	}
}
