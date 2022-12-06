package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;


/**
 * The persistent class for the przedmiot database table.
 * 
 */
@Entity
@Table(name="przedmiot")
@NamedQuery(name="PrzedmiotDAO.findAll", query="SELECT p FROM PrzedmiotDAO p")

@Stateless
public class PrzedmiotDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_czesci")
	private int idCzesci;

	@Column(name="kod_części")
	private int kodCzęści;

	private String nazwa;

	@Column(name="rodzaj_czesci")
	private String rodzajCzesci;

	//bi-directional many-to-one association to ModelDAO
	@ManyToOne
	private ModelDAO model;

	//bi-directional one-to-one association to PrzedmiotZamówieniaDAO
	@OneToOne(mappedBy="przedmiot")
	private PrzedmiotZamówieniaDAO przedmiotZamówienia;

	//bi-directional one-to-one association to StanMagDAO
	@OneToOne(mappedBy="przedmiot")
	private StanMagDAO stanMag;

	public PrzedmiotDAO() {
	}

	public int getIdCzesci() {
		return this.idCzesci;
	}

	public void setIdCzesci(int idCzesci) {
		this.idCzesci = idCzesci;
	}

	public int getKodCzęści() {
		return this.kodCzęści;
	}

	public void setKodCzęści(int kodCzęści) {
		this.kodCzęści = kodCzęści;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getRodzajCzesci() {
		return this.rodzajCzesci;
	}

	public void setRodzajCzesci(String rodzajCzesci) {
		this.rodzajCzesci = rodzajCzesci;
	}

	public ModelDAO getModel() {
		return this.model;
	}

	public void setModel(ModelDAO model) {
		this.model = model;
	}

	public PrzedmiotZamówieniaDAO getPrzedmiotZamówienia() {
		return this.przedmiotZamówienia;
	}

	public void setPrzedmiotZamówienia(PrzedmiotZamówieniaDAO przedmiotZamówienia) {
		this.przedmiotZamówienia = przedmiotZamówienia;
	}

	public StanMagDAO getStanMag() {
		return this.stanMag;
	}

	public void setStanMag(StanMagDAO stanMag) {
		this.stanMag = stanMag;
	}

}