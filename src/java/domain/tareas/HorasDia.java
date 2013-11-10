package domain.tareas;

import java.util.Date;

/**
 *
 * @author
 * Jonás
 */
public class HorasDia {
    private Date dia;
    private double horas;

    public HorasDia(Date dia,double horas) {
        this.dia = dia;
        this.horas = horas;
    }
    
    /**
     * @return the dia
     */
    public Date getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Date dia) {
        this.dia = dia;
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
}
