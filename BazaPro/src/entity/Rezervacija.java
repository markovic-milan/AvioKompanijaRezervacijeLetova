package entity;

import java.sql.Date;

public class Rezervacija {
	private Putnik putnikID;
	private Date date;
	private Sluzbenik sluzbenikID;
	private Integer rezervacijaID;
	private Klasa klasaID;
	private Let letID;

	public Rezervacija() {
		super();
	}

	public Rezervacija(Putnik putnikID, Date date, Sluzbenik sluzbenikID, Integer rezervacijaID, Klasa klasaID,
			Let letID) {
		super();
		this.putnikID = putnikID;
		this.date = date;
		this.sluzbenikID = sluzbenikID;
		this.rezervacijaID = rezervacijaID;
		this.klasaID = klasaID;
		this.letID = letID;
	}

	public Putnik getPutnikID() {
		return putnikID;
	}

	public void setPutnikID(Putnik putnikID) {
		this.putnikID = putnikID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Sluzbenik getSluzbenikID() {
		return sluzbenikID;
	}

	public void setSluzbenikID(Sluzbenik sluzbenikID) {
		this.sluzbenikID = sluzbenikID;
	}

	public Integer getRezervacijaID() {
		return rezervacijaID;
	}

	public void setRezervacijaID(Integer rezervacijaID) {
		this.rezervacijaID = rezervacijaID;
	}

	public Klasa getKlasaID() {
		return klasaID;
	}

	public void setKlasaID(Klasa klasaID) {
		this.klasaID = klasaID;
	}

	public Let getLetID() {
		return letID;
	}

	public void setLetID(Let letID) {
		this.letID = letID;
	}
}
