package domain.enums;

/**
 * Enum para determinar la prioridad que se le aplica a una tarea.
 * @author Jon�s Urbano.
 * @since 27/10/11.
 * @see Tarea.
 */
public enum PrioridadTarea {
	NINGUNA,
	BAJA,
	MEDIA,
	ALTA,
	MUY_ALTA;
	
	/**
	 * Difiere de name().
	 */
	public String toString() {
            if (name().equals("NINGUNA")) return "Ninguna";
            else if (name().equals("BAJA")) return "Baja";
            else if (name().equals("MEDIA")) return "Media";
            else if (name().equals("ALTA")) return "Alta";
            else return "Muy alta";
	}
	
	public static String[] toArrayString() {
		return new String[] {"Ninguna", "Baja", "Media", "Alta", "Muy alta"};
	}
	
	public static PrioridadTarea getPrioridadTarea(int i) {
            if (i == 0) return PrioridadTarea.NINGUNA;
            if (i == 1) return PrioridadTarea.BAJA;
            if (i == 2) return PrioridadTarea.MEDIA;
            if (i == 3) return PrioridadTarea.ALTA;
            return PrioridadTarea.MUY_ALTA;
	}
        
        public static PrioridadTarea getPrioridadTarea(String p) {
            if (p.equals("Ninguna")) return PrioridadTarea.NINGUNA;
            if (p.equals("Baja")) return PrioridadTarea.BAJA;
            if (p.equals("Media")) return PrioridadTarea.MEDIA;
            if (p.equals("Alta")) return PrioridadTarea.ALTA;
            return PrioridadTarea.MUY_ALTA;
	}
}
