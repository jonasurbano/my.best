package web.controller;

import domain.enums.ProductividadSesion;
import domain.sesiones.Sesion;
import domain.tareas.GestorTareas;
import domain.tareas.Tarea;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class NuevaSesionController extends SimpleFormController {
    private GestorTareas gestorTareas;

    public NuevaSesionController() {
        setCommandClass(SesionForm.class);
        setCommandName("sesionForm");
    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        SesionForm sf = (SesionForm)super.formBackingObject(request);
        
        gestorTareas.cargarTareas();
        Collection<Tarea> tareas = gestorTareas.tareasActivas();
        
        Collection<String> nombresTareas = new ArrayList<String>();
        
        for (Tarea t : tareas)
            nombresTareas.add(t.getTarea());
        
        sf.setTareas(nombresTareas);
        return sf;
    }

    @Override
    protected ModelAndView onSubmit(Object command, BindException bindException)
         throws Exception {

         logger.info("Ejecutando onSubmit del controlador NuevaSesionController.");

         SesionForm sesionForm = (SesionForm)command;

         Sesion s = new Sesion(sesionForm.getDateFecha(),sesionForm.getDuracion(),
             ProductividadSesion.obtenerProducitivdad(sesionForm.getProductividad()));

         Tarea t = gestorTareas.obtenerTareaPorNombre(sesionForm.getTarea());

         if (t == null) logger.info("No se ha encontrado tarea");
         else logger.info("El nombre de la tarea es " + t.getTarea());
         
         gestorTareas.asignarSesion(t, s);

         return new ModelAndView(getSuccessView());
    }
   
   public void setGestorTareas(GestorTareas gestorTareas) {
       this.gestorTareas = gestorTareas;
   }

}
