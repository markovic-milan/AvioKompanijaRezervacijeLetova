package entity;

import java.io.Serializable;

public class Posada implements Serializable {
	private Integer posadaID;
	private Integer brojClanova;

	public Posada() {
		super();
	}

	public Posada(Integer posadaID, Integer brojClanova) {
		super();
		this.posadaID = posadaID;
		this.brojClanova = brojClanova;
	}

	public Integer getPosadaID() {
		return posadaID;
	}

	public void setPosadaID(Integer posadaID) {
		this.posadaID = posadaID;
	}

	public Integer getBrojClanova() {
		return brojClanova;
	}

	public void setBrojClanova(Integer brojClanova) {
		this.brojClanova = brojClanova;
	}

}
