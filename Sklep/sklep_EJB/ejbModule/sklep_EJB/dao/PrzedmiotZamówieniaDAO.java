package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;


/**
 * The persistent class for the przedmiot_zamówienia database table.
 * 
 */
@Entity
@Table(name="przedmiot_zamówienia")
@NamedQuery(name="PrzedmiotZamówieniaDAO.findAll", query="SELECT p FROM PrzedmiotZamówieniaDAO p")

@Stateless
public class PrzedmiotZamówieniaDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="przedmiot_id_czesci")
	private int przedmiotIdCzesci;

	private double cena;

	//bi-directional one-to-one association to PrzedmiotDAO
	@OneToOne
	private PrzedmiotDAO przedmiot;

	//bi-directional many-to-one association to ZamówienieDAO
	@ManyToOne
	private ZamówienieDAO zamówienie;

	public PrzedmiotZamówieniaDAO() {
	}

	public int getPrzedmiotIdCzesci() {
		return this.przedmiotIdCzesci;
	}

	public void setPrzedmiotIdCzesci(int przedmiotIdCzesci) {
		this.przedmiotIdCzesci = przedmiotIdCzesci;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public PrzedmiotDAO getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(PrzedmiotDAO przedmiot) {
		this.przedmiot = przedmiot;
	}

	public ZamówienieDAO getZamówienie() {
		return this.zamówienie;
	}

	public void setZamówienie(ZamówienieDAO zamówienie) {
		this.zamówienie = zamówienie;
	}

}