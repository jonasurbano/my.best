package domain.ponderaciones;

import domain.tareas.Tarea;

/**
 * Tipo Ponderacion.
 * Esta clase contiene los par�emtros necesarios
 * para comparar y ordenar tareas.
 * Todos los par�metros ponderables son doubles entre 0.0 y 1.0.
 * @author Jon�s Urbano Romero.
 * @see Tarea
 */
public class Ponderacion implements Comparable<Ponderacion> {

	private Tarea tarea;
	
	/**
	 * Criterio seg�n la fecha final de las tareas.
	 * Un valor cercano a 0 indica que la fecha de fin est� lejos
	 * respecto a la fecha de fin de las dem�s tareas.
	 * En cambio, un valor cercano a 1.0 indica que la fecha de fin
	 * est� cercana y la tareas es prioritaria respecto a las
	 * dem�s tareas.
	 */
	private double fechaFin;
	
	/**
	 * Criterio personal del usuario.
	 */
	private double prioridad;
	
	/**
	 * Criterio personal del usuario ya que
	 * duraci�n estimada de la tarea es un par�metro
	 * subjetivo.
	 */
	private double porcentajeRestante;
	
	/**
	 * Criterio seg�n la �ltima fecha en que se realiz� una tarea.
	 * Un valor cercano a 0.0 indica que la tarea se realiz�
	 * hace poco respecto a las sesiones de las dem�s tareas.
	 * Un par�metro cercano a 1.0 indica que la �ltima sesi�n de esta
	 * tarea se realiz� antes que las �ltima sesi�n de las dem�s tareas.
	 */
	private double diasDesdeUltimaSesion;
	
	/**
	 * Criterio personal del usuario.
	 * Prioriza las tareas con mayor duraci�n estimada.
	 */
	private double duracionEstimada;
	
	/**
	 * Constructor vac�o.
	 * Programadores prefieren crear primero el objeto y luego
	 * establecer sus propiedades a llamar a constructores
	 * con dos l�neas de par�metros de entrada.
	 */
	public Ponderacion() {}
	
	/**
	 * Constructor completo.
	 * @param fechaFin
	 * @param prioridad
	 * @param porcentajeRestante
	 * @param diasDesdeUltimaSesion
	 * @param duracionEstimada
	 */
	public Ponderacion(double fechaFin, double prioridad,
			double porcentajeRestante, double diasDesdeUltimaSesion,
			double duracionEstimada) {

		this.fechaFin = fechaFin;
		this.prioridad = prioridad;
		this.porcentajeRestante = porcentajeRestante;
		this.diasDesdeUltimaSesion = diasDesdeUltimaSesion;
		this.duracionEstimada = duracionEstimada;	
	}
	
	/**
	 * Obtiene ponderaci�n seg�n el criterio 
	 * de la �ltima fecha de fin.
	 */
	public double getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Establece la ponderaci�n seg�n el criterio
	 * de la �ltima fecha de fin.
	*/
	public void setFechaFin(double fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Obtiene la ponderaci�n de la prioridad.
	 */
	public double getPrioridad() {
		return prioridad;
	}
	
	/**
	 * Establece la ponderaci�n de la prioridad.
	*/
	public void setPrioridad(double prioridad) {
		this.prioridad = prioridad;
	}
	
	/**
	 * Obtiene la ponderaci�n del procentaje restante.
	 */
	public double getPorcentajeRestante() {
		return porcentajeRestante;
	}
	
	/**
	 * Establece la ponderaci�n del porcentaje restante.
	 */
	public void setPorcentajeRestante(double porcentajeRestante) {
		this.porcentajeRestante = porcentajeRestante;
	}
	
	/**
	 * Obtiene la ponderaci�n seg�n el criterio
	 * de los d�as desde que se realizo la �ltima sesi�n.
	 */
	public double getDiasDesdeUltimaSesion() {
		return diasDesdeUltimaSesion;
	}
	
	/**
	 * Establece la ponderaci�n seg�n el criterio
	 * de los d�as desde que se realiz� la �ltima sesi�n.
	 */
	public void setDiasDesdeUltimaSesion(double diasDesdeUltimaSesion) {
		this.diasDesdeUltimaSesion = diasDesdeUltimaSesion;
	}
	
	/**
	 * Obtiene la ponderaci�n seg�n el criterio
	 * de la duraci�n estimada.
	 */
	public double getDuracionEstimada() {
		return duracionEstimada;
	}
	
	/**
	 * Establece la ponderaci�n seg�n el criterio
	 * de la duraci�n estimada.
	 */
	public void setDuracionEstimada(double duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}
	
	/**
	 * Obtiene la tarea a la que pertenece esta ponderaci�n.
	 */
	public Tarea getTarea() {
		return tarea;
	}
	
	/**
	 * Establece la tarea a la que pertenece esta ponderaci�n.
	 */
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
	/**
	 * Ponderaci�n obtenida al sumar todas las ponderaciones.
	 */
	public double sumaCompleta() {
            return diasDesdeUltimaSesion + duracionEstimada +
                fechaFin + porcentajeRestante + prioridad;
	}
	
	/**
	 * Comparaci�n entre dos ponderaciones.
	 */
	private double compareToDouble(Ponderacion p) {
		return sumaCompleta() - p.sumaCompleta();
	}
	
	/**
	 * Comparaci�n entre dos ponderaciones.
	 * Magnifica la diferencia obtenida por <i>compareToDouble</i>.
	 * en un orden de 2.
	 */
	public int compareTo(Ponderacion p) {
		return new Double(compareToDouble(p)*100.0).intValue();
	}
	
	/**
	 * Transcripci�n de la ponderaci�n.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(tarea.getTarea());
		sb.append(". FF: ");
		sb.append(fechaFin);
		sb.append(". Pr: ");
		sb.append(prioridad);
		sb.append(" PR: ");
		sb.append(porcentajeRestante);
		sb.append(" DUS: ");
		sb.append(diasDesdeUltimaSesion);
		
		return sb.toString();
	}
}
