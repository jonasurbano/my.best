package domain.comparacion;

import java.util.Comparator;
import domain.ponderaciones.Ponderacion;

public class ComparacionPrioridad implements Comparator<Ponderacion> {

	public int compare(Ponderacion p1, Ponderacion p2) {
		return new Double((p1.getPrioridad()-p2.getPrioridad())*100.0).intValue();
	}

}
