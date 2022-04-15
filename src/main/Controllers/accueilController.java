package main.Controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Categorie;
import main.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;

public class accueilController {

    @FXML Label Pseudo1,Pseudo2,Pseudo3,Pseudo4,Pseudo5,Pseudo6,Pseudo7,Pseudo8;
    @FXML Pane Image1,Image2,Image3,Image4,Image5,Image6,Image7,Image8;

    private ArrayList<Categorie> categories;
    private ArrayList<Utilisateur> users;

    public void goto_login1(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(0)); }
    public void goto_login2(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(1)); }
    public void goto_login3(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(2)); }
    public void goto_login4(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(3)); }
    public void goto_login5(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(4)); }
    public void goto_login6(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(5)); }
    public void goto_login7(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(6)); }
    public void goto_login8(MouseEvent mouseEvent) throws IOException { goto_login(mouseEvent, users.get(7)); }

    /** Envoie l'utilisateur sur la bonne page de connexion
     * @param Event l'event qui est recupere
     * @param User l'Utilissateur que l'on cible
     */
    public void goto_login(Event Event, Utilisateur User) throws IOException {

        // On charge le fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/login.fxml"));
        Parent root = loader.load();
        loginController Controller = loader.getController();

        if(User!=null) {
            // On transmet l'utilisateur au controller suivant
            Controller.setUser(User);
            // On transmet le Model
            Controller.sendModel(this.categories, this.users);

            Stage stage = (Stage) ((Node) Event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void sendModel(ArrayList<Categorie> Categories, ArrayList<Utilisateur> Users) {
        this.categories = Categories;
        this.users = Users;
        int nombreUsers = Users.size();
        if(nombreUsers>=1 && Users.get(0)!=null) {
            this.Pseudo1.setText(Users.get(0).getPseudo());
            this.Image1.setBackground(new Background(new BackgroundImage(   Users.get(0).getImage(),
                                                                            BackgroundRepeat.NO_REPEAT,
                                                                            BackgroundRepeat.NO_REPEAT,
                                                                            BackgroundPosition.DEFAULT,
                                                                            BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=2 && Users.get(1)!=null) {
            this.Pseudo2.setText(Users.get(1).getPseudo());
            this.Image2.setBackground(new Background(new BackgroundImage(   Users.get(1).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=3 && Users.get(2)!=null) {
            this.Pseudo3.setText(Users.get(2).getPseudo());
            this.Image3.setBackground(new Background(new BackgroundImage(   Users.get(2).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=4 && Users.get(3)!=null) {
            this.Pseudo4.setText(Users.get(3).getPseudo());
            this.Image4.setBackground(new Background(new BackgroundImage(   Users.get(3).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=5 && Users.get(4)!=null) {
            this.Pseudo5.setText(Users.get(4).getPseudo());
            this.Image5.setBackground(new Background(new BackgroundImage(   Users.get(4).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=6 && Users.get(5)!=null) {
            this.Pseudo6.setText(Users.get(5).getPseudo());
            this.Image6.setBackground(new Background(new BackgroundImage(   Users.get(5).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=7 && Users.get(6)!=null) {
            this.Pseudo7.setText(Users.get(6).getPseudo());
            this.Image7.setBackground(new Background(new BackgroundImage(   Users.get(6).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        if(nombreUsers>=8 && Users.get(7)!=null) {
            this.Pseudo8.setText(Users.get(7).getPseudo());
            this.Image8.setBackground(new Background(new BackgroundImage(   Users.get(7).getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
    }
}
