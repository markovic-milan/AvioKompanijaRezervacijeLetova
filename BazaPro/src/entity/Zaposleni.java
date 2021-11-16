package entity;

public class Zaposleni extends Osoba {
	public Integer zaposleniID;
	public AvioKompanija avioCompanyID;
	public Adresa adresaID;
	public Nalog nalogID;
	public String strucnaSprema;

	public Zaposleni() {
		super();
	}

	public Zaposleni(int osobaID, String ime, String prezime, String jmb) {
		super(osobaID, ime, prezime, jmb);
	}

	public Zaposleni(String ime, String prezime, String jmb) {
		super(ime,prezime,jmb);
	}

	public Integer getZaposleniID() {
		return zaposleniID;
	}

	public void setZaposleniID(Integer zaposleniID) {
		this.zaposleniID = zaposleniID;
	}

	public AvioKompanija getAvioCompanyID() {
		return avioCompanyID;
	}

	public void setAvioCompanyID(AvioKompanija avioCompanyID) {
		this.avioCompanyID = avioCompanyID;
	}

	public Adresa getAdresaID() {
		return adresaID;
	}

	public void setAdresaID(Adresa adresaID) {
		this.adresaID = adresaID;
	}

	public Nalog getNalogID() {
		return nalogID;
	}

	public void setNalogID(Nalog nalogID) {
		this.nalogID = nalogID;
	}

	public String getStrucnaSprema() {
		return strucnaSprema;
	}

	public void setStrucnaSprema(String strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}
	
	

}
