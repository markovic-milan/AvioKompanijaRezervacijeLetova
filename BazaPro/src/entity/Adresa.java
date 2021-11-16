package entity;

import java.io.Serializable;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Adresa implements Serializable {
	private Integer adresaID;
	private String drzava;
	private String grad;
	private Integer postanskiBroj;

	public Adresa(String drzava, String grad) {
		super();
		this.drzava = drzava;
		this.grad = grad;
	}

	public Adresa(Integer adresaID, String drzava, String grad, Integer postanskiBroj) {
		super();
		this.adresaID = adresaID;
		this.drzava = drzava;
		this.grad = grad;
		this.postanskiBroj = postanskiBroj;
	}

	
	public Adresa(String grad) {
		this.grad=grad;
	}
	
	public Adresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresa(Integer adresaID) {
		super();
		this.adresaID = adresaID;
	}

	public Integer getAdresaID() {
		return adresaID;
	}

	public void setAdresaID(Integer adresaID) {
		this.adresaID = adresaID;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public Integer getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(Integer postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

}
