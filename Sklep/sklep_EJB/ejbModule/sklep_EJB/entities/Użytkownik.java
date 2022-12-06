package sklep_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the użytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="Użytkownik.findAll", query="SELECT u FROM Użytkownik u")
public class Użytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	public Użytkownik() {
	}

}