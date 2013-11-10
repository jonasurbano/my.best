package domain.comparacion;

import java.util.Comparator;
import domain.ponderaciones.Ponderacion;

public class ComparacionDuracionEstimada implements Comparator<Ponderacion> {

	public int compare(Ponderacion p1, Ponderacion p2) {
		return new Double((p1.getDuracionEstimada()-p2.getDuracionEstimada())*100.0).intValue();
	}

}
