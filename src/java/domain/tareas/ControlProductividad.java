package domain.tareas;

/**
 *
 * @author
 * Jonás
 */
public class ControlProductividad {
    private Tarea tarea;
    private String nombreTarea;
    private double horas;
    private double horasProductivas;

    ControlProductividad(Tarea tarea, double horas, double horasProductivas) {
        this.tarea = tarea;
        nombreTarea = tarea.getTarea();
        this.horas = horas;
        this.horasProductivas = horasProductivas;
    }

    /**
     * @return the tarea
     */
    public Tarea getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    /**
     * @return the nombreTarea
     */
    public String getNombreTarea() {
        return nombreTarea;
    }

    /**
     * @param nombreTarea the nombreTarea to set
     */
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    /**
     * @return the horas
     */
    public double getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(double horas) {
        this.horas = horas;
    }

    /**
     * @return the horasProductivas
     */
    public double getHorasProductivas() {
        return horasProductivas;
    }

    /**
     * @param horasProductivas the horasProductivas to set
     */
    public void setHorasProductivas(double horasProductivas) {
        this.horasProductivas = horasProductivas;
    }
}
