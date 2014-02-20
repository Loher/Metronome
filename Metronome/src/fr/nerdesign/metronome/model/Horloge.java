package fr.nerdesign.metronome.model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Looper;

public class Horloge {

	private Timer timer;
	
	public Horloge(int tempo){
		
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				try {
			        ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
			        toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 100);  	
				} catch (Exception e) {
					System.err.println("ERROR when beeping");
				}
		
			}
		};
		
		timer.schedule(timerTask, new Date(), tempo*10);
	}
	
	public void stop(){
		timer.cancel();
	}
	
	public void purge(){
		timer.purge();
	}
	
}
