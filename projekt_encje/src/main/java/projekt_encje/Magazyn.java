package projekt_encje;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the magazyn database table.
 * 
 */
@Entity
@NamedQuery(name="Magazyn.findAll", query="SELECT m FROM Magazyn m")
public class Magazyn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_magazynu")
	private int idMagazynu;

	@Column(name="kod_pocztowy")
	private String kodPocztowy;

	private String miasto;

	@Column(name="numer_budynku")
	private String numerBudynku;

	private String ulica;

	//bi-directional many-to-one association to StanMag
	@OneToMany(mappedBy="magazyn")
	private List<StanMag> stanMags;

	public Magazyn() {
	}

	public int getIdMagazynu() {
		return this.idMagazynu;
	}

	public void setIdMagazynu(int idMagazynu) {
		this.idMagazynu = idMagazynu;
	}

	public String getKodPocztowy() {
		return this.kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getNumerBudynku() {
		return this.numerBudynku;
	}

	public void setNumerBudynku(String numerBudynku) {
		this.numerBudynku = numerBudynku;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public List<StanMag> getStanMags() {
		return this.stanMags;
	}

	public void setStanMags(List<StanMag> stanMags) {
		this.stanMags = stanMags;
	}

	public StanMag addStanMag(StanMag stanMag) {
		getStanMags().add(stanMag);
		stanMag.setMagazyn(this);

		return stanMag;
	}

	public StanMag removeStanMag(StanMag stanMag) {
		getStanMags().remove(stanMag);
		stanMag.setMagazyn(null);

		return stanMag;
	}

}