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
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class VideoLecteurController implements Initializable {
	
	@FXML private MediaView mediaView;
	@FXML private Button playButton, pauseButton, stopButton;
	@FXML private ProgressBar progressBar;
	@FXML private Text progressTimer, videoLengthTimer, slidingProgressTimer;
	@FXML private Slider volumeBar;
	@FXML private Circle sliderProgressBar;
	
	private Timer timer = new Timer();
	private MediaPlayer mediaPlayer;
	private File file;
	private Media media;
	private Duration videoLength;
	private boolean isMouseOnProgressBar, isSliderDragged;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		file = new File("videos/logobi.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		isMouseOnProgressBar = false;
		isSliderDragged = false;
		
		
		// On patiente 2,5 secondes, le temps de laisser tout le fichier FXML s'initialiser correctement
		try { Thread.sleep(2500); } catch (InterruptedException e1) {	}
		
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
				System.out.println("Dur�e de la vid�o : " + videoLength.toMinutes());
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
	
	@FXML
	private void mouseOnProgressBarClicked(MouseEvent e) {
		// TODO encul� de ta race
		// Faut que quand �a clique �a aille au bon timecode
		double ratio = getMouseRatioOnProgressBar(progressBar, e);
		double d = videoLength.toMinutes()*ratio;
		Duration new_timecode = Duration.minutes(d);
		
		mediaPlayer.seek(new_timecode);
		System.out.println("CLICK");
	}
	
	@FXML
	private void mouseOnProgressBarEntered(MouseEvent e) {
		slidingProgressTimer.setVisible(true);
		sliderProgressBar.setVisible(true);
		isMouseOnProgressBar = true;
	}
	
	@FXML
	private void mouseOnProgressBarExited(MouseEvent e) {
		if(!isSliderDragged) {
			slidingProgressTimer.setVisible(false);
			sliderProgressBar.setVisible(false);
		}
		
		Duration timecode = mediaPlayer.getCurrentTime();
		
		System.out.println("ON SORT");
		double ratio = timecode.toMinutes()/videoLength.toMinutes();
		progressBar.setProgress(ratio);
		
		isMouseOnProgressBar = false;
	}

	@FXML
	private void mouseOnProgressBarMoved(MouseEvent e) {
		double ratio = getMouseRatioOnProgressBar(progressBar, e);
		double vlength = videoLength.toMinutes();
		
		double xpos = progressBar.getLayoutX() + progressBar.getWidth()*ratio;
		
		double t = vlength*ratio;
		Duration d = Duration.minutes(t);
		String timecode = toTimecode(d);
		
		slidingProgressTimer.setLayoutX(xpos);
		slidingProgressTimer.setText(timecode);
		
		sliderProgressBar.setLayoutX(xpos);
		progressBar.setProgress(ratio);
		return;
	}
	
	@FXML
	private void mouseOnProgressBarReleased(MouseEvent e) {
		isSliderDragged = false;
		double ratio = getMouseRatioOnProgressBar(progressBar, e);
		if (ratio<0) { ratio = 0; };
		if (ratio>1) { ratio = 1; };
		
		double d = videoLength.toMinutes()*ratio;
		Duration new_timecode = Duration.minutes(d);
		
		slidingProgressTimer.setVisible(false);
		sliderProgressBar.setVisible(false);
		progressTimer.setText(toTimecode(new_timecode));
		mediaPlayer.seek(new_timecode);
		
	}
	
	@FXML
	private void mouseOnProgressBarDragged(MouseEvent e) {
		isSliderDragged = true;
		double ratio = getMouseRatioOnProgressBar(progressBar, e);
		if (ratio<0) { ratio = 0; };
		if (ratio>1) { ratio = 1; };
		
		double vlength = videoLength.toMinutes();
		
		double xpos = progressBar.getLayoutX() + progressBar.getWidth()*ratio;
		
		double t = vlength*ratio;
		Duration d = Duration.minutes(t);
		String timecode = toTimecode(d);
		
		slidingProgressTimer.setLayoutX(xpos);
		slidingProgressTimer.setText(timecode);
		
		sliderProgressBar.setLayoutX(xpos);
		progressBar.setProgress(ratio);
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
