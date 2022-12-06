package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;


/**
 * The persistent class for the użytkownik database table.
 * 
 */
@Entity
@Table(name="użytkownik")
@NamedQuery(name="UżytkownikDAO.findAll", query="SELECT u FROM UżytkownikDAO u")
@Stateless
public class UżytkownikDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public UżytkownikDAO() {
	}

}