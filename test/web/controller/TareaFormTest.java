package web.controller;

import java.text.SimpleDateFormat;
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
public class TareaFormTest {
    
    public TareaFormTest() {
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

    public void testGetTarea() {
        System.out.println("getTarea");
        TareaForm instance = new TareaForm();
        String expResult = "";
        String result = instance.getTarea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        TareaForm instance = new TareaForm();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsDomingo() {
        System.out.println("isDomingo");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isDomingo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testGetDuracionEstimada() {
        System.out.println("getDuracionEstimada");
        TareaForm instance = new TareaForm();
        double expResult = 0.0;
        double result = instance.getDuracionEstimada();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDateFechaFin() {
        TareaForm instance = new TareaForm();
        
        instance.setFechaFin("2012-09-24T12:00");
        Date result = instance.getDateFechaFin();
        assertNotNull(result);
        
        assertEquals(24,result.getDate());
        assertEquals(9,result.getMonth());
        assertEquals(2012,result.getYear());
    }

    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        TareaForm instance = new TareaForm();
        String expResult = "";
        String result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDateFechaInicio() {
        TareaForm instance = new TareaForm();
        instance.setFechaInicio("2012-09-24T12:00");
        
        Date result = instance.getDateFechaInicio();
        assertNotNull(result);
        
        assertEquals(24,result.getDate());
        assertEquals(9,result.getMonth());
        assertEquals(2012,result.getYear());
    }
    
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        TareaForm instance = new TareaForm();
        String expResult = "";
        String result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testGetHorasPorSesion() {
        System.out.println("getHorasPorSesion");
        TareaForm instance = new TareaForm();
        double expResult = 0.0;
        double result = instance.getHorasPorSesion();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsJueves() {
        System.out.println("isJueves");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isJueves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsLunes() {
        System.out.println("isLunes");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isLunes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsMartes() {
        System.out.println("isMartes");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isMartes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsMiercoles() {
        System.out.println("isMiercoles");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isMiercoles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsSabado() {
        System.out.println("isSabado");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isSabado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsViernes() {
        System.out.println("isViernes");
        TareaForm instance = new TareaForm();
        boolean expResult = false;
        boolean result = instance.isViernes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetTarea() {
        System.out.println("setTarea");
        String tarea = "";
        TareaForm instance = new TareaForm();
        instance.setTarea(tarea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        TareaForm instance = new TareaForm();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetDomingo() {
        System.out.println("setDomingo");
        boolean domingo = false;
        TareaForm instance = new TareaForm();
        instance.setDomingo(domingo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetDuracionEstimada() {
        System.out.println("setDuracionEstimada");
        double duracionEstimada = 0.0;
        TareaForm instance = new TareaForm();
        instance.setDuracionEstimada(duracionEstimada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        String fechaFin = "";
        TareaForm instance = new TareaForm();
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        String fechaInicio = "";
        TareaForm instance = new TareaForm();
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetHorasPorSesion() {
        System.out.println("setHorasPorSesion");
        double horasPorSesion = 0.0;
        TareaForm instance = new TareaForm();
        instance.setHorasPorSesion(horasPorSesion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetJueves() {
        System.out.println("setJueves");
        boolean jueves = false;
        TareaForm instance = new TareaForm();
        instance.setJueves(jueves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetLunes() {
        System.out.println("setLunes");
        boolean lunes = false;
        TareaForm instance = new TareaForm();
        instance.setLunes(lunes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetMartes() {
        System.out.println("setMartes");
        boolean martes = false;
        TareaForm instance = new TareaForm();
        instance.setMartes(martes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetMiercoles() {
        System.out.println("setMiercoles");
        boolean miercoles = false;
        TareaForm instance = new TareaForm();
        instance.setMiercoles(miercoles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetSabado() {
        System.out.println("setSabado");
        boolean sabado = false;
        TareaForm instance = new TareaForm();
        instance.setSabado(sabado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetViernes() {
        System.out.println("setViernes");
        boolean viernes = false;
        TareaForm instance = new TareaForm();
        instance.setViernes(viernes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetPrioridad() {
        System.out.println("setPrioridad");
        String prioridad = "";
        TareaForm instance = new TareaForm();
        instance.setPrioridad(prioridad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testGetPrioridad() {
        System.out.println("getPrioridad");
        TareaForm instance = new TareaForm();
        String expResult = "";
        String result = instance.getPrioridad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
