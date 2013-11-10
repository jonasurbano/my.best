/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tareas;

import data.PersistenciaTareas;
import data.XMLTareas;
import domain.enums.ProductividadSesion;
import domain.sesiones.Sesion;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author
 * Jonás
 */
public class GestorTareasTest {
    
    private static GestorTareas gestor;
    private static PersistenciaTareas persistencia;
    
    public GestorTareasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        gestor = new GestorTareas();
        persistencia = new XMLTareas();
        
        gestor.setPersistencia(persistencia);
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


    /**
     * Pruebas:
     * No se añade la tarea sin sesiones.
     * No se añade la tarea sin sesiones en los últimos 7 días.
     * Se añade la tarea con sesiones en los últimos 7 días.
     */
    public void tareasUltimos7Dias() {
        GestorTareas gestor = new GestorTareas();
        
        Tarea t = new Tarea();
        gestor.nuevaTarea(t);
        
        assertTrue(gestor.tareasUltimos7Dias().isEmpty());
        
        Sesion s = new Sesion(sumarDias(-8),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s);
        
        assertTrue(gestor.tareasUltimos7Dias().isEmpty());
        
        Sesion s2 = new Sesion(sumarDias(-2),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s2);
        
        assertEquals(1,gestor.tareasUltimos7Dias().size());
    }
    
    private Date sumarDias(int numDias) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, numDias);
        return c.getTime();   
    }
    
    /**
     * Pruebas:
     * Si una fecha es null devuelve false.
     * Si las dos fechas son la misma devuelve true.
     * Si el mismo día unas horas más tarde, devuelve true.
     * Si al añadir horas una fecha se pasa al día siguiene
     * son fechas distintas y devuelve false.
     */
    public void mismoDia() {
        Date fecha1 = Calendar.getInstance().getTime();
        
        assertFalse(GestorTareas.mismoDia(fecha1, null));
        
        assertTrue(GestorTareas.mismoDia(fecha1, fecha1));
        
        Calendar fecha2 = Calendar.getInstance();
        fecha2.add(Calendar.HOUR, 1);
        
        assertTrue(GestorTareas.mismoDia(fecha1, fecha2.getTime()));
        
        fecha2.add(Calendar.HOUR, 18);
        
        assertFalse(GestorTareas.mismoDia(fecha1, fecha2.getTime()));
    }

    /**
     * Test of nuevaTarea method, of class GestorTareas.
     */
    public void testNuevaTarea() {
    }

    /**
     * Test of anadirTarea method, of class GestorTareas.
     */
    public void testAnadirTarea_Tarea() {
    }

    /**
     * Test of asignarSesion method, of class GestorTareas.
     */
    public void testAsignarSesion() {
    }

    /**
     * Test of anadirTarea method, of class GestorTareas.
     */
    public void testAnadirTarea_TareaFutura() {
    }

    /**
     * Test of tareasFijas method, of class GestorTareas.
     */
    public void testTareasFijas() {
    }

    /**
     * Test of tareasPosibles method, of class GestorTareas.
     */
    public void testTareasPosibles() {
    }

    /**
     * Test of maxFechaFinal method, of class GestorTareas.
     */
    public void testMaxFechaFinal() {
    }

    /**
     * Test of maxDiasDesdeUltimaSesion method, of class GestorTareas.
     */
    public void testMaxDiasDesdeUltimaSesion() {
    }

    /**
     * Test of diasEntreFechas method, of class GestorTareas.
     */
    public void testDiasEntreFechas() {
    }

    /**
     * Test of mismoDia method, of class GestorTareas.
     */
    public void testMismoDia() {
    }

    /**
     * Test of ponderar method, of class GestorTareas.
     */
    public void testPonderar() {
    }

    /**
     * Test of ordenarFechaFin method, of class GestorTareas.
     */
    public void testOrdenarFechaFin() {
    }

    /**
     * Test of ordenarPorcentajeRestante method, of class GestorTareas.
     */
    public void testOrdenarPorcentajeRestante() {
    }

    /**
     * Test of ordenarPrioridad method, of class GestorTareas.
     */
    public void testOrdenarPrioridad() {
    }

    /**
     * Test of ordenarDiasUltimaSesion method, of class GestorTareas.
     */
    public void testOrdenarDiasUltimaSesion() {
    }

    /**
     * Test of ordenarDuracionEstimada method, of class GestorTareas.
     */
    public void testOrdenarDuracionEstimada() {
    }

    /**
     * Test of ordenarSumaCompleta method, of class GestorTareas.
     */
    public void testOrdenarSumaCompleta() {
    }

    /**
     * Test of coleccionTareasOrdenadas method, of class GestorTareas.
     */
    public void testColeccionTareasOrdenadas() {
    }

    /**
     * Test of tareasToStringArray method, of class GestorTareas.
     */
    public void testTareasToStringArray() {
    }

    /**
     * Test of horasPorSesion method, of class GestorTareas.
     */
    public void testHorasPorSesion() {
    }

    /**
     * Test of getTareaPorNombre method, of class GestorTareas.
     */
    public void testGetTareaPorNombre() {
    }

    /**
     * Test of getTareaPorId method, of class GestorTareas.
     */
    public void testGetTareaPorId() {
    }

    /**
     * Test of obtenerInformacion method, of class GestorTareas.
     */
    public void testObtenerInformacion() {
    }

    /**
     * Test of tareasActivas method, of class GestorTareas.
     */
    public void testTareasActivas() {
    }

    /**
     * Test of setPersistencia method, of class GestorTareas.
     */
    public void testSetPersistencia() {
    }

    /**
     * Test of persistenciaTareasIsSet method, of class GestorTareas.
     */
    public void testPersistenciaTareasIsSet() {
    }

    /**
     * Test of almacenarTarea method, of class GestorTareas.
     */
    public void testAlmacenarTarea() {
    }

    /**
     * Test of actualizarTarea method, of class GestorTareas.
     */
    public void testActualizarTarea() {
    }

    /**
     * Test of almacenarTareas method, of class GestorTareas.
     */
    public void testAlmacenarTareas() {
    }

    /**
     * Test of cargarTareas method, of class GestorTareas.
     */
    @Test
    public void testCargarTareas() {
        gestor.cargarTareas();
    }

    /**
     * Test of obtenerTareaPorNombre method, of class GestorTareas.
     */
    public void testObtenerTareaPorNombre() {
    }

    /**
     * Test of tareasUltimos7Dias method, of class GestorTareas.
     */
    public void testTareasUltimos7Dias() {
    }

    /**
     * Test of productividadUltimos7Dias method, of class GestorTareas.
     */
    public void testProductividadUltimos7Dias() {
    }

    /**
     * Test of horasDiasAnteriores method, of class GestorTareas.
     */
    public void testHorasDiasAnteriores() {
    }
}
