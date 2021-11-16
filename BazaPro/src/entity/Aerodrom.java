package entity;

import java.io.Serializable;

public class Aerodrom implements Serializable {
	private Integer AerodromID;
	private String Naziv;
	private Adresa Mjesto;

	@Override
	public String toString() {
		return Naziv + ", " + Mjesto.getGrad();
	}

	public Aerodrom() {
		super();
	}
	
	public Aerodrom(Adresa a) {
		this.Mjesto=a;
	}

	public Aerodrom(Integer AerodromID, String Naziv, Adresa Mjesto) {
		super();
		this.AerodromID = AerodromID;
		this.Naziv = Naziv;
		this.Mjesto = Mjesto;
	}

	public Aerodrom(Integer aerodromID) {
		super();
		this.AerodromID = aerodromID;
	}

	public Aerodrom(String Naziv) {
		super();
		this.Naziv = Naziv;
	}

	public Integer getAerodromID() {
		return AerodromID;
	}

	public void setAerodromID(Integer aerodromID) {
		this.AerodromID = aerodromID;
	}

	public String getNaziv() {
		return Naziv;
	}

	public void setNaziv(String naziv) {
		this.Naziv = naziv;
	}

	public Adresa getMjesto() {
		return Mjesto;
	}

	public void setMjesto(Adresa mjesto) {
		this.Mjesto = mjesto;
	}

}
