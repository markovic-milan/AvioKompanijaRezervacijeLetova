package application;

import java.io.IOException;

import application.controller.LetoviKontroler;
import application.controller.LinijeController;
import application.controller.RezervacijeController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Controller {
	@FXML
	private Text text;
	@FXML
	private MenuBar menuBar;
	@FXML
	private BorderPane borderPane;
	private boolean linijeSelected = false;
	private boolean rezervacijeSelected = false;
	private boolean letoviSelected = false;

	public void init() {
		borderPane.setTop(menuBar);
		Label labelZatvori = new Label("Exit");
		labelZatvori.setStyle("-fx-text-fill: white");
		labelZatvori.setFont(new Font(15));
		labelZatvori.setOnMouseClicked(action -> menuBar.getScene().getWindow().hide());
		Menu menuZatvori = new Menu("", labelZatvori);
		menuBar.getMenus().add(menuZatvori);

		Label rezervacijeLabel = new Label("Rezervacije");
		Menu rezervacije = new Menu("", rezervacijeLabel);
		rezervacijeLabel.setStyle("-fx-text-fill: white");
		rezervacijeLabel.setFont(new Font(15));
		menuBar.getMenus().add(rezervacije);

		Label linijeLabel = new Label("Linije");
		Menu linije = new Menu("", linijeLabel);
		linijeLabel.setStyle("-fx-text-fill: white");
		linijeLabel.setFont(new Font(15));
		menuBar.getMenus().add(linije);

		Label labelLetovi = new Label("Letovi");
		Menu letovi = new Menu("", labelLetovi);
		labelLetovi.setStyle("-fx-text-fill: white");
		labelLetovi.setFont(new Font(15));
		menuBar.getMenus().add(letovi);

		try {
			FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/application/view/LinijeView.fxml"));
			Parent root1 = loader1.load();
			LinijeController controller1 = loader1.getController();
			controller1.init(borderPane);

			linijeLabel.setOnMouseClicked(action -> {
				linijeSelected = true;
				if (rezervacijeSelected || letoviSelected) {
					rezervacije.setStyle("-fx-background-color: #1a2738");
					rezervacijeSelected = false;
					letovi.setStyle("-fx-background-color: #1a2738");
					letoviSelected = false;
				}
				linije.setStyle("-fx-background-color: #626870");
				text.setVisible(false);
				Platform.runLater(() -> controller1.setPane(borderPane));
			});

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/RezervacijeView.fxml"));
			Parent root = loader.load();
			RezervacijeController controller = loader.getController();
			controller.init(borderPane);

			rezervacijeLabel.setOnMouseClicked(action -> {
				rezervacijeSelected = true;
				if (linijeSelected || letoviSelected) {
					linije.setStyle("-fx-background-color: #1a2738");
					letovi.setStyle("-fx-background-color: #1a2738");
					letoviSelected = false;
					linijeSelected = false;
				}
				rezervacije.setStyle("-fx-background-color: #626870");
				text.setVisible(false);
				Platform.runLater(() -> controller.setPane(borderPane));
			});

			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/application/view/Letovi.fxml"));
			Parent root3 = loader3.load();
			LetoviKontroler controller3 = loader3.getController();
			controller3.init();

			labelLetovi.setOnMouseClicked(action -> {
				letoviSelected = true;
				if (linijeSelected || rezervacijeSelected) {
					linije.setStyle("-fx-background-color: #1a2738");
					linijeSelected = false;
					rezervacije.setStyle("-fx-background-color: #1a2738");
					rezervacijeSelected = false;
				}
				letovi.setStyle("-fx-background-color: #626870");
				text.setVisible(false);
				Platform.runLater(() -> controller3.setPane(borderPane));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}