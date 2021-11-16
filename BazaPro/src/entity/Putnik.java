package entity;

import java.io.Serializable;

public class Putnik extends Osoba {
	private Integer putnikID;
	private String pasos;

	public Putnik() {
		super();
	}

	public Putnik(String ime, String prezime, String jmb, String pasos) {
		super(ime, prezime, jmb);
		this.pasos=pasos;
	}

	public Putnik(int osobaID, String ime, String prezime, String jmb, String pasos) {
		super(osobaID, ime, prezime, jmb);
		this.pasos = pasos;
	}

	public Putnik(Integer putnikID, String pasos) {
		super();
		this.putnikID = putnikID;
		this.pasos = pasos;
	}

	public Integer getPutnikID() {
		return putnikID;
	}

	public void setPutnikID(Integer putnikID) {
		this.putnikID = putnikID;
	}

	public String getPasos() {
		return pasos;
	}

	public void setPasos(String pasos) {
		this.pasos = pasos;
	}

}
