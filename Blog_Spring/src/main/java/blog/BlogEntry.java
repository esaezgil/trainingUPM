package blog;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "advertList")
public class BlogEntry extends GenericEntry {

	private int numComments;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "entry_id")
	// from:
	// https://www.safaribooksonline.com/library/view/spring-data/9781449331863/ch04.html
	private List<Comments> commentList = new ArrayList<Comments>();

	public BlogEntry() {

	}

	public BlogEntry(String nombre, String titulo, String mensaje) {
		super(nombre, titulo, mensaje);
		this.numComments = 0;
	}

	// constructor para la lista resumida...
	public BlogEntry(long id, String nombre, String titulo, String mensaje, int numComments) {
		this(nombre, titulo, mensaje);
		super.setId(id);
		this.numComments = numComments;
	}

	public List<Comments> getCommentList() {
		return commentList;
	}

	public void addComment(Comments comment) {
		this.commentList.add(comment);
		numComments++;
	}

	public void deleteComment() {
		numComments--;
	}

	public int getNumComments() {
		return this.numComments;
	}

	public void setCommentList(List<Comments> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return String.format("Anuncio[id=%d, nombre='%s', mensaje='%s']",
				super.getId(), super.getNombre(), super.getMensaje());
	}

	public long getId() {
		return super.getId();
	}
}
