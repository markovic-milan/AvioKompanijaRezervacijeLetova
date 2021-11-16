package entity;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Osoba implements Serializable {
	public Integer OsobaID;
	public String Ime;
	public String Prezime;
	public String Jmb;

	public Osoba() {
		super();
	}

	public Osoba(Integer osobaID, String ime, String prezime, String jmb) {
		super();
		OsobaID = osobaID;
		Ime = ime;
		Prezime = prezime;
		Jmb = jmb;
	}

	public Osoba(String ime,String prezime, String jmb) {
		this.Ime=ime;
		this.Prezime=prezime;
		this.Jmb=jmb;
	}
	public Integer getOsobaID() {
		return OsobaID;
	}

	public void setOsobaID(Integer osobaID) {
		OsobaID = osobaID;
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
	}

	public String getJmb() {
		return Jmb;
	}

	public void setJmb(String jmb) {
		Jmb = jmb;
	}

	
}
