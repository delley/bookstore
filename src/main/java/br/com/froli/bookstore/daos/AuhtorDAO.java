package br.com.froli.bookstore.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.froli.bookstore.models.Author;

public class AuhtorDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Author> list() {
		return manager.createQuery("select a from Author a order by a.name asc", Author.class)
				.getResultList();
	}
}
