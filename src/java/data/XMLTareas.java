/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.tareas.Tarea;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Persiste las tareas en archivos XML dentro de un directorio
 * repository en el directorio del usuario.
 * @author Jonás
 */
public class XMLTareas implements PersistenciaTareas {
    
    @Override
    public void actualizarTarea(Tarea tarea) {
        // TODO: Guardar el nombre de archivo como su hash
        // no es útil para actualizar. Crearía una tarea nueva.
        almacenarTarea(tarea);
    }

    /**
     * Obtiene la ruta al repositorio
     * @return null si no se pudo crear el directorio
     */
    private String obtenerRepositorio() {
        File f = new File(System.getProperty("user.home") + 
            System.getProperty("file.separator") + "repository");
        
        if (!f.exists())
            if (!f.mkdir()) return null;
        return f.getPath();
    }
    
    /**
     * Almacena una tarea en un archivo XML dentro del repositorio
     * @param t 
     */
    @Override
    public void almacenarTarea(Tarea t) {
        if (t == null) return;
        
        JAXBContext context = null;
        Marshaller m = null;
        Writer w = null;

        String rutaRepositorio = obtenerRepositorio();
        if (rutaRepositorio == null) {
            Logger.getLogger(XMLTareas.class.getName()).log(Level.SEVERE, 
                "No se pudo obtener el directorio de repositorios");
            return;
        }
            
        try {
            context = JAXBContext.newInstance(Tarea.class);
            m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            w = new FileWriter(obtenerRepositorio() + 
                System.getProperty("file.separator") +
                Integer.toString(t.hashCode()) + ".xml");
            m.marshal(t, w);

        } catch(Exception e) {
            Logger.getLogger(XMLTareas.class.getName()).log(Level.SEVERE, 
                null, e);
        } finally {
            try {
                if (w != null) w.close();
            } catch (IOException ex) {
                Logger.getLogger(XMLTareas.class.getName()).log(Level.SEVERE, 
                    null, ex);
            }
        }
    }

    /**
     * Devuelve una colección de tareas recogidas del repositorio
     * @return colección vacía si no se pudo acceder al directorio
     * o no hay tareas dentro.
     */
    @Override
    public Collection<Tarea> cargarTareas() {
        File directorio = new File(obtenerRepositorio());
        File[] archivos = directorio.listFiles();

        Collection<Tarea> tareas = new ArrayList<Tarea>();
        
        if (archivos == null) return tareas;
        
        for (int i = 0; i < archivos.length; i++)
            tareas.add(cargarTarea(archivos[i]));
        
        return tareas;
    }

    /**
     * Extrae una tarea de un archivo XML
     * @param xml
     * @return null si xml es nulo.
     */
    public Tarea cargarTarea(File xml) {
        if (xml == null) return null;
        
        JAXBContext context = null;
        Unmarshaller um = null;
        Tarea t = null;
        
        try {
            context = JAXBContext.newInstance(Tarea.class);
            um = context.createUnmarshaller();
            
            t = (Tarea)um.unmarshal(new FileReader(xml));
        } catch(Exception e) {
            Logger.getLogger(XMLTareas.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return t;
    }

    /**
     * Almacena las tareas en diferentes archivos XML
     * @param tareas 
     */
    @Override
    public void almacenarTareas(Collection<Tarea> tareas) {
        if (tareas == null) return;
        for (Tarea t : tareas) almacenarTarea(t);
    }

    @Override
    public void actualizarTareas(List<Tarea> tareas) {
        // TODO: Guardar el nombre de archivo como su hash
        // no es útil para actualizar. Crearía una tarea nueva.
        almacenarTareas(tareas);
    }

}
