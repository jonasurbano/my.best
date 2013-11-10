package web.controller;

import domain.tareas.GestorTareas;
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
public class ControlProductividadController implements Controller {
    private GestorTareas gestorTareas;
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        gestorTareas.cargarTareas();
        
        logger.info("Devolviendo vista desde ControlProductividadController.");
        return new ModelAndView("controlProductividad","controlProductividad",
            gestorTareas.productividadUltimos7Dias());

    }
   
    public void setGestorTareas(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }
}
