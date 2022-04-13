package main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Thread;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class VideoLecteurController implements Initializable {
	
	@FXML private MediaView mediaView;
	@FXML private Button playButton, pauseButton, stopButton;
	@FXML private ProgressBar progressBar;
	@FXML private Text progressTimer, videoLengthTimer, slidingProgressTimer;
	
	private Timer timer = new Timer();
	private MediaPlayer mediaPlayer;
	private File file;
	private Media media;
	private Duration videoLength;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		file = new File("videos/test.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		// On patiente 1 demi-seconde, le temps de laisser tout le fichier FXML s'initialiser correctement
		try { Thread.sleep(500); } catch (InterruptedException e1) {	}
		
		progressBar.setOnMouseMoved(e -> mouseOnProgressBarMoved(progressBar, e));
		progressBar.setOnMouseEntered(e -> mouseOnProgressBarEntered(progressBar, e));
		progressBar.setOnMouseExited(e -> mouseOnProgressBarExited(progressBar, e));
		
		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				videoLength = media.getDuration();
				System.out.println("Durée de la vidéo : " + videoLength.toMinutes());
				videoLengthTimer.setText(toTimecode(videoLength));
			}
		});
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				
				Duration timecode = mediaPlayer.getCurrentTime();
				
				System.out.println("1 DEMI SECONDE, timecode : " + timecode);
				double ratio = timecode.toMinutes()/videoLength.toMinutes();
				progressBar.setProgress(ratio);
				
				progressTimer.setText(toTimecode(timecode));
				
			}
		} , 500, 500);
		
	}
	
	private void mouseOnProgressBarEntered(ProgressBar pb, MouseEvent e) {
		slidingProgressTimer.setVisible(true);
	}
	
	private void mouseOnProgressBarExited(ProgressBar pb, MouseEvent e) {
		slidingProgressTimer.setVisible(false);
	}

	private void mouseOnProgressBarMoved(ProgressBar pb, MouseEvent e) {
		double ratio = getMouseRatioOnProgressBar(pb, e);
		double vlength = videoLength.toMinutes();
		
		double xpos = pb.getLayoutX() + pb.getWidth()*ratio;
		
		double t = vlength*ratio;
		Duration d = Duration.minutes(t);
		String timecode = toTimecode(d);
		
		slidingProgressTimer.setLayoutX(xpos);
		slidingProgressTimer.setText(timecode);
		return;
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
		mediaPlayer.stop();
		progressBar.setProgress(0);
	}
	
	private String toTimecode(Duration d) {
		
		String rep = "";
		int s = (int)d.toSeconds();
		
		int sec = s%60;
		int min = (s/60) % 60;
		int hours = (s/60)/ 60;
		
		String strSec = (sec<10)? "0"+Integer.toString(sec) : Integer.toString(sec);
	    String strMin = (min<10)? "0"+Integer.toString(min) : Integer.toString(min);
	    String strHours = (hours<10)? "0"+Integer.toString(hours) : Integer.toString(hours);
		
	    rep = (hours == 0)? strMin+":"+strSec : strHours+":"+strMin+":"+strSec; 
		
		return rep;
	}
	
	private double getMouseRatioOnProgressBar(ProgressBar pb, MouseEvent e){
		
		double length = pb.getWidth();
		double xmouse = e.getX();

		return xmouse/length;
	}
	
}
