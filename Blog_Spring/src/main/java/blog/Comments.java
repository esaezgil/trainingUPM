package blog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "commentList")
public class Comments extends GenericEntry {

	private long idBlogEntry; // id del blog al que corresponde el comentario

	public Comments() {
	}

	public Comments(String nombre, String titulo, String mensaje, long idBlogEntry) {
		super(nombre, titulo, mensaje);
		this.idBlogEntry = idBlogEntry;
	}

	public long getIdBlogEntry() {
		return idBlogEntry;
	}

	public long getId() {
		return super.getId();
	}

	@Override
	public String toString() {
		return String.format(
				"Anuncio[id=%d, nombre='%s', asunto='%s', mensaje='%s']",
				super.getId(), super.getNombre(), super.getTitulo(), super.getMensaje());
	}

	public void setIdBlogEntry(long idBlogEntry) {
		this.idBlogEntry = idBlogEntry;
	}
}
