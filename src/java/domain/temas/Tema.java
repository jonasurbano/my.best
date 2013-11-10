package domain.temas;

public class Tema {
        private long id;
	private String nombre;
	private String superTema;
	
        public Tema(String nombre) {
            this.nombre = nombre;
        }
        
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSuperTema() {
		return superTema;
	}
	public void setSuperTema(String superTema) {
		this.superTema = superTema;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
    
}
