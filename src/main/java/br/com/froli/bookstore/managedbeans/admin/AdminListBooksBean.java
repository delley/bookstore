package br.com.froli.bookstore.managedbeans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.froli.bookstore.daos.BookDAO;
import br.com.froli.bookstore.models.Book;

@Model
public class AdminListBooksBean {
	
	@Inject
	private BookDAO bookDAO;
	private List<Book> books = new ArrayList<>();
	
	@PostConstruct
	private void loadObjects() {
		this.books = bookDAO.list();
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
