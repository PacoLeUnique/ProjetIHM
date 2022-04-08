package main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class VideoLecteurController implements Initializable {
	
	@FXML private MediaView mediaView;
	@FXML private Button playButton, pauseButton, stopButton;
	@FXML private ProgressBar progressBar;
	
	
	private Timer timer = new Timer();
	private MediaPlayer mediaPlayer;
	private File file;
	private Media media;
	private Duration videoLength;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		file = new File("test.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		videoLength = mediaPlayer.getStopTime();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				Duration timecode = mediaPlayer.getCurrentTime();
				
				System.out.println("1 DEMI SECONDE, timecode : " + timecode);
			}
		} , 500, 500);
		
	}
	
	@FXML
	public void playVideo() {
		mediaPlayer.play();
	}
	
	@FXML
	public void pauseVideo() {
		mediaPlayer.pause();
	}
	
	@FXML
	public void stopVideo() {
		mediaPlayer.pause();
	}
	
}
