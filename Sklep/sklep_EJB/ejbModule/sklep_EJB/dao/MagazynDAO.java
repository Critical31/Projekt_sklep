package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the magazyn database table.
 * 
 */
@Entity
@Table(name="magazyn")
@NamedQuery(name="MagazynDAO.findAll", query="SELECT m FROM MagazynDAO m")

@Stateless
public class MagazynDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
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

	//bi-directional many-to-one association to StanMagDAO
	@OneToMany(mappedBy="magazyn")
	private List<StanMagDAO> stanMags;

	public MagazynDAO() {
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

	public List<StanMagDAO> getStanMags() {
		return this.stanMags;
	}

	public void setStanMags(List<StanMagDAO> stanMags) {
		this.stanMags = stanMags;
	}

	public StanMagDAO addStanMag(StanMagDAO stanMag) {
		getStanMags().add(stanMag);
		stanMag.setMagazyn(this);

		return stanMag;
	}

	public StanMagDAO removeStanMag(StanMagDAO stanMag) {
		getStanMags().remove(stanMag);
		stanMag.setMagazyn(null);

		return stanMag;
	}

}