package web.controller;

import domain.enums.ProductividadSesion;
import domain.sesiones.Sesion;
import domain.tareas.GestorTareas;
import domain.tareas.Tarea;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ControlDisciplinaController extends SimpleFormController {
    private GestorTareas gestorTareas;

    public ControlDisciplinaController() {
        setCommandClass(ControlDisciplinaForm.class);
        setCommandName("controlDisciplina");
    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        ControlDisciplinaForm cdf = (ControlDisciplinaForm)super.formBackingObject(request);
        
        gestorTareas.cargarTareas();
        Collection<Tarea> tareas = gestorTareas.tareasActivas();
        
        Collection<String> nombresTareas = new ArrayList<String>();
        
        for (Tarea t : tareas)
            nombresTareas.add(t.getTarea());
        
        cdf.setTareas(nombresTareas);
        return cdf;
    }

    @Override
    protected ModelAndView onSubmit(Object command, BindException bindException)
         throws Exception {

         logger.info("Ejecutando onSubmit del controlador ControlDisciplinaController.");

         ControlDisciplinaForm cdf = (ControlDisciplinaForm)command;

         Tarea t = gestorTareas.obtenerTareaPorNombre(cdf.getTarea());

         return new ModelAndView(getSuccessView(),"fechas",t.fechasSesiones(new Date(),7));
    }
   
    public void setGestorTareas(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }

}
