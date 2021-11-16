package entity;

import java.io.Serializable;
import java.sql.Time;

public class Linija implements Serializable {
	private Integer linijaID;
	private Time vrijemePolaska;
	private Time vrijemeDolaska;
	private Aerodrom odAerodrom;
	private Aerodrom doAerodrom;

	public Linija(Integer linijaID, Time vrijemePolaska, Time vrijemeDolaska, Aerodrom odAerodrom,
			Aerodrom doAerodrom) {
		super();
		this.linijaID = linijaID;
		this.vrijemePolaska = vrijemePolaska;
		this.vrijemeDolaska = vrijemeDolaska;
		this.odAerodrom = odAerodrom;
		this.doAerodrom = doAerodrom;
	}

	public Linija(Time vrijemePolaska, Time vrijemeDolaska, Aerodrom odAerodrom, Aerodrom doAerodrom) {
		super();
		this.vrijemePolaska = vrijemePolaska;
		this.vrijemeDolaska = vrijemeDolaska;
		this.odAerodrom = odAerodrom;
		this.doAerodrom = doAerodrom;
	}

	public Linija(Aerodrom odA, Aerodrom doA) {
		this.odAerodrom = odA;
		this.doAerodrom = doA;
	}

	public Linija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getLinijaID() {
		return linijaID;
	}

	public void setLinijaID(Integer linijaID) {
		this.linijaID = linijaID;
	}

	public Time getVrijemePolaska() {
		return vrijemePolaska;
	}

	public void setVrijemePolaska(Time vrijemePolaska) {
		this.vrijemePolaska = vrijemePolaska;
	}

	public Time getVrijemeDolaska() {
		return vrijemeDolaska;
	}

	public void setVrijemeDolaska(Time vrijemeDolaska) {
		this.vrijemeDolaska = vrijemeDolaska;
	}

	public Aerodrom getOdAerodrom() {
		return odAerodrom;
	}

	public void setOdAerodrom(Aerodrom odAerodrom) {
		this.odAerodrom = odAerodrom;
	}

	public Aerodrom getDoAerodrom() {
		return doAerodrom;
	}

	public void setDoAerodrom(Aerodrom doAerodrom) {
		this.doAerodrom = doAerodrom;
	}
}
