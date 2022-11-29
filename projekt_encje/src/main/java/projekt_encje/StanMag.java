package projekt_encje;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stan_mag database table.
 * 
 */
@Entity
@Table(name="stan_mag")
@NamedQuery(name="StanMag.findAll", query="SELECT s FROM StanMag s")
public class StanMag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="przedmiot_id_czesci")
	private int przedmiotIdCzesci;

	private int ilosc;

	//bi-directional many-to-one association to Magazyn
	@ManyToOne
	private Magazyn magazyn;

	//bi-directional one-to-one association to Przedmiot
	@OneToOne
	private Przedmiot przedmiot;

	public StanMag() {
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

	public Magazyn getMagazyn() {
		return this.magazyn;
	}

	public void setMagazyn(Magazyn magazyn) {
		this.magazyn = magazyn;
	}

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

}