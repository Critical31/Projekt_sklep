package projekt_encje;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the przedmiot_zamówienia database table.
 * 
 */
@Entity
@Table(name="przedmiot_zamówienia")
@NamedQuery(name="PrzedmiotZamówienia.findAll", query="SELECT p FROM PrzedmiotZamówienia p")
public class PrzedmiotZamówienia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="przedmiot_id_czesci")
	private int przedmiotIdCzesci;

	private double cena;

	//bi-directional many-to-one association to Przedmiot
	@ManyToOne
	private Przedmiot przedmiot;

	//bi-directional many-to-one association to Zamówienie
	@ManyToOne
	private Zamówienie zamówienie;

	public PrzedmiotZamówienia() {
	}

	public int getPrzedmiotIdCzesci() {
		return this.przedmiotIdCzesci;
	}

	public void setPrzedmiotIdCzesci(int przedmiotIdCzesci) {
		this.przedmiotIdCzesci = przedmiotIdCzesci;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	public Zamówienie getZamówienie() {
		return this.zamówienie;
	}

	public void setZamówienie(Zamówienie zamówienie) {
		this.zamówienie = zamówienie;
	}

}