package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;

public class View extends Application {

	ArrayList<Categorie> Categories = new ArrayList<>();
	ArrayList<Utilisateur> Users = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// On creer un profil Administrateur
		Users.add(new Utilisateur("Admin", Utilisateur.Rang.ADULT, "Admin"));
		// On creer un profil Invite
		Users.add(new Utilisateur("Invité"));

		// On creer la categorie de base (pour les videos sans categorie)
		Categories.add(new Categorie("None"));

		// On charge les fichiers FXML
		// TODO Pane accueil = FXMLLoader.load(getClass().getResource("FXMLs/?????.fxml"));
		// TODO Pane login = FXMLLoader.load(getClass().getResource("FXMLs/?????.fxml"));
		// TODO Pane video_selector = FXMLLoader.load(getClass().getResource("FXMLs/?????.fxml"));
		// TODO Pane manage_users = FXMLLoader.load(getClass().getResource("FXMLs/?????.fxml"));
		// TODO Pane create_user = FXMLLoader.load(getClass().getResource("FXMLs/?????.fxml"));

		Scene lecteur = new Scene(FXMLLoader.load(getClass().getResource("FXMLs/VideoLecteurFXML.fxml")), 800, 600);

		primaryStage.setScene(lecteur);
		primaryStage.setTitle("Projet IHM");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

