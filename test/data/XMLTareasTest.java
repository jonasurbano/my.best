/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.enums.PrioridadTarea;
import domain.enums.ProductividadSesion;
import domain.periodicidad.PeriodicidadSemanal;
import domain.sesiones.Sesion;
import domain.tareas.Tarea;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 * Jonás
 */
public class XMLTareasTest {
    
    public XMLTareasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAlmacenarTarea() {
        Tarea t = new Tarea("Prueba", new Date(), new Date(113,1,18),PrioridadTarea.NINGUNA);
        Sesion s = new Sesion(null, 4, ProductividadSesion.BAJA);
        PeriodicidadSemanal p = new PeriodicidadSemanal(true, true, true, true, true, true, true);
        t.asignarSesion(s);
        t.setPeriodicidadSemanal(p);
        XMLTareas instance = new XMLTareas();
        instance.almacenarTarea(t);
        
        File f = new File("repository\\" + Integer.toString(t.hashCode()));
        Tarea t2 = instance.cargarTarea(f);
        
        assertEquals(t.getTarea(), t2.getTarea());
    }

    @Test
    public void testCargarTareas() {
        Tarea t1 = new Tarea("Prueba1", new Date(), new Date(113,1,18),PrioridadTarea.NINGUNA);
        Tarea t2 = new Tarea("Prueba2", new Date(), new Date(113,1,18),PrioridadTarea.NINGUNA);
        Tarea t3 = new Tarea("Prueba3", new Date(), new Date(113,1,18),PrioridadTarea.NINGUNA);
        
        XMLTareas instance = new XMLTareas();
        instance.almacenarTarea(t1);
        instance.almacenarTarea(t2);
        instance.almacenarTarea(t3);
        
        Collection<Tarea> tareas = instance.cargarTareas();
        
        assertEquals(4,tareas.size());
    }
    
}
