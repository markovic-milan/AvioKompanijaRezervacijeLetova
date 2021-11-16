package entity;

import java.io.Serializable;

public class RezervacijeView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer rezervacijaID;
	private String datumLeta;
	private String klasa;
	private String putnik;
	private Integer putnikID;
	private String sluzbenik;
	private String odGrad;
	private String doGrad;

	public RezervacijeView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RezervacijeView(Integer rezervacijaID, String datumLeta, String klasa, String putnik, String sluzbenik,
			String odGrad, String doGrad, int putnikID) {
		super();
		this.putnikID=putnikID;
		this.rezervacijaID = rezervacijaID;
		this.datumLeta = datumLeta;
		this.klasa = klasa;
		this.putnik = putnik;
		this.sluzbenik = sluzbenik;
		this.odGrad = odGrad;
		this.doGrad = doGrad;
	}

	public Integer getRezervacijaID() {
		return rezervacijaID;
	}

	public void setRezervacijaID(Integer rezervacijaID) {
		this.rezervacijaID = rezervacijaID;
	}

	public String getDatumLeta() {
		return datumLeta;
	}

	public void setDatumLeta(String datumLeta) {
		this.datumLeta = datumLeta;
	}

	public String getKlasa() {
		return klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}

	public String getPutnik() {
		return putnik;
	}

	public void setPutnik(String putnik) {
		this.putnik = putnik;
	}

	public String getSluzbenik() {
		return sluzbenik;
	}

	public void setSluzbenik(String sluzbenik) {
		this.sluzbenik = sluzbenik;
	}

	public String getOdGrad() {
		return odGrad;
	}

	public void setOdGrad(String odGrad) {
		this.odGrad = odGrad;
	}

	public String getDoGrad() {
		return doGrad;
	}

	public void setDoGrad(String doGrad) {
		this.doGrad = doGrad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getPutnikID() {
		return putnikID;
	}

	public void setPutnikID(Integer putnikID) {
		this.putnikID = putnikID;
	}
}
