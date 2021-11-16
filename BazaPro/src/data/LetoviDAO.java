package data;

import entity.Let;
import entity.LetView;
import entity.Linija;
import entity.LinijeView;
import javafx.collections.ObservableList;

public interface LetoviDAO {
	ObservableList<LetView> sviLetovi();
	int dodajLet(Let let);
	ObservableList<LetView> sviLetoviSortiraniPoDistanci();
}
