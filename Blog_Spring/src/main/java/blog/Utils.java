package blog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

public final class Utils {

	private static String truncate(String value, int length) {
		// from: http://tinyurl.com/truncateString
		if (value != null && value.length() > length)
			value = value.substring(0, length);
		return value;
	}

	public static List<BlogEntry> summarizedAdList(List<BlogEntry> listaAnuncios,
			int length) {
		ArrayList<BlogEntry> aux = new ArrayList<BlogEntry>();

		for (BlogEntry anuncio : listaAnuncios) {
			String summary = truncate(anuncio.getMensaje(), length);
			BlogEntry anuncioResumido = new BlogEntry(anuncio.getId(),
					anuncio.getNombre(), anuncio.getTitulo(), summary,
					anuncio.getNumComments());
			aux.add(anuncioResumido);
		}
		return aux;
	}

	public static Set<String> getBlogUsers(Iterable<BlogEntry> aux, Iterable<Comments> aux2) {
		
		//convertirlo a List using guava as suggested: http://tinyurl.com/Iterabledoubt
		ArrayList<BlogEntry> anuncios = Lists.newArrayList(aux);
		ArrayList<Comments> comentarios = Lists.newArrayList(aux2);
		
		ArrayList<String> userList = new ArrayList<String>();
		for (BlogEntry anuncio : anuncios) {
			userList.add(anuncio.getNombre());
		}			 
		
		for (Comments comment : comentarios) {
			userList.add(comment.getNombre());
		}
		
		Set<String> userSet = new HashSet<>(userList);//returns unique elements from two lists as explained at
		//http://stackoverflow.com/questions/1429860/easiest-way-to-convert-a-list-to-a-set-java			
		return userSet;
	}
	
	/*Useful webs:
	 * 
	 * http://stackoverflow.com/questions/22794057/thymeleaf-send-parameter-from-html-to-controller
	 * http://stackoverflow.com/questions/25027801/how-to-set-thymeleaf-thfield-value-from-other-variable
	 */

}
