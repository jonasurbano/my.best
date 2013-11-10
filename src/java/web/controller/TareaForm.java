package web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TareaForm {
 
    private String tarea;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    private double duracionEstimada;
    private double horasPorSesion;
    private String prioridad;
    private boolean lunes;
    private boolean martes;
    private boolean miercoles;
    private boolean jueves;
    private boolean viernes;
    private boolean sabado;
    private boolean domingo;

    public String getTarea() {
        return tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public double getDuracionEstimada() {
        return duracionEstimada;
    }

    public Date getDateFechaFin() {
        return convertirFecha(fechaFin);
    }
    
    public String getFechaFin() {
        return fechaFin;
    } 
    
    private Date convertirFecha(String stringFecha) {
        if (stringFecha == null) return null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            return sdf.parse(stringFecha);
        } catch (ParseException ex) {
            Logger.getLogger(TareaForm.class.getName()).log(Level.SEVERE, 
                "No se pudo convertir la fecha.", ex);
        }
        return null;
    }

    public Date getDateFechaInicio() {
        return convertirFecha(fechaInicio);
    }

    public String getFechaInicio() {
        return fechaInicio;
    }
    
    public double getHorasPorSesion() {
        return horasPorSesion;
    }

    public boolean isJueves() {
        return jueves;
    }

    public boolean isLunes() {
        return lunes;
    }

    public boolean isMartes() {
        return martes;
    }

    public boolean isMiercoles() {
        return miercoles;
    }

    public boolean isSabado() {
        return sabado;
    }

    public boolean isViernes() {
        return viernes;
    }
    
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public void setDuracionEstimada(double duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;

    }
    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setHorasPorSesion(double horasPorSesion) {
        this.horasPorSesion = horasPorSesion;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }
}
