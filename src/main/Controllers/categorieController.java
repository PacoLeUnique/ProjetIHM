package main.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Categorie;
import main.Utilisateur;
import main.Video;

import java.io.IOException;
import java.util.ArrayList;

public class categorieController {

    private ArrayList<Categorie> categories;
    private ArrayList<Utilisateur> users;
    private Utilisateur user;

    public void goto_categorie1(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(0).getVideos()); }
    public void goto_categorie2(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(1).getVideos()); }
    public void goto_categorie3(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(2).getVideos()); }
    public void goto_categorie4(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(3).getVideos()); }
    public void goto_categorie5(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(4).getVideos()); }
    public void goto_categorie6(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(5).getVideos()); }
    public void goto_categorie7(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(6).getVideos()); }
    public void goto_categorie8(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(7).getVideos()); }
    public void goto_categorie9(ActionEvent actionEvent) throws IOException { goto_categorie(actionEvent, this.categories.get(8).getVideos()); }

    public void goto_categorie(ActionEvent actionEvent, ArrayList<Video> Videos) throws IOException {

        // On charge le fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/categorieSelector.fxml"));
        Parent root = loader.load();
        VideoSelectorController Controller = loader.getController();

        if(Videos!=null) {
            // On transmet le Model
            Controller.sendModel(this.categories, this.users, Videos, this.user);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void goto_accueil(ActionEvent actionEvent) throws IOException  {

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

    public void recherche(ActionEvent actionEvent) {    }
    public void trierAZ(ActionEvent actionEvent) {    }
    public void goto_management(ActionEvent actionEvent) {    }

    public void addVideo(ActionEvent actionEvent) {    }

    public void sendModel(ArrayList<Categorie> Categories, ArrayList<Utilisateur> Users, Utilisateur User) {
        this.categories = Categories;
        this.users = Users;
        this.user = User;
    }
}
