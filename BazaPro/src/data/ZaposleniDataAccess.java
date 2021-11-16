package data;

import java.util.List;

import entity.Zaposleni;

public interface ZaposleniDataAccess {
	List<Zaposleni> sveOsobe();

	boolean dodajOsobu(Zaposleni o);

	boolean obrisiOsobu(int id);

	boolean azurirajOsobu(Zaposleni o);
}