package projekt_encje;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the model database table.
 * 
 */
@Entity
@NamedQuery(name="Model.findAll", query="SELECT m FROM Model m")
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modelu")
	private int idModelu;

	private String generacja;

	private String nazwa;

	private int rocznik;

	//bi-directional many-to-one association to Marka
	@ManyToOne
	private Marka marka;

	//bi-directional many-to-one association to Przedmiot
	@OneToMany(mappedBy="model")
	private List<Przedmiot> przedmiots;

	public Model() {
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

	public Marka getMarka() {
		return this.marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

	public List<Przedmiot> getPrzedmiots() {
		return this.przedmiots;
	}

	public void setPrzedmiots(List<Przedmiot> przedmiots) {
		this.przedmiots = przedmiots;
	}

	public Przedmiot addPrzedmiot(Przedmiot przedmiot) {
		getPrzedmiots().add(przedmiot);
		przedmiot.setModel(this);

		return przedmiot;
	}

	public Przedmiot removePrzedmiot(Przedmiot przedmiot) {
		getPrzedmiots().remove(przedmiot);
		przedmiot.setModel(null);

		return przedmiot;
	}

}