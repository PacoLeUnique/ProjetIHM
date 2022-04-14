package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;

public class View extends Application {

	ArrayList<Categorie> Categories = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Categories.add(new Categorie("None"));
		
		Pane pane = FXMLLoader.load(getClass().getResource("FXMLs/VideoLecteurFXML.fxml"));

		Scene scene = new Scene(pane,800,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Projet IHM");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

