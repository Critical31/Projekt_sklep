package sklep_EJB.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.jsf.entities.Person;


/**
 * The persistent class for the użytkownik database table.
 * 
 */

@Stateless
public class UżytkownikDAO {
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	

	public void create(Użytkownik użytkownik) {
		em.persist(użytkownik);
		
	}
	
	public Użytkowkik merge(Użytkownik użytkownik) {
		return em.merge(użytkownik);
	}
	
	public void remove(Użytkownik użytkownik) {
		em.remove(em.merge(użytkownik));
	}
	
	public Użytkownik find(Object id) {
		return em.find(Użytkownik.class, id);
	}
	
}