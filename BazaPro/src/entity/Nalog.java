package entity;

import java.io.Serializable;

public class Nalog implements Serializable {
	private Integer nalogID;
	private String korisnickaSifra;
	private String username;

	public Nalog(Integer nalogID, String korisnickaSifra, String username) {
		super();
		this.nalogID = nalogID;
		this.korisnickaSifra = korisnickaSifra;
		this.username = username;
	}

	public Nalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getNalogID() {
		return nalogID;
	}

	public void setNalogID(Integer nalogID) {
		this.nalogID = nalogID;
	}

	public String getKorisnickaSifra() {
		return korisnickaSifra;
	}

	public void setKorisnickaSifra(String korisnickaSifra) {
		this.korisnickaSifra = korisnickaSifra;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
