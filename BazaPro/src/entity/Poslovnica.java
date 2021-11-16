package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Poslovnica {
	private SimpleIntegerProperty poslovnicaID;
	private SimpleIntegerProperty adresaID;
	private SimpleStringProperty telefon;
	private SimpleStringProperty email;
	private SimpleIntegerProperty avioKompanijaID;

	public Poslovnica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poslovnica(int poslovnicaID, int adresaID, String telefon, String email, int avioKompanijaID) {
		super();
		this.poslovnicaID = new SimpleIntegerProperty(poslovnicaID);
		this.adresaID = new SimpleIntegerProperty(adresaID);
		this.telefon = new SimpleStringProperty(telefon);
		this.email = new SimpleStringProperty(email);
		this.avioKompanijaID = new SimpleIntegerProperty(avioKompanijaID);
	}

	public SimpleIntegerProperty getPoslovnicaID() {
		return poslovnicaID;
	}

	public void setPoslovnicaID(SimpleIntegerProperty poslovnicaID) {
		this.poslovnicaID = poslovnicaID;
	}

	public SimpleIntegerProperty getAdresaID() {
		return adresaID;
	}

	public void setAdresaID(SimpleIntegerProperty adresaID) {
		this.adresaID = adresaID;
	}

	public SimpleStringProperty getTelefon() {
		return telefon;
	}

	public void setTelefon(SimpleStringProperty telefon) {
		this.telefon = telefon;
	}

	public SimpleStringProperty getEmail() {
		return email;
	}

	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}

	public SimpleIntegerProperty getAvioKompanijaID() {
		return avioKompanijaID;
	}

	public void setAvioKompanijaID(SimpleIntegerProperty avioKompanijaID) {
		this.avioKompanijaID = avioKompanijaID;
	}

}
