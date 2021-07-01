
package entidades;

public class Persona {

	private Integer id; 
	private String nombre; 
	private String primerModificacion; 
	private String segundaModificacion; 

	public Persona() {
	}

	public Persona(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
