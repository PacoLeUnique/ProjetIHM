package main.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class VideoSelectorController {

    @FXML

    private ArrayList<Video> videos;
    private ArrayList<Utilisateur> users;

    public void goto_lecteur1(ActionEvent actionEvent) throws IOException  { goto_lecteur(actionEvent, videos.get(0));}
    public void goto_options1(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur2(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options2(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur3(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options3(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur4(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options4(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur5(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options5(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur6(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options6(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur7(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options7(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur8(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options8(ActionEvent actionEvent) throws IOException  {    }
    public void goto_lecteur9(ActionEvent actionEvent) throws IOException  {    }
    public void goto_options9(ActionEvent actionEvent) throws IOException  {    }

    public void goto_options(ActionEvent actionEvent, Video Video) throws IOException {

        // On charge le fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/accueil.fxml"));
        Parent root = loader.load();
        optionController Controller = loader.getController();

        // On transmet le Model
        Controller.sendModel(Video, this.users);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void goto_lecteur(ActionEvent actionEvent, Video Video) throws IOException {

        // On charge le fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/VideoLecteurFXML.fxml"));
        Parent root = loader.load();
        VideoLecteurController Controller = loader.getController();

        // On transmet le Model
        Controller.sendVideo(Video);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }


    public void goto_accueil(ActionEvent actionEvent) throws IOException  {    }
    public void recherche(ActionEvent actionEvent) {    }
    public void trierAZ(ActionEvent actionEvent) {    }
    public void goto_management(ActionEvent actionEvent) {    }
    public void goto_categories(ActionEvent actionEvent) {    }
    public void addVideo(ActionEvent actionEvent) {    }
    public void setPermissions(ActionEvent actionEvent) {    }

    public void sendModel(ArrayList<Video> Videos, ArrayList<Utilisateur> Users) {
        this.videos = Videos;
        this.users = Users;
    }
}
