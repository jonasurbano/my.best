package domain.comparacion;

import java.util.Comparator;
import domain.tareas.Tarea;

public class ComparacionTareasFijas implements Comparator<Tarea> {

	public int compare(Tarea t1, Tarea t2) {
		Double f1 = 1 - t1.porcentajeRealizado();
		Double f2 = 1 - t2.porcentajeRealizado();
		return (new Double((f1-f2)*100.0)).intValue();
	}

}
