package main;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class View extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println("FIRST");

		
		AnchorPane anchorPane = (AnchorPane)FXMLLoader.load(getClass().getResource("VideoLecteurFXML.fxml"));
		
		System.out.println("DEUX");
		Scene scene = new Scene(anchorPane,800,600);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Example video player");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

