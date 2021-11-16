package data;

import entity.Rezervacija;
import entity.RezervacijeView;
import javafx.collections.ObservableList;

public interface RezervacijeDataAccess {
	ObservableList<RezervacijeView> sveRezeracije();

	boolean dodaj(Rezervacija r);

	boolean obrisi(int id);

	boolean azuriraj(Rezervacija r);

	ObservableList<RezervacijeView> sortiraj(String klasa);
}
