package application.controller;

import java.sql.Time;
import java.time.LocalTime;

import data.mysql.AerodromDataAccessImp;
import data.mysql.LinijaDAOImp;
import data.mysql.RezervacijaDAOImp;
import entity.Aerodrom;
import entity.Klasa;
import entity.Linija;
import entity.LinijeView;
import entity.Rezervacija;
import entity.RezervacijeView;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LinijeController {
	@FXML
	private TableView<LinijeView> linijeTableView;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private ComboBox<String> comboFrom;
	@FXML
	private ComboBox<String> comboTo;
	@FXML
	private Button dodajButton;
	@FXML
	private Button obrisiButton = new Button();
	@FXML
	private Button prikaziButton;
	@FXML
	private TextField polazakSatiTF, polazakMinTF, dolazakSatiTF, dolazakMinTF;
	@FXML
	private Button azurirajBTN = new Button();
	static ObservableList<LinijeView> data = new LinijaDAOImp().sveLinije();

	public void init(BorderPane pane) {
		data = new LinijaDAOImp().sveLinije();
		AerodromDataAccessImp aeroImp = new AerodromDataAccessImp();
		LinijaDAOImp linijaImp = new LinijaDAOImp();

		for (Aerodrom a : aeroImp.sviAerodromi()) {
			comboFrom.getItems().add(a.getNaziv() + ", " + a.getMjesto().getGrad());
			comboTo.getItems().add(a.getNaziv() + ", " + a.getMjesto().getGrad());
		}

		dodajButton.setOnAction(action -> {
			if (comboFrom.getSelectionModel().getSelectedItem() == null
					|| comboTo.getSelectionModel().getSelectedItem() == null || polazakSatiTF.getText() == null
					|| polazakMinTF.getText() == null || dolazakSatiTF.getText() == null
					|| dolazakMinTF.getText() == null) {
				System.out.println("Greska nisu unesena sva polja");
			} else {
				String vrijemePolaska = polazakSatiTF.getText() + ":" + polazakMinTF.getText() + ":00";
				String vrijemeDolaska = dolazakSatiTF.getText() + ":" + dolazakMinTF.getText() + ":00";
				Aerodrom polazni = new Aerodrom(comboFrom.getSelectionModel().getSelectedItem().split(",")[0]);
				Aerodrom dolazni = new Aerodrom(comboTo.getSelectionModel().getSelectedItem().split(",")[0]);
				Linija linija = new Linija(Time.valueOf(vrijemePolaska), Time.valueOf(vrijemeDolaska), polazni,
						dolazni);
				if (linijaImp.dodajLiniju(linija) > 0) {
					// data.add(linija);
					prikaziButton.fire();
				}
			}
		});

		setTable(linijeTableView, data);
		linijeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		linijeTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		prikaziButton.setOnAction(action -> {
			linijeTableView.setItems(new LinijaDAOImp().sveLinije());
		});

		obrisiButton.setOnAction(action -> {
			new LinijaDAOImp().obrisiLiniju(linijeTableView.getSelectionModel().getSelectedItem().getLinijaID());
			prikaziButton.fire();
		});

		azurirajBTN.setOnAction(action -> {
			if (linijeTableView.getSelectionModel().getSelectedItem().getLinijaID() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Prvo selektuj liniju za izmjenu");
				alert.setTitle("Greska");
				alert.showAndWait();
			} else {
				int id = linijeTableView.getSelectionModel().getSelectedItem().getLinijaID();
				try {
					Stage st = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/izmjenaLinije.fxml"));
					Parent root = loader.load();
					AzuriranjeLinijeKontroler controller1 = loader.getController();
					controller1.init(id);

					Scene scene = new Scene(root, 300, 350);
					st.setTitle("Izmjena");
					st.setScene(scene);
					st.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setPane(BorderPane pane) {
		pane.setCenter(anchorPane);
	}

	public void azurirajLiniju(int id, int idOdA, int idDoA, Time odV, Time doV) {
		Aerodrom a = new Aerodrom();
		a.setAerodromID(idOdA);
		Aerodrom a1 = new Aerodrom();
		a1.setAerodromID(idDoA);
		new LinijaDAOImp().azurirajLiniju(new Linija(id, odV, doV, a, a1));
		prikaziButton.fire();
	}

	public static void setTable(TableView<LinijeView> tw, ObservableList<LinijeView> data) {
		TableColumn<LinijeView, String> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory<LinijeView, String>("linijaID"));
		column1.setMaxWidth(50);
		column1.setMinWidth(50);

		TableColumn<LinijeView, String> column2 = new TableColumn<LinijeView, String>("Polijeæe sa");
		column2.setPrefWidth(150);
		column2.setCellValueFactory(new PropertyValueFactory<LinijeView, String>("odAerodrom"));

		TableColumn<LinijeView, String> column3 = new TableColumn<>("Slijeæe na");
		column3.setPrefWidth(150);
		column3.setCellValueFactory(new PropertyValueFactory<LinijeView, String>("doAerodrom"));

		TableColumn<LinijeView, String> column4 = new TableColumn<>("Polazi u");
		column4.setCellValueFactory(new PropertyValueFactory<>("vrijemePolaska"));
		column4.setPrefWidth(150);

		TableColumn<LinijeView, String> column5 = new TableColumn<>("Dolazi u");
		column5.setCellValueFactory(new PropertyValueFactory<>("vrijemeDolaska"));
		column5.setPrefWidth(150);

		tw.getColumns().add(column1);
		tw.getColumns().add(column2);
		tw.getColumns().add(column3);
		tw.getColumns().add(column4);
		tw.getColumns().add(column5);

		tw.setItems(data);
	}
}