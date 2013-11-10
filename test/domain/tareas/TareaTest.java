/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tareas;

import domain.enums.ProductividadSesion;
import domain.sesiones.Sesion;
import java.util.Calendar;
import java.util.Date;
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
public class TareaTest {
    
    public TareaTest() {
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

    /**
     * Pruebas:
     * Por defecto es 0.0.
     * No cuentan las sesiones de hace más de 7 días.
     * No cuentan las sesiones de hace 7 días.
     * Cuentan las sesiones de hace menos de 7 días.
     * Cuentan las sesiones de hoy.
     * No cuentan las sesiones de mañana.
     */
    @Test
    public void horasUltimosSieteDias() {
        Tarea t = new Tarea();

        assertEquals(0.0,t.horasUltimosSieteDias(),0.0);
        
        Sesion s0 = new Sesion(sumarDias(-8),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s0);
        
        assertEquals(0.0,t.horasUltimosSieteDias(),0.0);
        
        Sesion s = new Sesion(sumarDias(-7),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s);
        
        assertEquals(0.0,t.horasUltimosSieteDias(),0.0);       
        
        Sesion s2 = new Sesion(sumarDias(-5),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s2);
        
        assertEquals(1.0,t.horasUltimosSieteDias(),0.0);
        
        Sesion s3 = new Sesion(new Date(),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s3);
        
        assertEquals(2.0,t.horasUltimosSieteDias(),0.0);
        
        Sesion s4 = new Sesion(sumarDias(1),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s4);
        
        assertEquals(2.0,t.horasUltimosSieteDias(),0.0);
    }
    
    private Date sumarDias(int numDias) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, numDias);
        return c.getTime();   
    }
    
    /**
     * Pruebas:
     * Por defecto es 0.0.
     * No cuentan las sesiones de hace más de 7 días.
     * No cuentan las sesiones de hace 7 días.
     * Cuentan las sesiones de hace menos de 7 días.
     * Cuentan las sesiones de hoy.
     * No cuentan las sesiones de mañana.
     */
    @Test
    public void horasProductivasUltimosSieteDias() {
        Tarea t = new Tarea();

        assertEquals(0.0,t.horasProductivasUltimosSieteDias(),0.0);
        
        Sesion s0 = new Sesion(sumarDias(-8),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s0);
        
        assertEquals(0.0,t.horasProductivasUltimosSieteDias(),0.0);
        
        Sesion s = new Sesion(sumarDias(-7),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s);
        
        assertEquals(0.0,t.horasProductivasUltimosSieteDias(),0.0);       
        
        Sesion s2 = new Sesion(sumarDias(-5),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s2);
        
        assertEquals(0.6,t.horasProductivasUltimosSieteDias(),0.0);
        
        Sesion s3 = new Sesion(new Date(),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s3);
        
        assertEquals(1.2,t.horasProductivasUltimosSieteDias(),0.0);
        
        Sesion s4 = new Sesion(sumarDias(1),1.0,ProductividadSesion.MEDIA);
        t.asignarSesion(s4);
        
        assertEquals(1.2,t.horasProductivasUltimosSieteDias(),0.0);       
    }
}
