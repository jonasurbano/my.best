package web.controller;

import domain.enums.PrioridadTarea;
import domain.tareas.Tarea;
import domain.periodicidad.PeriodicidadSemanal;
import domain.temas.Tema;
import domain.tareas.GestorTareas;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class NuevaTareaController extends SimpleFormController {
    private GestorTareas gestorTareas;
 
    public NuevaTareaController() {
        setCommandClass(TareaForm.class);
        setCommandName("tareaForm");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return (TareaForm)super.formBackingObject(request);
    }
    
   @Override
   protected ModelAndView onSubmit(Object command, BindException bindException)
        throws Exception {

        logger.info("Ejecutando onSubmit del controlador.");
        
        TareaForm tareaForm = (TareaForm)command;
        
        PeriodicidadSemanal periodicidad = null;
        if (tareaForm.isLunes() || tareaForm.isMartes() ||
            tareaForm.isMiercoles() || tareaForm.isJueves() ||
            tareaForm.isViernes() || tareaForm.isSabado() ||
            tareaForm.isDomingo()) {
        
            periodicidad = new PeriodicidadSemanal(
                tareaForm.isLunes(),tareaForm.isMartes(),
                tareaForm.isMiercoles(),tareaForm.isJueves(),
                tareaForm.isViernes(),tareaForm.isSabado(),
                tareaForm.isDomingo());
        }
        
        Tarea tarea = new Tarea(
            tareaForm.getTarea(),
            tareaForm.getDateFechaInicio(),
            tareaForm.getDateFechaFin(),
            tareaForm.getDescripcion(),
            tareaForm.getDuracionEstimada(),
            tareaForm.getHorasPorSesion(),
            PrioridadTarea.getPrioridadTarea(tareaForm.getPrioridad()),
            periodicidad);
        
        gestorTareas.anadirTarea(tarea);
      
        return new ModelAndView(getSuccessView());
   }
    
    /**
     * Establece la propiedad gestorTareas.
     * Usado por Spring para inyectar la dependencia desde
     * dispatcher-servlet.xml.
     * @param gestorTareas 
     */
    public void setGestorTareas(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }
}
