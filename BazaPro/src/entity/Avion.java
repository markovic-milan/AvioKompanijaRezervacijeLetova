package entity;

import java.io.Serializable;

public class Avion implements Serializable {
	private Integer avioID;
	private Integer brojSjedista;
	private String model;
	private String proizvodjac;

	@Override
	public String toString() {
		return proizvodjac + " " + model;
	}

	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avion(Integer avioID, Integer brojSjedista, String model, String proizvodjac) {
		super();
		this.avioID = avioID;
		this.brojSjedista = brojSjedista;
		this.model = model;
		this.proizvodjac = proizvodjac;
	}

	public Integer getAvioID() {
		return avioID;
	}

	public void setAvioID(Integer avioID) {
		this.avioID = avioID;
	}

	public Integer getBrojSjedista() {
		return brojSjedista;
	}

	public void setBrojSjedista(Integer brojSjedista) {
		this.brojSjedista = brojSjedista;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
}
