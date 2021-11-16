package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AvioKompanija {
	private SimpleIntegerProperty avioKompanijaID;
	private SimpleIntegerProperty brojPoslovnica;
	private SimpleIntegerProperty brojZaposlenih;
	private SimpleStringProperty naziv;
	private SimpleIntegerProperty adresaID;

	public AvioKompanija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AvioKompanija(int avioKompanijaID, int brojPoslovnica, int brojZaposlenih, String naziv, int adresaID) {
		super();
		this.avioKompanijaID = new SimpleIntegerProperty(avioKompanijaID);
		this.brojPoslovnica = new SimpleIntegerProperty(brojPoslovnica);
		this.brojZaposlenih = new SimpleIntegerProperty(brojZaposlenih);
		this.naziv = new SimpleStringProperty(naziv);
		this.adresaID = new SimpleIntegerProperty(adresaID);
	}

	public SimpleIntegerProperty getAvioKompanijaID() {
		return avioKompanijaID;
	}

	public void setAvioKompanijaID(SimpleIntegerProperty avioKompanijaID) {
		this.avioKompanijaID = avioKompanijaID;
	}

	public SimpleIntegerProperty getBrojPoslovnica() {
		return brojPoslovnica;
	}

	public void setBrojPoslovnica(SimpleIntegerProperty brojPoslovnica) {
		this.brojPoslovnica = brojPoslovnica;
	}

	public SimpleIntegerProperty getBrojZaposlenih() {
		return brojZaposlenih;
	}

	public void setBrojZaposlenih(SimpleIntegerProperty brojZaposlenih) {
		this.brojZaposlenih = brojZaposlenih;
	}

	public SimpleStringProperty getNaziv() {
		return naziv;
	}

	public void setNaziv(SimpleStringProperty naziv) {
		this.naziv = naziv;
	}

	public SimpleIntegerProperty getAdresaID() {
		return adresaID;
	}

	public void setAdresaID(SimpleIntegerProperty adresaID) {
		this.adresaID = adresaID;
	}
	
	

}
