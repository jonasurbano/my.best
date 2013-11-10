package web.controller;

import domain.tareas.GestorTareas;
import domain.tareas.Tarea;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class RealizarTareaController extends AbstractController {
    
    private GestorTareas gestorTareas;
    protected final Log logger = LogFactory.getLog(getClass());
 
    
    public RealizarTareaController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) {
    
        Long id = Long.parseLong((String)request.getParameter("id"));
        Tarea tarea = gestorTareas.getTareaPorId(id);
        
        if (tarea == null) 
            return new ModelAndView("tareaEliminada","eliminada",new Boolean(false));
    
        
        tarea.setRealizada(true);
        gestorTareas.actualizarTarea(tarea);
        
        return new ModelAndView("tareaRealizada","realizada",new Boolean(true));
    }

    public void setGestorTareas(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }
}
