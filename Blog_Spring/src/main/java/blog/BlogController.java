package blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;

@Controller
public class BlogController {

	@Autowired
	private BlogEntryRepository blogEntryRepository;

	@Autowired
	private CommentsRepository commentRepository;
		
	private List<BlogEntry> entryList = new ArrayList<>();
	private final int PREVIEW_LENGTH = 5;
	int[] listaNumComments;
	
	@RequestMapping("/")
	public String tablon(Model model) {
		
		updateAdvertList(); // load the values from the DataBase if existing...
		model.addAttribute("entryList", Utils.summarizedAdList(entryList, PREVIEW_LENGTH));
		model.addAttribute("listaNumComments", listaNumComments());

		return "blog_template";
	}

	@RequestMapping("/newEntry")
	public String insertarEntrada(BlogEntry blogEntry,
			@RequestParam(value = "insertar", required = false) String enviar,
			Model model) {
		
		if (enviar != null) {
			//entryList.add(blogEntry);
			blogEntryRepository.save(blogEntry);
		}
		
		updateAdvertList();
		
		model.addAttribute("entryList", Utils.summarizedAdList(entryList, PREVIEW_LENGTH));
		model.addAttribute("listaNumComments", listaNumComments());
		return "blog_template";
	}
	//TODO: debería juntar el /newEntry con el /newComment, ambos con objetos GenericEntry...
	@RequestMapping("/newComment")
	public String nuevoComentario(Comments comentario,
			Model model) {
	
			BlogEntry blogEntry = blogEntryRepository.findOne(comentario.getIdBlogEntry());
			blogEntry.addComment(comentario);
			commentRepository.save(comentario); //guardo blog en DB y actualizo lista
			updateAdvertList();//TODO: se actualiza así la lista de comentarios de cada entrada de Blog también?!
			model.addAttribute("entryList", entryList);
			model.addAttribute("listaNumComments", listaNumComments());
			return "blog_template";
	}	
	
	private int[] listaNumComments(){ //TODO: tiene qe ser con consulta a la DB o no hace falta=!?
		updateAdvertList();
		listaNumComments = new int[entryList.size()];
		for (int i = 0; i < entryList.size(); i++) {
				listaNumComments[i] = entryList.get(i).getNumComments();
			}
		//commentRepository.findByIdAnuncio(0).size();
		return listaNumComments;		
	}
	
	@RequestMapping("/mostrar")
	public String mostrar(@RequestParam long numBlogEntry, Model model) {

		updateAdvertList();
		BlogEntry blogEntry = blogEntryRepository.findOne(numBlogEntry);
		
		model.addAttribute("blogEntry", blogEntry);
		model.addAttribute("numBlogEntry", numBlogEntry);
		
		return "blog_entry";
	}
	
	@RequestMapping("/usuario")
	public String usuario(@RequestParam String usuario, Model model) {

		updateAdvertList();
		List<BlogEntry> entradasBlog = blogEntryRepository.findByNombre(usuario);
		List<BlogEntry> comentarios = commentRepository.findByNombre(usuario);
		 
		model.addAttribute("entradasBlog", entradasBlog);
		model.addAttribute("comentarios", comentarios);
		
		return "users";
	}
	
	@RequestMapping("/listarUsers")
	public String listarUsers(Model model) {

		updateAdvertList();
		
		Iterable<BlogEntry> aux  = blogEntryRepository.findAll();			
		Iterable<Comments> aux2  = commentRepository.findAll();		

		Set<String> userSet = Utils.getBlogUsers(aux, aux2); 
		
		model.addAttribute("listaUsuarios", userSet);		
		return "lista_users";
	}
	
	@RequestMapping("/deleteEntry")
	public String deleteEntry(@RequestParam long numBlogEntry, 
			@RequestParam(value = "idComment", required = false) String idComment,
			Model model) {
		
		if(idComment != null){ //solo borro el comentario, actualizo 1º) listaComentarios y 2º) DB				
			BlogEntry aux = blogEntryRepository.findOne(numBlogEntry);
			aux.deleteComment();
			commentRepository.delete(Long.valueOf(idComment));			
			} else{			
				blogEntryRepository.delete(numBlogEntry); //borro entradas del blog y sus comentarios de la DB
			}
		updateAdvertList();
		
		model.addAttribute("entryList", Utils.summarizedAdList(entryList, 2));
		model.addAttribute("listaNumComments", listaNumComments());

		return "blog_template";
	}
	
	private void updateAdvertList(){		
		//TODO: se actualiza así la lista de comentarios de cada Ad también?!
		Iterable<BlogEntry> aux  = blogEntryRepository.findAll();//convertirlo a List!
		entryList = Lists.newArrayList(aux); //using guava as suggested: http://tinyurl.com/Iterabledoubt		
	}
}