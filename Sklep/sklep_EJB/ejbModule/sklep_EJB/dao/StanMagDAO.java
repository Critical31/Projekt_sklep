package sklep_EJB.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.*;


/**
 * The persistent class for the stan_mag database table.
 * 
 */
@Entity
@Table(name="stan_mag")
@NamedQuery(name="StanMagDAO.findAll", query="SELECT s FROM StanMagDAO s")

@Stateless
public class StanMagDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String UNIT_NAME = "sklep_EJB";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="przedmiot_id_czesci")
	private int przedmiotIdCzesci;

	private int ilosc;

	//bi-directional many-to-one association to MagazynDAO
	@ManyToOne
	private MagazynDAO magazyn;

	//bi-directional one-to-one association to PrzedmiotDAO
	@OneToOne
	private PrzedmiotDAO przedmiot;

	public StanMagDAO() {
	}

	public int getPrzedmiotIdCzesci() {
		return this.przedmiotIdCzesci;
	}

	public void setPrzedmiotIdCzesci(int przedmiotIdCzesci) {
		this.przedmiotIdCzesci = przedmiotIdCzesci;
	}

	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public MagazynDAO getMagazyn() {
		return this.magazyn;
	}

	public void setMagazyn(MagazynDAO magazyn) {
		this.magazyn = magazyn;
	}

	public PrzedmiotDAO getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(PrzedmiotDAO przedmiot) {
		this.przedmiot = przedmiot;
	}

}