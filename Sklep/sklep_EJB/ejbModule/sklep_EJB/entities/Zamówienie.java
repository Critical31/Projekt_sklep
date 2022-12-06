package sklep_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zamówienie database table.
 * 
 */
@Entity
@NamedQuery(name="Zamówienie.findAll", query="SELECT z FROM Zamówienie z")
public class Zamówienie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_zamowienia")
	private int idZamowienia;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int stan;

	@Column(name="użytkownik_id_uzytkownika")
	private int użytkownikIdUzytkownika;

	//bi-directional many-to-one association to PrzedmiotZamówienia
	@OneToMany(mappedBy="zamówienie")
	private List<PrzedmiotZamówienia> przedmiotZamówienias;

	public Zamówienie() {
	}

	public int getIdZamowienia() {
		return this.idZamowienia;
	}

	public void setIdZamowienia(int idZamowienia) {
		this.idZamowienia = idZamowienia;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getStan() {
		return this.stan;
	}

	public void setStan(int stan) {
		this.stan = stan;
	}

	public int getUżytkownikIdUzytkownika() {
		return this.użytkownikIdUzytkownika;
	}

	public void setUżytkownikIdUzytkownika(int użytkownikIdUzytkownika) {
		this.użytkownikIdUzytkownika = użytkownikIdUzytkownika;
	}

	public List<PrzedmiotZamówienia> getPrzedmiotZamówienias() {
		return this.przedmiotZamówienias;
	}

	public void setPrzedmiotZamówienias(List<PrzedmiotZamówienia> przedmiotZamówienias) {
		this.przedmiotZamówienias = przedmiotZamówienias;
	}

	public PrzedmiotZamówienia addPrzedmiotZamówienia(PrzedmiotZamówienia przedmiotZamówienia) {
		getPrzedmiotZamówienias().add(przedmiotZamówienia);
		przedmiotZamówienia.setZamówienie(this);

		return przedmiotZamówienia;
	}

	public PrzedmiotZamówienia removePrzedmiotZamówienia(PrzedmiotZamówienia przedmiotZamówienia) {
		getPrzedmiotZamówienias().remove(przedmiotZamówienia);
		przedmiotZamówienia.setZamówienie(null);

		return przedmiotZamówienia;
	}

}