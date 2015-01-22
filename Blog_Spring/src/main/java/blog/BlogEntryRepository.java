package blog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BlogEntryRepository extends CrudRepository<BlogEntry, Long> {

	List<BlogEntry> findById(int id);
	
	List<BlogEntry> findByNombre(String nombre);
		
}