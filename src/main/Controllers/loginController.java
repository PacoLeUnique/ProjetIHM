package main.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Categorie;
import main.Utilisateur;


import java.io.IOException;
import java.util.ArrayList;

public class loginController {

    public loginController(){}

    @FXML Label Pseudo;
    @FXML Pane Image;
    @FXML TextField password_field;

    private Utilisateur user;
    private ArrayList<Categorie> categories;
    private ArrayList<Utilisateur> users;

    public void login(ActionEvent actionEvent) {
    }

    public void goto_accueil(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene accueil = new Scene(FXMLLoader.load(getClass().getResource("../FXMLs/accueil.fxml")), 800, 600);
        stage.setScene(accueil);
        stage.show();
    }

    public void setUser(Utilisateur User) {
        this.user = User;
        this.Pseudo.setText(User.getPseudo());
    }

    public void sendModel(ArrayList<Categorie> Categories, ArrayList<Utilisateur> Users) {
        this.categories = Categories;
        this.users = Users;
    }
}
