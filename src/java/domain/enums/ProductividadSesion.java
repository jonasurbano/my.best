package domain.enums;

/**
 * Enum para determinar la productividad en una sesi�n.
 * @author Jon�s Urbano.
 * @since 27-10-11.
 * @see Sesion
 */
public enum ProductividadSesion {
	BAJA,
	MEDIA,
	ALTA;

	/**
	 * Difiere de name().
	 */
	public String toString() {
            if (name().equals("BAJA")) return "Baja";
            else if (name().equals("ALTA")) return "Alta";
            else return "Media";
	}
	
	public static String[] toArrayString() {
            return new String[] {"Baja", "Media", "Alta"};
	}

        public static ProductividadSesion obtenerProducitivdad(String p) {
            if (p.equals("Baja")) return ProductividadSesion.BAJA;
            else if (p.equals("Alta")) return ProductividadSesion.ALTA;
            return ProductividadSesion.MEDIA;
        }
        
}
