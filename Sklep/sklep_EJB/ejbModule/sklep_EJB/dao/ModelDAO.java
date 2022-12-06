package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the model database table.
 * 
 */
@Entity
@Table(name="model")
@NamedQuery(name="ModelDAO.findAll", query="SELECT m FROM ModelDAO m")
@Stateless
public class ModelDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modelu")
	private int idModelu;

	private String generacja;

	private String nazwa;

	private int rocznik;

	//bi-directional many-to-one association to MarkaDAO
	@ManyToOne
	private MarkaDAO marka;

	//bi-directional many-to-one association to PrzedmiotDAO
	@OneToMany(mappedBy="model")
	private List<PrzedmiotDAO> przedmiots;

	public ModelDAO() {
	}

	public int getIdModelu() {
		return this.idModelu;
	}

	public void setIdModelu(int idModelu) {
		this.idModelu = idModelu;
	}

	public String getGeneracja() {
		return this.generacja;
	}

	public void setGeneracja(String generacja) {
		this.generacja = generacja;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getRocznik() {
		return this.rocznik;
	}

	public void setRocznik(int rocznik) {
		this.rocznik = rocznik;
	}

	public MarkaDAO getMarka() {
		return this.marka;
	}

	public void setMarka(MarkaDAO marka) {
		this.marka = marka;
	}

	public List<PrzedmiotDAO> getPrzedmiots() {
		return this.przedmiots;
	}

	public void setPrzedmiots(List<PrzedmiotDAO> przedmiots) {
		this.przedmiots = przedmiots;
	}

	public PrzedmiotDAO addPrzedmiot(PrzedmiotDAO przedmiot) {
		getPrzedmiots().add(przedmiot);
		przedmiot.setModel(this);

		return przedmiot;
	}

	public PrzedmiotDAO removePrzedmiot(PrzedmiotDAO przedmiot) {
		getPrzedmiots().remove(przedmiot);
		przedmiot.setModel(null);

		return przedmiot;
	}

}