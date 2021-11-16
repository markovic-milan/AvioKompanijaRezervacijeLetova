package application.controller;

import java.sql.Date;
import java.util.Random;

import data.mysql.AvioniDAOImp;
import data.mysql.LetDAOImp;
import data.mysql.RezervacijaDAOImp;
import entity.Avion;
import entity.Let;
import entity.LetView;
import entity.Linija;
import entity.LinijeView;
import entity.Posada;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LetoviKontroler {
	@FXML
	private ComboBox<Avion> avionCB;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Button dodajLetBTN = new Button();

	@FXML
	private TableView<LetView> tableView;

	@FXML
	private Button prikaziButton;

	@FXML
	private Button sortirajBTN = new Button();

	@FXML
	private Button resetButton = new Button();
	private static LinijeView selektovanaLinija;
	static ObservableList<LetView> data = new LetDAOImp().sviLetovi();

	public void setPane(BorderPane pane) {
		pane.setCenter(anchorPane);
	}

	public void init() {
		data = new LetDAOImp().sviLetovi();
		resetButton.setOnAction(aaction -> {
			avionCB.getSelectionModel().clearSelection();
			datePicker.getEditor().clear();
		});

		sortirajBTN.setOnAction(action -> {
			tableView.setItems(new LetDAOImp().sviLetoviSortiraniPoDistanci());
		});

		setTable(tableView, data);
		for (Avion a : new AvioniDAOImp().sviAvioni()) {
			avionCB.getItems().add(a);
		}

		dodajLetBTN.setOnAction(action -> {
			if (selektovanaLinija == null || avionCB.getSelectionModel().getSelectedItem() == null
					|| datePicker.getValue() == null) {
				System.out.println("Greska nisu unesena sva polja");
			} else {
				Let let = new Let();
				Linija linija = new Linija();
				linija.setLinijaID(selektovanaLinija.getLinijaID());
				let.setDistanca(new Random().nextInt(1001) + 2000);
				let.setLinijaID(linija);
				Posada p = new Posada();
				p.setPosadaID(1);
				let.setPosadaID(p);
				Avion av = avionCB.getSelectionModel().getSelectedItem();
				let.setAvionID(av);
				let.setDatumLeta(Date.valueOf(datePicker.getValue()));
				new LetDAOImp().dodajLet(let);
				tableView.setItems(new LetDAOImp().sviLetovi());
			}
		});

		prikaziButton.setOnAction(action -> {
			try {
				Stage st = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/LinijeTable.fxml"));
				Parent root = loader.load();
				OdaberiLinijuKontroler controller1 = loader.getController();
				controller1.init();
				Scene scene = new Scene(root, 690, 480);
				st.setTitle("Odabir linije");
				st.setScene(scene);
				st.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void setTable(TableView<LetView> tw, ObservableList<LetView> data) {
		TableColumn<LetView, String> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory<LetView, String>("letID"));
		column1.setMaxWidth(50);
		column1.setMinWidth(50);

		TableColumn<LetView, String> column2 = new TableColumn<LetView, String>("Distanca [km]");
		column2.setPrefWidth(150);
		column2.setCellValueFactory(new PropertyValueFactory<LetView, String>("distanca"));

		TableColumn<LetView, String> column3 = new TableColumn<>("Model aviona");
		column3.setPrefWidth(150);
		column3.setCellValueFactory(new PropertyValueFactory<LetView, String>("modelAviona"));

		TableColumn<LetView, String> column4 = new TableColumn<>("Linija");
		column4.setCellValueFactory(new PropertyValueFactory<>("linijaLeta"));
		column4.setPrefWidth(150);

		TableColumn<LetView, String> column5 = new TableColumn<>("PosadaID");
		column5.setCellValueFactory(new PropertyValueFactory<>("posadaID"));
		column5.setPrefWidth(150);

		TableColumn<LetView, String> column6 = new TableColumn<>("Datum leta");
		column6.setCellValueFactory(new PropertyValueFactory<>("datumLeta"));
		column6.setPrefWidth(150);

		TableColumn<LetView, String> column7 = new TableColumn<>("Broj putnika");
		column7.setCellValueFactory(new PropertyValueFactory<>("brojPutnika"));
		column7.setPrefWidth(150);

		tw.getColumns().add(column1);
		tw.getColumns().add(column2);
		tw.getColumns().add(column3);
		tw.getColumns().add(column4);
		tw.getColumns().add(column5);
		tw.getColumns().add(column6);
		tw.getColumns().add(column7);
		tw.setItems(data);
	}

	public static void selectLinija(LinijeView lw) {
		selektovanaLinija = lw;
	}
}
