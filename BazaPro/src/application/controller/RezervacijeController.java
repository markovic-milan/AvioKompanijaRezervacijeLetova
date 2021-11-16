package application.controller;

import java.sql.Date;

import data.mysql.RezervacijaDAOImp;
import entity.Klasa;
import entity.Let;
import entity.LinijeView;
import entity.Putnik;
import entity.Rezervacija;
import entity.RezervacijeView;
import entity.Sluzbenik;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RezervacijeController {
	@FXML
	private MenuBar menuBar;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private TableView<RezervacijeView> tableView;
	@FXML
	private Button prikaziButton = new Button();
	@FXML
	private Button rezervisiBTN = new Button();
	@FXML
	private Button resetButton;
	@FXML
	private ChoiceBox<String> klasaBox;
	@FXML
	private Button obrisiRezervaciju = new Button();

	public void setPane(BorderPane pane) {
		pane.setCenter(anchorPane);
	}

	public void init(BorderPane pane) {
		tableView.setEditable(true);
		tableView.setItems(new RezervacijaDAOImp().sveRezeracije());
		obrisiRezervaciju.setOnAction(action -> {
			new RezervacijaDAOImp().obrisi(tableView.getSelectionModel().getSelectedItem().getRezervacijaID());
			prikaziButton.fire();
		});

		resetButton.setOnAction(action -> {
			klasaBox.getSelectionModel().clearSelection();
		});
		klasaBox.getItems().add("Ekonomska");
		klasaBox.getItems().add("Biznis");
		klasaBox.getItems().add("Prva");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<RezervacijeView, String> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("rezervacijaID"));
		column1.setMaxWidth(50);
		column1.setMinWidth(50);

		TableColumn<RezervacijeView, String> column2 = new TableColumn<RezervacijeView, String>("Datum leta");
		column2.setPrefWidth(100);
		column2.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("datumLeta"));

		TableColumn<RezervacijeView, String> column3 = new TableColumn<>("Klasa");
		column3.setPrefWidth(50);
		column3.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("klasa"));

		column3.setCellFactory(TextFieldTableCell.forTableColumn());
		column3.setOnEditCommit((CellEditEvent<RezervacijeView, String> ev) -> {
			RezervacijeView r = tableView.getSelectionModel().getSelectedItem();
			Klasa klasa = new Klasa();
			if (ev.getNewValue().equals("ekonomska")) {
				klasa.setKlasaID(1);
			} else if (ev.getNewValue().equals("biznis")) {
				klasa.setKlasaID(2);
			} else {
				klasa.setKlasaID(3);
			}
			Rezervacija rez = new Rezervacija();
			rez.setKlasaID(klasa);
			rez.setRezervacijaID(r.getRezervacijaID());
			new RezervacijaDAOImp().azuriraj(rez);
		});

		TableColumn<RezervacijeView, String> column4 = new TableColumn<>("Putnik");
		column4.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("putnik"));
		column4.setPrefWidth(100);

		TableColumn<RezervacijeView, String> column5 = new TableColumn<>("Sluzbenik");
		column5.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("sluzbenik"));
		column5.setPrefWidth(100);

		TableColumn<RezervacijeView, String> column6 = new TableColumn<>("Polazi iz");
		column6.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("OdGrad"));
		column6.setPrefWidth(100);

		TableColumn<RezervacijeView, String> column7 = new TableColumn<>("Stize u");
		column7.setCellValueFactory(new PropertyValueFactory<RezervacijeView, String>("DoGrad"));
		column7.setPrefWidth(100);

		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		tableView.getColumns().add(column3);
		tableView.getColumns().add(column4);
		tableView.getColumns().add(column5);
		tableView.getColumns().add(column6);
		tableView.getColumns().add(column7);

		prikaziButton.setOnAction(action -> {
			String klas = klasaBox.getSelectionModel().getSelectedItem();
			if (klas != null) {
				tableView.setItems(new RezervacijaDAOImp().sortiraj(klas.toLowerCase()));
			} else
				tableView.setItems(new RezervacijaDAOImp().sveRezeracije());
		});

		rezervisiBTN.setOnAction(action -> {
			try {
				Stage st = new Stage();
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("/application/view/DodajRezervacijuView.fxml"));
				Parent root = loader.load();
				KreiranjeRezervacijeKontroler controller1 = loader.getController();
				controller1.init(this);

				Scene scene = new Scene(root, 1136, 515);
				st.setTitle("Rezervacija");
				st.setScene(scene);
				st.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void rezervisi(String ime, String prezime, String jmb, String pasos, Date date, int sluzbenikID, int letID) {
		Rezervacija r = new Rezervacija();
		r.setPutnikID(new Putnik(ime, prezime, jmb, pasos));
		r.setDate(date);
		Sluzbenik s = new Sluzbenik();
		s.setOsobaID(sluzbenikID);
		r.setSluzbenikID(s);
		String k = klasaBox.getSelectionModel().getSelectedItem();
		Klasa klasa = new Klasa();
		if ("Ekonomska".equals(k)) {
			klasa.setKlasaID(1);
		} else if ("Biznis".equals(k)) {
			klasa.setKlasaID(2);
		} else {
			klasa.setKlasaID(3);
		}
		r.setKlasaID(klasa);
		Let let = new Let();
		let.setLetID(letID);
		r.setLetID(let);
		new RezervacijaDAOImp().dodaj(r);
	}
}
