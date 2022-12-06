package sklep_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marka database table.
 * 
 */
@Entity
@NamedQuery(name="Marka.findAll", query="SELECT m FROM Marka m")
public class Marka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marki")
	private int idMarki;

	private String kraj;

	private String nazwa;

	//bi-directional many-to-one association to Model
	@OneToMany(mappedBy="marka")
	private List<Model> models;

	public Marka() {
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

	public List<Model> getModels() {
		return this.models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public Model addModel(Model model) {
		getModels().add(model);
		model.setMarka(this);

		return model;
	}

	public Model removeModel(Model model) {
		getModels().remove(model);
		model.setMarka(null);

		return model;
	}

}