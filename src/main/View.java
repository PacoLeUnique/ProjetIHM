package main;

import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.Group;
import javafx.scene.Scene;


public class View extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		String videoPath = "C:\\Users\\mouge\\Documents\\Cours\\S6\\IHM\\test.mp4";
		String videoFileURIStr = new File(videoPath).toURI().toString();
		
		//Instantiating Media class
		Media media = new Media(videoFileURIStr);
		//Media media = new Media("");
		
		//Instantiating MediaPlayer class
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		//Instantiating MediaView class
		MediaView mediaView = new MediaView(mediaPlayer);
		//by setting this property to true, the Video will be played
		mediaPlayer.setAutoPlay(true);
		
		
		//Setting group and scene
		Group root = new Group();
		root.getChildren().add(mediaView);
		Scene scene = new Scene(root,500,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Example video player");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
