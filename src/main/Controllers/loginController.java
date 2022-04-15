package main.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Categorie;
import main.Utilisateur;


import java.io.IOException;
import java.util.ArrayList;

public class loginController {

    @FXML Label Pseudo;
    @FXML Pane Image;
    @FXML TextField password_field;

    private Utilisateur user;
    private ArrayList<Categorie> categories;
    private ArrayList<Utilisateur> users;

    public void login(ActionEvent actionEvent) {
    }

    public void goto_accueil(ActionEvent actionEvent) throws IOException {

        // On charge le fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/accueil.fxml"));
        Parent root = loader.load();
        accueilController Controller = loader.getController();

        // On transmet le Model
        Controller.sendModel(this.categories, this.users);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void setUser(Utilisateur User) {
        this.user = User;
        this.Pseudo.setText(User.getPseudo());
        this.Image.setBackground(new Background(new BackgroundImage(   User.getImage(),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
    }

    public void sendModel(ArrayList<Categorie> Categories, ArrayList<Utilisateur> Users) {
        this.categories = Categories;
        this.users = Users;
    }
}
