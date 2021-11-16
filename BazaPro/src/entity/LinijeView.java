package entity;

import java.io.Serializable;

public class LinijeView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer linijaID;
	private String vrijemePolaska;
	private String vrijemeDolaska;
	private String odAerodrom;
	private String doAerodrom;

	public LinijeView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinijeView(Integer linijaID, String vrijemePolaska, String vrijemeDolaska, String odAerodrom, String doAerodrom) {
		super();
		this.linijaID = linijaID;
		this.vrijemePolaska = vrijemePolaska;
		this.vrijemeDolaska = vrijemeDolaska;
		this.odAerodrom = odAerodrom;
		this.doAerodrom = doAerodrom;
	}

	public Integer getLinijaID() {
		return linijaID;
	}

	public void setLinijaID(Integer linijaID) {
		this.linijaID = linijaID;
	}

	public String getVrijemePolaska() {
		return vrijemePolaska;
	}

	public void setVrijemePolaska(String vrijemePolaska) {
		this.vrijemePolaska = vrijemePolaska;
	}

	public String getVrijemeDolaska() {
		return vrijemeDolaska;
	}

	public void setVrijemeDolaska(String vrijemeDolaska) {
		this.vrijemeDolaska = vrijemeDolaska;
	}

	public String getOdAerodrom() {
		return odAerodrom;
	}

	public void setOdAerodrom(String odAerodrom) {
		this.odAerodrom = odAerodrom;
	}

	public String getDoAerodrom() {
		return doAerodrom;
	}

	public void setDoAerodrom(String doAerodrom) {
		this.doAerodrom = doAerodrom;
	}

}
