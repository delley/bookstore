package br.com.froli.bookstore.managedbeans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.froli.bookstore.daos.AuhtorDAO;
import br.com.froli.bookstore.daos.BookDAO;
import br.com.froli.bookstore.infra.MessagesHelper;
import br.com.froli.bookstore.models.Author;
import br.com.froli.bookstore.models.Book;

@Model
public class AdminBooksBean {
	
	private Book product = new Book();
	private List<Integer> selectedAuthorsIds = new ArrayList<>();
	private List<Author> authors = new ArrayList<>();
	
	@Inject
	private BookDAO bookDAO;
	
	@Inject
	private AuhtorDAO authorDAO;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	@Transactional
	public String save() {
		populateBookAuthor();
		bookDAO.save(product);
		
		messagesHelper.addFlash(new FacesMessage("Livro gravado com sucesso"));
		
		return "/livros/lista?faces-redirect=true";
	}

	private void populateBookAuthor() {
		selectedAuthorsIds.stream().map( id -> {
			return new Author(id);
		}).forEach(product::add);
	}

	public Book getProduct() {
		return product;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
 	
	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}

	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}

	@PostConstruct
	public void loadObjects() {
		this.authors = authorDAO.list();
	}
	
}
