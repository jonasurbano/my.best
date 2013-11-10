package domain.periodicidad;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Tipo PeriodicidadSemanal.
 * Este tipo permite conocer qu� d�as a la
 * semana se repite una tarea.
 * @author Jon�s Urbano Romero.
 * @see Tarea.
 */
@XmlRootElement(name="periodicidad")
@XmlType(propOrder = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo", "id" })
public class PeriodicidadSemanal implements Serializable {

	private long id;
	private boolean lunes;
	private boolean martes;
	private boolean miercoles;
	private boolean jueves;
	private boolean viernes;
	private boolean sabado;
	private boolean domingo;
	
	/**
	 * Constructor vac�o.
	 * Necesario para persistencia.
	 */
	private PeriodicidadSemanal() {}
	
	/**
	 * Constructor completo.
	 * @param lunes
	 * @param martes
	 * @param miercoles
	 * @param jueves
	 * @param viernes
	 * @param sabado
	 * @param domingo
	 */
	public PeriodicidadSemanal(boolean lunes, boolean martes,
			boolean miercoles, boolean jueves, boolean viernes, boolean sabado,
			boolean domingo) {
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.sabado = sabado;
		this.domingo = domingo;
	}	
	
	public boolean isLunes() {
		return lunes;
	}
	public void setLunes(boolean lunes) {
		this.lunes = lunes;
	}
	public boolean isMartes() {
		return martes;
	}
	public void setMartes(boolean martes) {
		this.martes = martes;
	}
	public boolean isMiercoles() {
		return miercoles;
	}
	public void setMiercoles(boolean miercoles) {
		this.miercoles = miercoles;
	}
	public boolean isJueves() {
		return jueves;
	}
	public void setJueves(boolean jueves) {
		this.jueves = jueves;
	}
	public boolean isViernes() {
		return viernes;
	}
	public void setViernes(boolean viernes) {
		this.viernes = viernes;
	}
	public boolean isSabado() {
		return sabado;
	}
	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}
	public boolean isDomingo() {
		return domingo;
	}
	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}
	
	/**
	 * @return the idPeriodicidadSemanal
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param idPeriodicidadSemanal the idPeriodicidadSemanal to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Comprueba si la tarea peri�dica se realiza 
	 * en el d�a de la semana <i>fecha</i>.
	 * @return false en caso de que <i>fecha</i> sea nula.
	 */
	public boolean seRealizaEnFecha(Date fecha) {
		if (fecha == null) return false;
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
				
		if (lunes && diaSemana == Calendar.MONDAY) return true;
		if (martes && diaSemana == Calendar.TUESDAY) return true;
		if (miercoles && diaSemana == Calendar.WEDNESDAY) return true;
		if (jueves && diaSemana == Calendar.THURSDAY) return true;
		if (viernes && diaSemana == Calendar.FRIDAY) return true;
		if (sabado && diaSemana == Calendar.SATURDAY) return true;
		if (domingo && diaSemana == Calendar.SUNDAY) return true;
		return false;
	}
	
	/**
	 * Transcripci�n del tipo PeriodicidadSemanal.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if (lunes) sb.append("L");
		if (martes) sb.append("M");
		if (miercoles) sb.append("M");
		if (jueves) sb.append("J");
		if (viernes) sb.append("V");
		if (sabado) sb.append("S");
		if (domingo) sb.append("D");
		
		return sb.toString();
	}
}	
