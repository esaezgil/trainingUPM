package blog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comments, Long> {

	List<BlogEntry> findByIdBlogEntry(long idBlogEntry);
	
	List<BlogEntry> findByNombre(String nombre);	
}