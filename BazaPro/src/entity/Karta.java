package entity;

import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Karta {
	private SimpleIntegerProperty kartaID;
	private SimpleDoubleProperty cijena;
	private SimpleIntegerProperty rezervacijaID;
	private SimpleDateFormat datumIzdavanja;
	private SimpleIntegerProperty vrijemeLeta;
	private SimpleIntegerProperty letID;

	public Karta() {
		super();
	}

	public Karta(int kartaID, double cijena, int rezervacijaID, SimpleDateFormat datumIzdavanja, int vrijemeLeta,
			int letID) {
		super();
		this.kartaID = new SimpleIntegerProperty(kartaID);
		this.cijena = new SimpleDoubleProperty(cijena);
		this.rezervacijaID = new SimpleIntegerProperty(rezervacijaID);
		this.datumIzdavanja = datumIzdavanja;
		this.vrijemeLeta = new SimpleIntegerProperty(vrijemeLeta);
		this.letID = new SimpleIntegerProperty(letID);
	}

	public SimpleIntegerProperty getKartaID() {
		return kartaID;
	}

	public void setKartaID(SimpleIntegerProperty kartaID) {
		this.kartaID = kartaID;
	}

	public SimpleDoubleProperty getCijena() {
		return cijena;
	}

	public void setCijena(SimpleDoubleProperty cijena) {
		this.cijena = cijena;
	}

	public SimpleIntegerProperty getRezervacijaID() {
		return rezervacijaID;
	}

	public void setRezervacijaID(SimpleIntegerProperty rezervacijaID) {
		this.rezervacijaID = rezervacijaID;
	}

	public SimpleDateFormat getDatumIzdavanja() {
		return datumIzdavanja;
	}

	public void setDatumIzdavanja(SimpleDateFormat datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}

	public SimpleIntegerProperty getVrijemeLeta() {
		return vrijemeLeta;
	}

	public void setVrijemeLeta(SimpleIntegerProperty vrijemeLeta) {
		this.vrijemeLeta = vrijemeLeta;
	}

	public SimpleIntegerProperty getLetID() {
		return letID;
	}

	public void setLetID(SimpleIntegerProperty letID) {
		this.letID = letID;
	}

	
}
