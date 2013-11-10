package domain.comparacion;

import java.util.Comparator;
import domain.ponderaciones.Ponderacion;

public class ComparacionDiasDesdeUltimaSesion implements Comparator<Ponderacion> {

	public int compare(Ponderacion p1, Ponderacion p2) {
		return new Double((p1.getDiasDesdeUltimaSesion()-p2.getDiasDesdeUltimaSesion())*100.0).intValue();
	}

}
