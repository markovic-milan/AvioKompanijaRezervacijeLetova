package application.controller;

import data.mysql.LinijaDAOImp;
import entity.LinijeView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class OdaberiLinijuKontroler {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private TableView<LinijeView> linijeTableView;

	@FXML
	private Button okButton = new Button();

	public void init() {
		okButton.setOnAction(action -> {
			LinijeView lv = linijeTableView.getSelectionModel().getSelectedItem();
			LetoviKontroler.selectLinija(lv);
			okButton.getScene().getWindow().hide();
		});
		LinijeController.setTable(linijeTableView, new LinijaDAOImp().sveLinije());
	}
}
