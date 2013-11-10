package domain.comparacion;

import java.util.Comparator;
import domain.ponderaciones.Ponderacion;

public class ComparacionPorcentajeRestante implements Comparator<Ponderacion> {

	public int compare(Ponderacion p1, Ponderacion p2) {
		return new Double((p1.getPorcentajeRestante()-p2.getPorcentajeRestante())*100.0).intValue();
	}

}
