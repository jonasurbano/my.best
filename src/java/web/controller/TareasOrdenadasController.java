package web.controller;

import domain.tareas.GestorTareas;

import domain.tareas.Tarea;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author hn
 */
public class TareasOrdenadasController implements Controller {
    private GestorTareas gestorTareas;
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        gestorTareas.cargarTareas();
        Collection<Tarea> tareas = gestorTareas.coleccionTareasOrdenadas();

        logger.info("Devolviendo vista desde TareasOrdenadasController.");
        return new ModelAndView("tareasOrdenadas","tareas",tareas);
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
