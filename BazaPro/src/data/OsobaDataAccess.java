package data;

import java.util.List;

import entity.Osoba;

public interface OsobaDataAccess {
	List<Osoba> sveOsobe();

	boolean dodajOsobu(Osoba o);

	boolean obrisiOsobu(int id);

	boolean azurirajOsobu(Osoba o);
}
