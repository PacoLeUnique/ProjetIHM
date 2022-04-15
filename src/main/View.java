package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import main.Controllers.accueilController;

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

		// On charge le fichier FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/accueil.fxml"));
		Parent root = loader.load();

		// On envoie les donnees au Controller
		accueilController Controller = loader.getController();
		Controller.sendModel(this.Categories, this.Users);

		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Projet IHM");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

