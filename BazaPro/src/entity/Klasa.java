package entity;

import java.io.Serializable;

public class Klasa implements Serializable{
	private Integer klasaID;
	private String naziv;

	public Klasa() {
		super();
	}

	public Klasa(String naziv) {
		this.naziv = naziv;
	}

	public Klasa(Integer klasaID, String naziv) {
		super();
		this.klasaID = klasaID;
		this.naziv = naziv;
	}

	public Integer getKlasaID() {
		return klasaID;
	}

	public void setKlasaID(Integer klasaID) {
		this.klasaID = klasaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
