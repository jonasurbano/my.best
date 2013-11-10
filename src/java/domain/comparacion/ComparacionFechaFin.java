package domain.comparacion;

import java.util.Comparator;
import domain.ponderaciones.Ponderacion;

public class ComparacionFechaFin implements Comparator<Ponderacion> {

	public int compare(Ponderacion p1, Ponderacion p2) {
		return new Double((p1.getFechaFin()-p2.getFechaFin())*100.0).intValue();
	}

}
