package sklep_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the przedmiot database table.
 * 
 */
@Entity
@NamedQuery(name="Przedmiot.findAll", query="SELECT p FROM Przedmiot p")
public class Przedmiot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_czesci")
	private int idCzesci;

	@Column(name="kod_części")
	private int kodCzęści;

	private String nazwa;

	@Column(name="rodzaj_czesci")
	private String rodzajCzesci;

	//bi-directional many-to-one association to Model
	@ManyToOne
	private Model model;

	//bi-directional one-to-one association to PrzedmiotZamówienia
	@OneToOne(mappedBy="przedmiot")
	private PrzedmiotZamówienia przedmiotZamówienia;

	//bi-directional one-to-one association to StanMag
	@OneToOne(mappedBy="przedmiot")
	private StanMag stanMag;

	public Przedmiot() {
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

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public PrzedmiotZamówienia getPrzedmiotZamówienia() {
		return this.przedmiotZamówienia;
	}

	public void setPrzedmiotZamówienia(PrzedmiotZamówienia przedmiotZamówienia) {
		this.przedmiotZamówienia = przedmiotZamówienia;
	}

	public StanMag getStanMag() {
		return this.stanMag;
	}

	public void setStanMag(StanMag stanMag) {
		this.stanMag = stanMag;
	}

}