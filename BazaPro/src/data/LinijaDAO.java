package data;

import java.util.List;

import entity.Linija;
import entity.LinijeView;
import javafx.collections.ObservableList;

public interface LinijaDAO {
	ObservableList<LinijeView> sveLinije();

	int dodajLiniju(Linija o);

	boolean obrisiLiniju(int id);

	boolean azurirajLiniju(Linija o);
}
