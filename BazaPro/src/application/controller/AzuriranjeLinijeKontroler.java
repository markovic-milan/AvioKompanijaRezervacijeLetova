package application.controller;

import java.sql.Time;

import data.mysql.AerodromDataAccessImp;
import data.mysql.LinijaDAOImp;
import entity.Aerodrom;
import entity.Linija;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AzuriranjeLinijeKontroler {

	@FXML
	private ComboBox<Aerodrom> comboF;

	@FXML
	private ComboBox<Aerodrom> comboT;

	@FXML
	private TextField vrijemeOd;

	@FXML
	private TextField vrijemeDo;

	@FXML
	private Button azurirajBTN = new Button();

	public void init(int id) {
		for (Aerodrom a : new AerodromDataAccessImp().sviAerodromi()) {
			comboF.getItems().add(a);
			comboT.getItems().add(a);
		}
		azurirajBTN.setOnAction(action -> {
			new LinijeController().azurirajLiniju(id, comboF.getSelectionModel().getSelectedItem().getAerodromID(),
					comboT.getSelectionModel().getSelectedItem().getAerodromID(), Time.valueOf(vrijemeOd.getText()),
					Time.valueOf(vrijemeDo.getText()));
			
			azurirajBTN.getScene().getWindow().hide();
		});
	}
}
