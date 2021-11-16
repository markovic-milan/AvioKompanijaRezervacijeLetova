package entity;

import java.io.Serializable;
import java.sql.Date;

public class LetView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer letID;
	private Integer distanca;
	private String modelAviona;
	private String linijaLeta;
	private Integer posadaID;
	private Date datumLeta;
	private Integer brojPutnika;

	public LetView(Integer letID, Integer distanca, String modelAviona, String linijaLeta, Integer posadaID,
			Date datumLeta, Integer brojPutnika) {
		super();
		this.letID = letID;
		this.distanca = distanca;
		this.modelAviona = modelAviona;
		this.linijaLeta = linijaLeta;
		this.posadaID = posadaID;
		this.datumLeta = datumLeta;
		this.setBrojPutnika(brojPutnika);
	}

	public LetView() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getModelAviona() {
		return modelAviona;
	}

	public void setModelAviona(String modelAviona) {
		this.modelAviona = modelAviona;
	}

	public String getLinijaLeta() {
		return linijaLeta;
	}

	public void setLinijaLeta(String linijaLeta) {
		this.linijaLeta = linijaLeta;
	}

	public Integer getPosadaID() {
		return posadaID;
	}

	public void setPosadaID(Integer posadaID) {
		this.posadaID = posadaID;
	}

	public Date getDatumLeta() {
		return datumLeta;
	}

	public void setDatumLeta(Date datumLeta) {
		this.datumLeta = datumLeta;
	}

	public Integer getBrojPutnika() {
		return brojPutnika;
	}

	public void setBrojPutnika(Integer brojPutnika) {
		this.brojPutnika = brojPutnika;
	}

}
