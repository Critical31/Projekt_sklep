package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zamówienie database table.
 * 
 */
@Entity
@Table(name="zamówienie")
@NamedQuery(name="ZamówienieDAO.findAll", query="SELECT z FROM ZamówienieDAO z")
@Stateless
public class ZamówienieDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_zamowienia")
	private int idZamowienia;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int stan;

	@Column(name="użytkownik_id_uzytkownika")
	private int użytkownikIdUzytkownika;

	//bi-directional many-to-one association to PrzedmiotZamówieniaDAO
	@OneToMany(mappedBy="zamówienie")
	private List<PrzedmiotZamówieniaDAO> przedmiotZamówienias;

	public ZamówienieDAO() {
	}

	public int getIdZamowienia() {
		return this.idZamowienia;
	}

	public void setIdZamowienia(int idZamowienia) {
		this.idZamowienia = idZamowienia;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getStan() {
		return this.stan;
	}

	public void setStan(int stan) {
		this.stan = stan;
	}

	public int getUżytkownikIdUzytkownika() {
		return this.użytkownikIdUzytkownika;
	}

	public void setUżytkownikIdUzytkownika(int użytkownikIdUzytkownika) {
		this.użytkownikIdUzytkownika = użytkownikIdUzytkownika;
	}

	public List<PrzedmiotZamówieniaDAO> getPrzedmiotZamówienias() {
		return this.przedmiotZamówienias;
	}

	public void setPrzedmiotZamówienias(List<PrzedmiotZamówieniaDAO> przedmiotZamówienias) {
		this.przedmiotZamówienias = przedmiotZamówienias;
	}

	public PrzedmiotZamówieniaDAO addPrzedmiotZamówienia(PrzedmiotZamówieniaDAO przedmiotZamówienia) {
		getPrzedmiotZamówienias().add(przedmiotZamówienia);
		przedmiotZamówienia.setZamówienie(this);

		return przedmiotZamówienia;
	}

	public PrzedmiotZamówieniaDAO removePrzedmiotZamówienia(PrzedmiotZamówieniaDAO przedmiotZamówienia) {
		getPrzedmiotZamówienias().remove(przedmiotZamówienia);
		przedmiotZamówienia.setZamówienie(null);

		return przedmiotZamówienia;
	}

}