package application.controller;

import application.Controller;
import data.mysql.LetDAOImp;
import entity.Aerodrom;
import entity.Klasa;
import entity.LetView;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class KreiranjeRezervacijeKontroler {
	@FXML
	private TextField imeTF;

	@FXML
	private TextField prezimeTF;

	@FXML
	private TextField jmbTF;

	@FXML
	private TextField pasosTF;

	@FXML
	private TableView<LetView> tableView;

	@FXML
	private Button kreirajBTN = new Button();

	private RezervacijeController cont;
	private ObservableList<LetView> data = new LetDAOImp().sviLetovi();

	public void init(RezervacijeController c) {
		cont = c;
		Platform.runLater(() -> kreirajBTN.requestFocus());
		LetoviKontroler.setTable(tableView, data);
	}

	@FXML
	void kreirajAction(ActionEvent event) {
		if (tableView.getSelectionModel().getSelectedItem() == null) {
			System.out.println("Selektuj let");
		} else {
			cont.rezervisi(imeTF.getText(), prezimeTF.getText(), jmbTF.getText(), pasosTF.getText(),
					tableView.getSelectionModel().getSelectedItem().getDatumLeta(), 1,
					tableView.getSelectionModel().getSelectedItem().getLetID());
		}
			kreirajBTN.getScene().getWindow().hide();
	}
}
