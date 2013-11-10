package domain.tareas;

import domain.enums.*;
import domain.periodicidad.PeriodicidadSemanal;
import domain.ponderaciones.Ponderacion;
import domain.sesiones.Sesion;
import domain.temas.Tema;
import java.awt.Color;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que alberga información y métodos para una tarea.
 * @author Jonás Urbano Romero
 * @see PeriodicidadSemanal
 * @See Tema
 * @see Sesion
 * @See Ponderacion
 */
@XmlRootElement(name="tarea")
public class Tarea implements Comparable<Tarea>, Serializable {

    public static final String[] INFO_TAREA = {"Tarea","Descripci�n","Fecha de inicio",
        "Fecha de fin","Duraci�n estimada","Horas por sesi�n","Prioridad","Periodicidad"};
	
    /**
     * Identificador de la tarea.
     * Especialmente �til para persistencia.
     */
    private long id;
	
    /**
     * Nombre de la tarea.
     */
    private String tarea;
    private Date fechaInicio;
    
    /**
     * Puede ser un valor nulo, esto es, no especificado.
     */
    private Date fechaFin;

    /**
     * Puede ser un valor nulo, esto es, no especificado.
     */
    private String descripcion;
    
    /**
     * Duraci�n estimada en horas para la realizaci�n de la tarea.
     * Un valor de 0 indica que no se ha especificado la duraci�n
     * y por lo tanto no se puede calcular el porcentaje realizado
     * ni el porcentaje restante.
     */
    private double duracionEstimada;
    
    /**
     * N�mero de horas estimadas en una sesi�n para la tarea.
     * Un valor de 0 indica que no se ha especificado el valor
     * y por lo tanto no se podr�a calcular el tiempo restante.
     */
    private double horasPorSesion;
    private boolean realizada;
    private PrioridadTarea prioridad;
    
    /**
     * Futura implementaci�n.
     */
    private Tema tema;
    
    /**
     * Futura implementaci�n.
     */
    private Color color;
    
    /**
     * Puede ser un valor nulo, esto es, no especificado.
     */    
    private PeriodicidadSemanal periodicidadSemanal;

    /**
     * Puede ser un valor nulo, esto es, no especificado.
     */    
    private Ponderacion ponderacion;
    
    @XmlElementWrapper(name="sesiones")
    @XmlElement(name="sesion")
    private List<Sesion> sesiones;
    
    /**
     * Constructor sin argumentos.
     * Necesario para persistencia.
     */
    public Tarea() {
    	sesiones = new ArrayList<Sesion>();
    }
    
    /**
     * Constructor minimal.
     * @param tarea
     * @param fechaInicio
     * @param fechaFin
     * @param prioridad
     */
	public Tarea(String tarea, Date fechaInicio, Date fechaFin,
			PrioridadTarea prioridad) {
		this();
		
		this.tarea = tarea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.prioridad = prioridad;
	}

	/**
	 * Constructor completo.
	 * @param tarea
	 * @param fechaInicio
	 * @param fechaFin
	 * @param descripcion
	 * @param duracionEstimada
	 * @param horasPorSesion
	 * @param prioridad
	 * @param periodicidadSemanal
	 */
	public Tarea(String tarea,Date fechaInicio,Date fechaFin,
            String descripcion,double duracionEstimada,double horasPorSesion,
            PrioridadTarea prioridad,PeriodicidadSemanal periodicidadSemanal) {
		
		this(tarea,fechaInicio,fechaFin,prioridad);
		
		this.descripcion = descripcion;
		this.duracionEstimada = duracionEstimada;
		this.horasPorSesion = horasPorSesion;
		this.periodicidadSemanal = periodicidadSemanal;
	}

        
        
        public Tarea(String tarea,Date fechaInicio,Date fechaFin,
            String descripcion,double duracionEstimada,double horasPorSesion,
            PrioridadTarea prioridad,PeriodicidadSemanal periodicidadSemanal,
            Tema tema) {
		
		this(tarea,fechaInicio,fechaFin,descripcion,duracionEstimada,
                        horasPorSesion,prioridad,periodicidadSemanal);
		this.tema = tema;
	}
        
	/**
	 * Obtener id del tipo Tarea.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Establece id del tipo Tarea.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtener nombre de la tarea.
	 */
	public String getTarea() {
            return tarea;
	}

	/**
	 * Establecer nombre de la tarea.
	 */
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	/**
	 * Obtener fecha de inicio.
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establecer fecha de inicio.
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Obtener fecha de fin.
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establecer fecha de fin.
	 * @return Comprobar si es null.
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtener descripci�n de la tarea.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establecer descripci�n de la tarea.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtener duraci�n estimada en horas.
	 */
	public double getDuracionEstimada() {
		return duracionEstimada;
	}

	/**
	 * Establecer duraci�n estimada en horas.
	 */
	public void setDuracionEstimada(double duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	/**
	 * Determina si la tarea ha sido realizada.
	 */
	public boolean isRealizada() {
		return realizada;
	}

	/**
	 * Establecer tarea como realizada.
	 */
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}

	/**
	 * Obtener la prioridad de la tarea.
	 */
	public PrioridadTarea getPrioridad() {
		return prioridad;
	}

	/**
	 * Establecer la prioridad de la tarea.
	 */
	public void setPrioridad(PrioridadTarea prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * Obtiene el n�mero estimado de horas por sesi�n.
	 */
	public double getHorasPorSesion() {
		return horasPorSesion;
	}

	/**
	 * Establece el n�mero estimado de horas por sesi�n.
	 */
	public void setHorasPorSesion(double horasPorSesion) {
		this.horasPorSesion = horasPorSesion;
	}
	
	/**
	 * Obtiene el objeto PeriodicidadSemanal.
	 * @return Comprobar si es null.
	 * @see PeriodicidadSemanal
	 */
	public PeriodicidadSemanal getPeriodicidadSemanal() {
		return periodicidadSemanal;
	}

	/**
	 * Establece el objeto PeriodicidadSemanal.
	 * @see PeriodicidadSemanal
	 */
	public void setPeriodicidadSemanal(PeriodicidadSemanal periodicidadSemanal) {
		this.periodicidadSemanal = periodicidadSemanal;
	}


	/**
	 * Obtiene una nueva lista con las sesiones de la tarea.
	 * @since 05/11/11
	 */
	public List<Sesion> getSesiones() {
		return new ArrayList<Sesion>(sesiones);
	}

	/**
	 * Establece las sesiones de la tarea
	 * S�lo para persistencia.
	 * <i>GestorTareas</i> incluye un m�todo para asignar sesi�n
	 * a una tarea <i>void asignarSesion(Tarea t,Sesion s)</i>
	 */
	private void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	/**
	 * Asigna la sesi�n a la tarea.
	 */
	public void asignarSesion(Sesion sesion) {
		if (sesion != null)	sesiones.add(sesion); 
	}
	
	/**
	 * Breve informaci�n sobre la tarea.
	 */
        @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(id);
		sb.append(" || ");
		sb.append(tarea);
		sb.append(" de prioridad ");
		sb.append(prioridad);
		sb.append(" || ");

		if (periodicidadSemanal != null) sb.append("periodica. ");
		else sb.append("no periodica. ");
		
		double porcentajeRealizado = porcentajeRealizado();
		if (porcentajeRealizado >= 0.0) {
			sb.append(porcentajeRealizado);
			sb.append("% realizada.");
		}
		
		return sb.toString();
	}
	
	/**
	 * Construye un array de String 
	 * con propiedades de la tarea.
	 */
	public String[] toStringArray() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		String[] campos = new String[8];
		campos[0] = tarea;
		campos[1] = descripcion != null ? descripcion : "Sin descripci�n";
		campos[2] = sdf.format(fechaInicio);
		campos[3] = fechaFin != null ? sdf.format(fechaFin) : "Sin fecha de fin";
		campos[4] = Double.toString(duracionEstimada);
		campos[5] = Double.toString(horasPorSesion);
		
		campos[6] = prioridad.toString();
		campos[7] = periodicidadSemanal != null ? periodicidadSemanal.toString() : "No";
		
		return campos;
	}
	
	/**
	 * Informaci�n sobre las sesiones asignadas a la tarea.
	 * @return Texto formateado.
	 */
	public String sesionesToString() {
		Iterator<Sesion> it = sesiones.iterator();
		StringBuilder sb = new StringBuilder();
		
		while (it.hasNext()) {
			sb.append("-- ");
			sb.append(it.next());
			sb.append("\n");
		}
		
		return sb.toString();
	}

    /**
     * Comprueba si la tarea es peri�dica.
     * Esto ocurre si tiene un objeto <i>PeriodicidadSemanal</i> asignado.
     */
    public boolean esPeriodicaSemanal() {
    	return periodicidadSemanal != null;
    }
	
	/**
	 * Devuelve el objeto Ponderacion si est� definido.
	 */
	public Ponderacion getPonderacion() {
		return ponderacion;
	}
	
	/**
	 * NO �til, por el momento.
	 */
	public int compareTo(Tarea t) {
		return ponderacion.compareTo(t.ponderacion);
	}
	
	// ---- FIN GETTERS Y SETTERS
	
	
	
	// ---- SESIONES
	
	/**
	 * Obtiene la fecha de la �ltima sesi�n realizada
	 * de la tarea.
	 * @return Date o null si no hay sesiones para la tarea.
	 */
	public Date fechaUltimaSesion() {
            if (sesiones.isEmpty()) return null;
            if (sesiones.size() == 1)
                return sesiones.iterator().next().getFecha();
		
            Iterator<Sesion> it = sesiones.iterator();
            Sesion sesion = it.next();
		
            Sesion sesionAux;
            while (it.hasNext()) {
                sesionAux = it.next();
                if (sesionAux.getFecha().after(sesion.getFecha()))
                    sesion = sesionAux;		
		}
		
            return sesion.getFecha(); 
	}

	/**
	 * Calcula el n�mero de d�as desde la �ltima sesi�n
	 * que se realiz� de la tarea.
	 * @return dias o -1 si no hay sesiones para la tarea.
	 */
	public int diasDesdeUltimaSesion() {
		Date fechaSesion = fechaUltimaSesion();
		if (fechaSesion == null) return -1; 
		return GestorTareas.diasEntreFechas(new Date(),fechaSesion); 
	}

	
    /**
     * Calcula las horas productivas invertidas en la tarea.
     * @return horas.
     */
    public double horasProductivasEmpleadas() {
    	double horas = 0.0;
    	
    	Iterator<Sesion> it = sesiones.iterator();
    	while (it.hasNext()) horas += it.next().horasProductivas();
    	
    	return horas;
    }
    
    /**
     * Número de horas productivas invertidas
     * en la tarea en los últimos siete días.
     * Útil para control de la productividad.
     * @since 29/07/12
     */
    public double horasProductivasUltimosSieteDias() {
    	double horas = 0.0;
    	Date hoy = new Date();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -7);
        Date hace7Dias = c.getTime();
        
    	Date fechaSesion;
    	for (Sesion s : sesiones) {
            fechaSesion = s.getFecha();
            if (fechaSesion.after(hoy)) continue;
            if (fechaSesion.after(hace7Dias))
                horas += s.horasProductivas();
    	}
    	return horas;
    }
    
    /**
     * N�mero de horas totales invertidas en la tarea.
     * �til para control de la productividad.
     */
    public double horasEmpleadas() {
    	double horas = 0.0;
    	for (Sesion s : sesiones)
            horas += s.getDuracion();
    	return horas;
    }
    
    /**
     * Número de horas invertidas en la tarea 
     * en los últimos siete días.
     * @since 29/09/12
     */
    public double horasUltimosSieteDias() {
    	double horas = 0.0;
  	Date hoy = new Date();
        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -7);
        Date hace7Dias = c.getTime();
        
    	Date fechaSesion;
    	for (Sesion s : sesiones) {
            fechaSesion = s.getFecha();
            if (fechaSesion.after(hoy)) continue;
            if (fechaSesion.after(hace7Dias))
                horas += s.getDuracion();
    	}
    	return horas;
    }

    /**
     * Comprueba si se ha realizado alguna sesi�n de la tarea.
     */
    public boolean seHanRealizadoSesiones() {
    	return !sesiones.isEmpty();
    }
    
    /**
     * Calcula el porcentaje realizado de la tarea si es posible.
     * Es necesario que duracionEstimada haya sido especificado.
     * @return -1.0 en caso de no haberse podido calcular o si
     * se ha sobrepasado duracionEstimada.
     * -1.0 debe interpretarse como valor no significativo.
     */
    public double porcentajeRealizado() {
    	if (duracionEstimada == 0.0) return -1.0;
    	double porcentajeRealizado = horasProductivasEmpleadas() / duracionEstimada;
    	if (porcentajeRealizado >= 1) return -1.0;
    	return Math.round(porcentajeRealizado*100.0)/100.0;
    }
    
    /**
     * Número de horas invertidas en la tarea 
     * en el d�a <i>fecha</i>.
     * Útil para control de la eficacia.
     * @since 30/09/12
     */
    public double horasEnDia(Date fecha) {
    	double horas = 0.0;
    	for (Sesion s : sesiones)
            if (GestorTareas.mismoDia(s.getFecha(),fecha))
                horas += s.getDuracion();
    	return horas;
    }
    
    /**
     * Calcula el n�mero de minutos entre la hora de comienzo de la tarea
     * y la hora de comienzo de la sesi�n en el dia <i>fecha</i>.
     * Es posible obtener un valor negativo si la sesi�n comenz� antes.
     * �til para control de la disciplina.
     * @return -1 si no se ha encontrado sesi�n en el d�a <i>fecha</i>.
     */
    public int minutosDiferenciaHoraInicio(Date fecha) {
    	final int MINUTOS_POR_HORA = 60;
    	for (Sesion s : sesiones)
    		if (GestorTareas.mismoDia(s.getFecha(),fecha)){
				return (s.getFecha().getHours() - fechaInicio.getHours()) * MINUTOS_POR_HORA 
					+ (s.getFecha().getMinutes() - fechaInicio.getMinutes());
    		}
    	return -1;
    }
    
	
	// ---- D�AS
	
	/**
	 * Calcula el n�mero de d�as transcurridos desde la 
	 * fecha de inicio de la tarea.
	 * @return dias o -1 si se ha comparado con una fecha futura.
	 */
    public int diasTranscurridosDesdeInicio() {
    	if (fechaInicio.after(new Date())) return -1;
    	return GestorTareas.diasEntreFechas(new Date(),fechaInicio);
    }
    
    
    // ---- TAREA FIJA U OPCIONAL
    
    /**
     * Determina si es necesario que la tarea se realice en la fecha <i>fecha</i>
     * con las siguientes condiciones:
     * 1�. La tarea no se haya realizado a�n.
     * 2�. La tarea tiene fecha final y �sta es <i>fecha</i>.
     * 3�. La tarea es peri�dica y se realiza en <i>fecha</i>.
     * 4�. La tarea peri�dica a�n no ha cumplido su fecha final.
     * @return Falso en cualquier otro caso.
     */
    public boolean seRealizaEnFecha(Date fecha) {
    	if (realizada) return false;    	
    	if (fechaFin != null 
			&& GestorTareas.mismoDia(fechaFin,fecha)) return true;
    	if (periodicidadSemanal == null) return false;
    	if (!periodicidadSemanal.seRealizaEnFecha(fecha)) return false;
    	
    	if (fechaFin == null) return true;
        else if (fechaFin.after(fecha)) 
    		return true;
    	
    	return false;
    }
    
    /**
     * Determina si se puede realizar la tarean en la fecha <i>fecha</i>.
     * con las siguientes condiciones:
     * 1�. La tarea a�n no se ha realizado.
     * 2�. La tarea no comienza m�s tarde de <i>fecha</i>.
     * 3�. La tarea no es peri�dica. En caso contrario, ser�a fija.
     * 4�. La tarea no tiene fecha final.
     * 5�. La tarea tiene fecha final pero es posterior a <i>fecha</>.
     */
    public boolean puedeRealizarseEnFecha(Date fecha) {
    	if (realizada) return false;
    	if (fechaInicio.after(fecha)) return false;
    	
    	// Las peri�dicas no son opcionales, son fijas.
    	if (periodicidadSemanal != null) return false;
    	
    	if (fechaFin != null) {
    		if (fechaFin.after(fecha) && !GestorTareas.mismoDia(fechaFin,fecha)) return true;
    		else return false;
    	} else return true;
    }
    
    
    
    // ---- PONDERACIONES
    
	/**
	 * Pondera los d�as que faltan para que acabe la tarea con
	 * los d�as que faltan para que acabe la �ltima tarea.
	 * Un  valor m�s cercano a 0.0 indica que la tarea es prioritaria.
	 * @param tarea es necesario que especifique la fecha final.
	 * @return Un valor entre 0.0 y 1.0.
	 * Devuelve 0.0 si la tarea no tiene especificada fecha final
	 * o si no hay fecha de la �ltima tarea. Este caso no deber�a
	 * ocurrir nunca.
	 * Devuelve 1.0 si la fecha final de la tarea es anterior o
	 * igual a la fecha actual.
	 */
	public double ponderarFechaFinal(Date fecha,Date maxFecha) {
		if (maxFecha == null || fechaFin == null) return 0.0;
		if (fechaFin.compareTo(fecha) <= 0) return 1.0;
		
		double proporcion = GestorTareas.diasEntreFechas(fechaFin,maxFecha);
		double unidad = GestorTareas.diasEntreFechas(fecha,maxFecha);

		return Math.round((proporcion/unidad)*100.0)/100.0;
	}
	
	/**
	 * Pondera el porcentaje restante de la tarea para
	 * obtener un valor normalizado.
	 */
	public double ponderarPorcentajeRestante() {
		double porcentaje = porcentajeRealizado();
		return porcentaje == -1.0 ? 1.0 : Math.round((1.0-porcentaje)*100.0)/100.0;
	}

	/**
	 * Pondera la prioridad para obtener un valor entre 0.0 y 1.0.
	 */
	public double ponderarPrioridad() {
		if (prioridad == PrioridadTarea.NINGUNA) return 0.0;
		if (prioridad == PrioridadTarea.BAJA) return 0.25;
		if (prioridad == PrioridadTarea.MEDIA) return 0.5;
		if (prioridad == PrioridadTarea.ALTA) return 0.75;
		return 1.0;
	}
	
	/**
	 * Obtiene un valor normalizado de la raz�n
	 * entre el n�mero de d�as desde la �ltima sesi�n 
	 * y el m�ximo n�mero de d�as de la �ltima sesi�n. 
	 * 0.0 debe interpretarse como valor no significativo.
	 */
	public double ponderarDiasUltimaSesion(int maxDias) {
		if (maxDias <= 0) return 0.0;
		double dias = diasDesdeUltimaSesion();
		if (dias == -1) return 1.0;
		double prop = dias / maxDias;
		return Math.round(prop*100.0)/100.0;
	}
	
	/**
	 * Crea un objeto <i>Ponderacion</i> y le asigna 
	 * los valoreas correspondientes.
	 * @param fecha, fecha del d�a deseado a ponderar. En general new Date().
	 * @param maxFechaFin, fecha de la tarea que finaliza m�s tarde.
	 * @param maxDiasUltimaSesion, entre todas las tareas, el valor m�ximo
	 * de los d�as desde que ocurri� la �ltima sesi�n de la tarea.
	 */
	public Ponderacion ponderar(Date fecha,Date maxFechaFin,int maxDiasUltimaSesion) {
            ponderacion = new Ponderacion();
		
            ponderacion.setFechaFin(ponderarFechaFinal(fecha,maxFechaFin));
            ponderacion.setPrioridad(ponderarPrioridad());
            ponderacion.setPorcentajeRestante(ponderarPorcentajeRestante());
            ponderacion.setDiasDesdeUltimaSesion(ponderarDiasUltimaSesion(maxDiasUltimaSesion));
		
            return ponderacion;
	}

    /**
     * Crea un objeto ControlProductividad para comparar las
     * horas empleadas con las horas productivas.
     * @since 29/09/12
     */
    public ControlProductividad productividadUltimos7Dias() {
        return new ControlProductividad(this,horasUltimosSieteDias(),
            horasProductivasUltimosSieteDias());
    }
    
        
    /**
     * Devuelve una lista con la fecha de las sesiones.
     * @param fecha
     * @param numDias 
     * @return null si la fecha o la tarea es null o el número de días es negativo.
     */
    public Collection<Date> fechasSesiones(Date fecha,int numDias) {
        if (fecha == null) return null;
        if (numDias < 0) return null;
        
        Collection<Date> lista = new ArrayList<Date>();
        
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DATE, -numDias);
        
        for (int i = 1; i <= numDias; i++) {
            c.add(Calendar.DATE, 1);

            for (Sesion s : sesiones) {
                if (GestorTareas.mismoDia(s.getFecha(), c.getTime())) {
                    lista.add(s.getFecha());
                    break;
                }
            }
        }
        
        return lista;
    }
        
}
