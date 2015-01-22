package blog;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//from: http://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/
// http://www.concretepage.com/hibernate/example-mappedsuperclass-hibernate
@MappedSuperclass
public class GenericEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	private String titulo;
	private String mensaje;

	public GenericEntry() {
	}

	public GenericEntry(String nombre, String titulo, String mensaje) {
		this.nombre = nombre;
		this.titulo = titulo;
		this.mensaje = mensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
