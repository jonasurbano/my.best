package web.controller;

import domain.tareas.GestorTareas;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HorasPorDiaController implements Controller {
    private GestorTareas gestorTareas;
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        gestorTareas.cargarTareas();
        
        logger.info("Devolviendo vista desde HorasPorDiaController.");
        return new ModelAndView("horasPorDia","dias",
            gestorTareas.horasDiasAnteriores(new Date(),7));

    }
    
    public void setGestorTareas(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }
}
