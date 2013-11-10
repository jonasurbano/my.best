package web.controller;

import domain.tareas.GestorTareas;
import domain.tareas.Tarea;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author
 * Jonás
 */
public class TareasUltimos7DiasController implements Controller {
    private GestorTareas gestorTareas;
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) 
        throws Exception {
        
        gestorTareas.cargarTareas();
        
        logger.info("Devolviendo vista desde TareasUltimos7DiasController.");
        return new ModelAndView("tareasUltimos7dias","tareas",gestorTareas.tareasUltimos7Dias());
    }
    
    public void setGestorTareas(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }

}
