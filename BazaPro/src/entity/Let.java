package entity;

import java.io.Serializable;
import java.sql.Date;

public class Let implements Serializable {
	private Integer letID;
	private Integer distanca;
	private Avion avionID;
	private Linija linijaID;
	private Posada posadaID;
	private Date datumLeta;

	public Let() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Let(Integer letID, Integer distanca, Avion avionID, Linija linijaID, Posada posadaID, Date datumLeta) {
		super();
		this.letID = letID;
		this.distanca = distanca;
		this.avionID = avionID;
		this.linijaID = linijaID;
		this.posadaID = posadaID;
		this.datumLeta = datumLeta;
	}

	public Let(Linija linija) {
		this.linijaID = linija;
	}

	public Integer getLetID() {
		return letID;
	}

	public void setLetID(Integer letID) {
		this.letID = letID;
	}

	public Integer getDistanca() {
		return distanca;
	}

	public void setDistanca(Integer distanca) {
		this.distanca = distanca;
	}

	public Avion getAvionID() {
		return avionID;
	}

	public void setAvionID(Avion avionID) {
		this.avionID = avionID;
	}

	public Linija getLinijaID() {
		return linijaID;
	}

	public void setLinijaID(Linija linijaID) {
		this.linijaID = linijaID;
	}

	public Posada getPosadaID() {
		return posadaID;
	}

	public void setPosadaID(Posada posadaID) {
		this.posadaID = posadaID;
	}

	public Date getDatumLeta() {
		return datumLeta;
	}

	public void setDatumLeta(Date datumLeta) {
		this.datumLeta = datumLeta;
	}

}
