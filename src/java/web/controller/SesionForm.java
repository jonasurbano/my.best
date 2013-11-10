package web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SesionForm extends ControlDisciplinaForm {

    private String fecha;
    private double duracion;
    private String productividad;    

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    public Date getDateFecha() {
        if (fecha == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            return sdf.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SesionForm.class.getName()).log(Level.SEVERE, 
                "No se pudo convertir la fecha.", ex);
        }
        return null;
    }    

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the duracion
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the productividad
     */
    public String getProductividad() {
        return productividad;
    }

    /**
     * @param producitvidad the productividad to set
     */
    public void setProductividad(String producitvidad) {
        this.productividad = producitvidad;
    }


    
}
