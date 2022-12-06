package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marka database table.
 * 
 */
@Entity
@Table(name="marka")
@NamedQuery(name="MarkaDAO.findAll", query="SELECT m FROM MarkaDAO m")

@Stateless
public class MarkaDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marki")
	private int idMarki;

	private String kraj;

	private String nazwa;

	//bi-directional many-to-one association to ModelDAO
	@OneToMany(mappedBy="marka")
	private List<ModelDAO> models;

	public MarkaDAO() {
	}

	public int getIdMarki() {
		return this.idMarki;
	}

	public void setIdMarki(int idMarki) {
		this.idMarki = idMarki;
	}

	public String getKraj() {
		return this.kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ModelDAO> getModels() {
		return this.models;
	}

	public void setModels(List<ModelDAO> models) {
		this.models = models;
	}

	public ModelDAO addModel(ModelDAO model) {
		getModels().add(model);
		model.setMarka(this);

		return model;
	}

	public ModelDAO removeModel(ModelDAO model) {
		getModels().remove(model);
		model.setMarka(null);

		return model;
	}

}