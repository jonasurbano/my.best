package web.controller;

import java.util.Collection;

/**
 *
 * @author
 * Jonás
 */
public class ControlDisciplinaForm {
    protected String tarea;
    protected Collection<String> tareas;
    
    /**
     * @return the tarea
     */
    public String getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    public void setTareas(Collection<String> tareas) {
       this.tareas = tareas;
    }
    
    public Collection<String> getTareas() {
        return tareas;
    }
}
