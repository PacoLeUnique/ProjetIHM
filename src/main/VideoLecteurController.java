package main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Thread;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
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
	@FXML private Slider volumeBar;
	
	private Timer timer = new Timer();
	private MediaPlayer mediaPlayer;
	private File file;
	private Media media;
	private Duration videoLength;
	private boolean isMouseOnProgressBar;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		file = new File("videos/logobi.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		isMouseOnProgressBar = false;
		
		
		// On patiente 2,5 secondes, le temps de laisser tout le fichier FXML s'initialiser correctement
		try { Thread.sleep(2500); } catch (InterruptedException e1) {	}
		
		progressBar.setOnMouseMoved(e -> mouseOnProgressBarMoved(progressBar, e));
		progressBar.setOnMouseEntered(e -> mouseOnProgressBarEntered(progressBar, e));
		progressBar.setOnMouseExited(e -> mouseOnProgressBarExited(progressBar, e));
		progressBar.setOnMouseClicked(e -> mouseOnProgressBarClicked(progressBar, e));
		
		mediaView.setOnMouseClicked(e -> {
			
			switch(mediaPlayer.getStatus()) {
			case STOPPED:
				mediaPlayer.play();
				break;
			case PAUSED:
				mediaPlayer.play();
				break;
			case PLAYING:
				mediaPlayer.pause();
				break;
				
			default:
				mediaPlayer.pause();
				break;
			}
		});
		
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
				if(!isMouseOnProgressBar) {
					progressBar.setProgress(ratio);
				}
					
				progressTimer.setText(toTimecode(timecode));
				
			}
		} , 500, 500);
		
	}
	
	private void mouseOnProgressBarClicked(ProgressBar pb, MouseEvent e) {
		// TODO enculé de ta race
		// Faut que quand ça clique ça aille au bon timecode
		double ratio = getMouseRatioOnProgressBar(pb, e);
		double d = videoLength.toMinutes()*ratio;
		Duration new_timecode = Duration.minutes(d);
		
		mediaPlayer.seek(new_timecode);
		System.out.println("CLICK");
	}

	private void mouseOnProgressBarEntered(ProgressBar pb, MouseEvent e) {
		slidingProgressTimer.setVisible(true);
		isMouseOnProgressBar = true;
	}
	
	private void mouseOnProgressBarExited(ProgressBar pb, MouseEvent e) {
		slidingProgressTimer.setVisible(false);
		
		Duration timecode = mediaPlayer.getCurrentTime();
		
		System.out.println("ON SORT");
		double ratio = timecode.toMinutes()/videoLength.toMinutes();
		progressBar.setProgress(ratio);
		
		isMouseOnProgressBar = false;
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
		progressBar.setProgress(ratio);
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
	
	@FXML
	public void changeVolume() {
		mediaPlayer.setVolume(volumeBar.getValue()/100);
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
