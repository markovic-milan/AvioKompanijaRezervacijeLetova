package data;

import java.util.List;

import entity.Aerodrom;
import javafx.collections.ObservableList;

public interface AerodromDataAccess {
	ObservableList<Aerodrom> sviAerodromi();

	boolean dodajOsobu(Aerodrom o);

	boolean obrisiOsobu(int id);

	boolean azurirajOsobu(Aerodrom o);
}
