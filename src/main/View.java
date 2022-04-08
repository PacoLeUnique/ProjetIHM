package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class View extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		HBox h = new HBox();
		
		Scene scene = new Scene(h,600,600);
		stage.setScene(scene);
		
		stage.setTitle("Lecteur video trop cool! :D");
		stage.show();
		
	}

}
