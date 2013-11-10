package domain.tareas;

import java.util.*;

import domain.comparacion.*;
import domain.ponderaciones.Ponderacion;
import domain.sesiones.Sesion;
import data.PersistenciaTareas;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Gestión de las tareas.
 * @author Jonás Urbano Romero.
 * @see Tarea
 */
public class GestorTareas {
    protected final Log logger = LogFactory.getLog(getClass());
    
    public static final long MILLIS_POR_HORA = 60 * 60 * 1000L;

    private static enum CRITERIO {FECHA_FIN,PORCENTAJE_RESTANTE,PRIORIDAD,
        DIAS_ULTIMA_SESION,DURACION_ESTIMADA,SUMA_COMPLETA};

    private List<Tarea> tareas;
    private List<TareaFutura> tareasFuturas;
    private List<Ponderacion> ponderaciones;

    private PersistenciaTareas persistencia;

	
	/**
	 * Constructor vacío.
	 */
	public GestorTareas() {
            tareas = new ArrayList<Tarea>();
            tareasFuturas = new ArrayList<TareaFutura>();
            ponderaciones = new ArrayList<Ponderacion>();
	}
	
        /**
         * Añade una tarea a la lista de tareas.
         * Creado el método necesario para los tests.
         * @since 29/09/12
         * 
         */
        public void nuevaTarea(Tarea tarea) {
            if (tarea == null) return;
            tareas.add(tarea);
        }
        
	/**
	 * Añade una tarea y la persiste.
	 * @since 05/11/11.
	 * Asigna id a la tarea, la añade a la lista.
	 */
	public void anadirTarea(Tarea tarea) {
            if (tarea == null) return;
            tareas.add(tarea);
            almacenarTarea(tarea);
	}

	/**
	 * Asiguna la sesión a la tarea.
	 */
	public void asignarSesion(Tarea tarea,Sesion sesion) {
		if (tarea == null || sesion == null) return;
		tarea.asignarSesion(sesion);
		sesion.setTarea(tarea);
		actualizarTarea(tarea);
	}
	
	/**
	 * Añade una tarea futura.
	 */
	public void anadirTarea(TareaFutura tarea) {
		if (tarea == null) return;
		tareasFuturas.add(tarea);
	}
	
	/**
	 * Tareas que se tienen que realizar en la fecha <i>fecha</i>.
	 * Estas tareas están ordenadas.
	 * @see ComparacionTareasFijas
	 */
	public Collection<Tarea> tareasFijas(Date fecha) {
		List<Tarea> tareasFijas = new ArrayList<Tarea>();
		
		for (Tarea tarea : tareas) {
			if (tarea.seRealizaEnFecha(fecha))
				tareasFijas.add(tarea);
		}
		
		Collections.sort(tareasFijas,new ComparacionTareasFijas());
		return tareasFijas;
	}
	
	/**
	 * Tareas que se pueden realizar en la fecha <i>fecha</i>.
	 * Estas tareas no est�n ordenadas bajo ning�n criterio.
	 */
	public Collection<Tarea> tareasPosibles(Date fecha) {
		List<Tarea> tareasPosibles = new ArrayList<Tarea>();
		
		for (Tarea tarea : tareas) {
			if (tarea.puedeRealizarseEnFecha(fecha))
				tareasPosibles.add(tarea);
		}
		
		return tareasPosibles;
	}
	

    /***************************************************************************
     * M�TODOS AUXILIARES
     ***************************************************************************/
	
	/**
	 * Devuelve la fecha de la tarea que finaliza m�s tarde.
	 * @return null si ninguna tarea tiene establecido fecha
	 * final.
	 */
	public Date maxFechaFinal() {
		Date maxFecha = new Date(1);
		Date fecha;
		
		for (Tarea tarea : tareas) {
			fecha = tarea.getFechaFin();
			if (fecha != null && fecha.after(maxFecha))
				maxFecha = fecha;
		}

		return maxFecha.compareTo(new Date(1)) != 0 ? maxFecha : null;
	}
	
	/**
	 * Dada la fecha de la �ltima sesi�n de cada tarea;
	 * devuelve la fecha menos reciente.
	 * @return 0 si no hay sesiones o 
	 * si la �ltima de cada tarea se ha realizado hoy.
	 */
	public int maxDiasDesdeUltimaSesion() {
		int maxDias = 0;
		
		int diasDesdeUltimaSesion;
		for (Tarea tarea : tareas) {
			diasDesdeUltimaSesion = tarea.diasDesdeUltimaSesion();
			if (diasDesdeUltimaSesion > maxDias) maxDias = diasDesdeUltimaSesion;
		}
		return maxDias;
	}
	
	/**
     * Calcula el n�mero de d�as entre dos fechas.
     * @return -1 en caso de que alguno de los objetos Date sea null.
     */
    public static int diasEntreFechas(Date fecha1,Date fecha2) {
    	if (fecha1 == null || fecha2 == null) return -1;
    	if (fecha2.after(fecha1)) 
        	return (int)((fecha2.getTime() - fecha1.getTime() 
    			+ GestorTareas.MILLIS_POR_HORA) / (GestorTareas.MILLIS_POR_HORA * 24));    	

		return (int)((fecha1.getTime() - fecha2.getTime() 
			+ GestorTareas.MILLIS_POR_HORA) / (GestorTareas.MILLIS_POR_HORA * 24));    	
    }
    
    /**
     * Comprueba si dos fechas se encunetran en el mismo día.
     * @return null si alguna de las fechas es null.
     * @since 30/09/12
     */
    public static boolean mismoDia(Date fecha1, Date fecha2) {
    	if (fecha1 == null || fecha2 == null) return false;
    	
    	Calendar calendario1 = Calendar.getInstance();
    	calendario1.setTime(fecha1);
        
    	Calendar calendario2 = Calendar.getInstance();
    	calendario2.setTime(fecha2);
    	
    	return calendario1.get(Calendar.DAY_OF_MONTH) == 
            calendario2.get(Calendar.DAY_OF_MONTH)
            && calendario1.get(Calendar.MONTH) == calendario2.get(Calendar.MONTH)
            && calendario1.get(Calendar.YEAR) == calendario2.get(Calendar.YEAR);
    }
    
    /**
     * Pondera todas las tareas.
     * @param fecha del d�a que se quiera obtener la ponderaci�n
     * En general, <i>fecha</i> ser� new Date().
     * Elimina las ponderaciones anteriores.
     */
    public void ponderar(Date fecha) {
        logger.info("Método ponderar");
        
        Date maxFechaFin = maxFechaFinal();
    	int maxDiasUltimaSesion = maxDiasDesdeUltimaSesion();
    	
        logger.info("Días desde última sesión:" + maxDiasDesdeUltimaSesion());
        
        ponderaciones.clear();
    	
    	Ponderacion p;
    	for (Tarea tarea : tareas) {
            p = tarea.ponderar(fecha,maxFechaFin,maxDiasUltimaSesion);
            p.setTarea(tarea);
            ponderaciones.add(p);
            
            logger.info("La ponderacion para la tarea " + tarea + " es " + p.sumaCompleta());
    	}
    }
    
    /**
     * Devuelve lista de las ponderaciones de las
     * tareas que recibe como argumento.
     * En realidad, pondera todas las tareas 
     * si no han sido ponderadas.
     */
    private List<Ponderacion> ponderar(Collection<Tarea> coleccionTareas,Date fecha) {
    	ponderar(fecha);
    	
    	List<Ponderacion> p = new ArrayList<Ponderacion>();

        logger.info("Crear la lista de las ponderaciones del subconj. de tareas");
        
    	for (Tarea tarea : coleccionTareas) {
            if (tarea.isRealizada()) continue;
            p.add(tarea.getPonderacion());
        }
    	return p;
    }
 
    
    /***************************************************************************
     * ORDENACI�N TAREAS OPCIONALES
     ***************************************************************************/

    /**
     * Ordnea las tareas seg�n el criterio de la fecha fin.
     */
    public LinkedList<Tarea> ordenarFechaFin(Collection<Tarea> tareas,Date fecha) {
    	return ordenar(tareas,fecha,CRITERIO.FECHA_FIN);
    }
    
    /**
     * Ordena las tareas seg�n el criterio del porcentaje restante.
    */
    public LinkedList<Tarea> ordenarPorcentajeRestante(Collection<Tarea> tareas,Date fecha) {
    	return ordenar(tareas,fecha,CRITERIO.PORCENTAJE_RESTANTE);
    }

    /**
     * Ordena las tareas seg�n la prioridad. 
    */
    public LinkedList<Tarea> ordenarPrioridad(Collection<Tarea> tareas,Date fecha) {
    	return ordenar(tareas,fecha,CRITERIO.PRIORIDAD);
    }

    /**
     * Ordena las tareas seg�n la fecha de la �tlima sesi�n. 
    */
    public LinkedList<Tarea> ordenarDiasUltimaSesion(Collection<Tarea> tareas,Date fecha) {
    	return ordenar(tareas,fecha,CRITERIO.DIAS_ULTIMA_SESION);
    }

    /**
     * Ordena las tareas seg�n la duraci�n estimada. 
     */
    public LinkedList<Tarea> ordenarDuracionEstimada(Collection<Tarea> tareas,Date fecha) {
    	return ordenar(tareas,fecha,CRITERIO.DURACION_ESTIMADA);
    }
    
    /**
     * Ordena las tareas seg�n la suma de todos los criterios.
     */
    public Collection<Tarea> ordenarSumaCompleta(Collection<Tarea> tareas,Date fecha) {
    
        logger.info("Núm. de ponderaciones:" + ponderaciones.size());
        for (Ponderacion p : ponderaciones)
            if (p == null) logger.info("Ponderación nula");
        
        logger.info("Se va a ponderar....");
        
        List<Ponderacion> ponderaciones = ponderar(tareas,fecha);
        
        logger.info("Ponderado.");

        logger.info("Núm. de ponderaciones:" + ponderaciones.size());
        for (Ponderacion p : ponderaciones)
            if (p == null) logger.info("Ponderación nula");
       
        Collections.sort(ponderaciones,Collections.reverseOrder());
    	List<Tarea> tareasOrdenadas = new LinkedList<Tarea>();
    	for (Ponderacion p : ponderaciones) 
            tareasOrdenadas.add(p.getTarea());
    	
    	return Collections.unmodifiableList(tareasOrdenadas);
    }	    
    
    /**
     * Ordena las tareas recibiendo el criterio por par�metro.
     */
    private LinkedList<Tarea> ordenar(  Collection<Tarea> tareas,Date fecha,CRITERIO orden) {  	
    	List<Ponderacion> ponderaciones = ponderar(tareas,fecha);
    	
    	Comparator<Ponderacion> comparador = null;
    	switch (orden) {
	    	case FECHA_FIN: comparador = new ComparacionFechaFin(); break;
	    	case PORCENTAJE_RESTANTE: comparador = new ComparacionPorcentajeRestante(); break;
	    	case PRIORIDAD:	comparador = new ComparacionPrioridad(); break;
	    	case DIAS_ULTIMA_SESION: comparador = new ComparacionDiasDesdeUltimaSesion(); break;
	    	case DURACION_ESTIMADA: comparador = new ComparacionDuracionEstimada(); break;
    	}
    	
    	Collections.sort(ponderaciones,comparador);
    	
    	LinkedList<Tarea> tareasOrdenadas = new LinkedList<Tarea>();
    	for (Ponderacion p : ponderaciones)
    		tareasOrdenadas.add(p.getTarea());
    	
    	return tareasOrdenadas;
    
    }
    
    /**
     * Devuelve una colección de taeras ordenadas
     * según la suma completa en la fecha actual.
     * @since 09/01/12
     * @return 
     */
    public Collection<Tarea> coleccionTareasOrdenadas() {
        return ordenarSumaCompleta(tareas,new Date());
    }

    /**
     * Devuelve la lista de los nombres de las tareas sin realizar.
     * �til para elegir la tarea a la que se ha dedicado una sesi�n
     * en el entorno gr�fico.
     */
    public String[] tareasToStringArray() {  	
    	String[] nombres = new String[tareas.size()];
    	int i = 0;
    	for (Tarea t : tareas) nombres[i++] = t.getTarea();
    	return nombres;
    }
    
    /**
     * N�mero de horas por sesi�n estimadas para una tarea.
   	 * �til al elegir la tarea a la que se ha realizado una sesi�n
   	 * en el entorno gr�fico.
     */
    public double horasPorSesion(String tarea) {

    	for (Tarea t : tareas)
    		if (t.getTarea().compareTo(tarea) == 0)
    			return t.getHorasPorSesion();
    			
    	return 0.0;
    }
    
    public Tarea getTareaPorNombre(String nombreTarea) {
            for (Tarea t : tareas)
                    if (t.getTarea().compareTo(nombreTarea) == 0) return t;
            return null;
    }

    public Tarea getTareaPorId(long idTarea) {
            for (Tarea t : tareas)
                    if (t.getId() == idTarea) return t;
            return null;
    }
    
    public String obtenerInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tareas: " + tareas.size());
        return sb.toString();
    }

    /**
     * Devuelve una colección con las tareas que aún no se han
     * realizado.
     * @version 23/09/12
     * @return Collection<Tarea> de 0 o más elementos.
     */
    public Collection<Tarea> tareasActivas() {
        List<Tarea> tareasActivas = new ArrayList<Tarea>();
        
        for (Tarea t : tareas)
            if (!t.isRealizada()) tareasActivas.add(t);
        
        return tareasActivas;
    }
    
        
    /*******************************************************************
     * CONTROL DE LA PERSISTENCIA
    /*******************************************************************/

    /**
     * Establece la propiedad hibernateTaraes.
     * Usado por Spring en la inyecciín de dependencias
     * de applicationContext.xml.
     * @param hibernateTareas 
     */
    public void setPersistencia(PersistenciaTareas persistencia) {
    	this.persistencia = persistencia;
    }
    
    public boolean persistenciaTareasIsSet() {
        return persistencia != null;
    }
    
    public void almacenarTarea(Tarea tarea) {        
        persistencia.almacenarTarea(tarea);
    }
    
    public void actualizarTarea(Tarea tarea) {
    	persistencia.actualizarTarea(tarea);
    }
    
    /**
     * @since 05/11/11
     * Para uso al final del programa. 
     */
    public void almacenarTareas() {
    	persistencia.actualizarTareas(tareas);
    }
    
    /**
     * Carga las tareas desde el repositorio.
     * Sólo si no se han cargado anteriormente.
     * @version 27/09/12
     */
    public void cargarTareas() {
    	if (persistencia == null) return;
        if (!tareas.isEmpty()) return;
        
        for (Tarea t : persistencia.cargarTareas()) 
            tareas.add(t);
    }

    /**
     * Busca la tarea por su nombre.
     * @since 23/09/12
     * @return La tarea o null.
     */
    public Tarea obtenerTareaPorNombre(String nombreTarea) {
        for (Tarea t : tareas) {
            logger.info("Comparando tarea " + t.getTarea() + " con " + nombreTarea);
            if (t.getTarea().equals(nombreTarea))
                return t;
        }
        return null;
    }
    
    /**
     * Devuelve una lista con las tareas en las que
     * se ha invertido tiempo en los últimos 7 días.
     * @since 29/09/12
     */
    public Collection<Tarea> tareasUltimos7Dias() {
        Collection<Tarea> tareas = new ArrayList<Tarea>();
        
        for (Tarea t : this.tareas)
            if (t.horasUltimosSieteDias() > 0.0)
                tareas.add(t);
        
        return tareas;
    }
    
    /**
     * Devuelve una colección con los objetos ControlProductividad
     * de las tareas que se han realizado en los últimos 7 días.
     * @since 29/09/12
     */
    public Collection<ControlProductividad> productividadUltimos7Dias() {
        Collection<ControlProductividad> lista = new ArrayList<ControlProductividad>();
        for (Tarea t : tareas) {
            if (t.horasUltimosSieteDias() > 0.0)
                lista.add(t.productividadUltimos7Dias());
        }
        return lista;
    }
    
    /**
     * Devuelve una lista con el número de horas empleadas en tareas
     * por cada fecha.
     * @param fecha
     * @param numDias 
     * @return null si la fecha es null o el número de días es negativo.
     */
    public Collection<HorasDia> horasDiasAnteriores(Date fecha,int numDias) {
        if (fecha == null) return null;
        if (numDias < 0) return null;
        
        Collection<HorasDia> lista = new ArrayList<HorasDia>();
        
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DATE, -numDias);
        
        double horas;
        for (int i = 1; i <= numDias; i++) {
            c.add(Calendar.DATE, 1);
            horas = 0.0;
            for (Tarea t : tareas) {
                horas += t.horasEnDia(c.getTime());
            }
            lista.add(new HorasDia(c.getTime(), horas));
        }
        
        return lista;
    }

}
