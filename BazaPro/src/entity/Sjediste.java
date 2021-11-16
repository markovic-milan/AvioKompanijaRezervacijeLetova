package entity;

import javafx.beans.property.SimpleIntegerProperty;

public class Sjediste {
	private SimpleIntegerProperty brojSjedista;
	private SimpleIntegerProperty klasaID;
	private SimpleIntegerProperty avioID;

	public Sjediste() {
		super();
	}

	public Sjediste(int brojSjedista, int klasaID, int avioID) {
		super();
		this.brojSjedista = new SimpleIntegerProperty(brojSjedista);
		this.klasaID = new SimpleIntegerProperty(klasaID);
		this.avioID = new SimpleIntegerProperty(avioID);
	}

	public SimpleIntegerProperty getBrojSjedista() {
		return brojSjedista;
	}

	public void setBrojSjedista(SimpleIntegerProperty brojSjedista) {
		this.brojSjedista = brojSjedista;
	}

	public SimpleIntegerProperty getKlasaID() {
		return klasaID;
	}

	public void setKlasaID(SimpleIntegerProperty klasaID) {
		this.klasaID = klasaID;
	}

	public SimpleIntegerProperty getAvioID() {
		return avioID;
	}

	public void setAvioID(SimpleIntegerProperty avioID) {
		this.avioID = avioID;
	}

}
