package br.com.froli.bookstore.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class FacesContextProducer {
	
	@Produces
	@RequestScoped
	public FacesContext get() {
		return FacesContext.getCurrentInstance();
	}
}
