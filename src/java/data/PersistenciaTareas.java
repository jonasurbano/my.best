package data;

import domain.periodicidad.PeriodicidadSemanal;
import domain.sesiones.Sesion;
import domain.tareas.Tarea;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author hn
 */
public interface PersistenciaTareas {
    public void actualizarTarea(Tarea tarea);
    public void almacenarTarea(Tarea t);
    
    public Collection<Tarea> cargarTareas();
    public void almacenarTareas(Collection<Tarea> tareas);
    public void actualizarTareas(List<Tarea> tareas);
    
//    public void almacenarSesion(Sesion s);
//    public Collection<Sesion> cargarSesiones();
//    public void almacenarSesiones(Collection<Sesion> sesiones);
//
//    public Collection<PeriodicidadSemanal> cargarPeriodicidadSemanal();
//    public void almacenarPeriodicidadSemanal(PeriodicidadSemanal p);	
}
