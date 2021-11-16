package entity;

public class Sluzbenik extends Zaposleni{
	private Integer sluzbenikID;
	private Poslovnica poslovnicaID;
	
	public Sluzbenik() {
		super();
	}

	public Sluzbenik(Integer sluzbenikID, Poslovnica poslovnicaID) {
		super();
		this.sluzbenikID = sluzbenikID;
		this.poslovnicaID = poslovnicaID;
	}
	
	public Sluzbenik(String ime,String prezime, String jmb) {
		super(ime,prezime,jmb);
	}

	public Integer getSluzbenikID() {
		return sluzbenikID;
	}

	public void setSluzbenikID(Integer sluzbenikID) {
		this.sluzbenikID = sluzbenikID;
	}

	public Poslovnica getPoslovnicaID() {
		return poslovnicaID;
	}

	public void setPoslovnicaID(Poslovnica poslovnicaID) {
		this.poslovnicaID = poslovnicaID;
	}
	
}
