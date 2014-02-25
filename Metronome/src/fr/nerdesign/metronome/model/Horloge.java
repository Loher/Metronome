package fr.nerdesign.metronome.model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Looper;

public class Horloge {

	private Timer timer;
	private int measure;
	private int currentBeep = 1;
	private ToneGenerator beep;
	private ToneGenerator firstBeep;
	
	public Horloge(int tempo, int measure){
		
		this.measure = measure;
		timer = new Timer();
        //toneG = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
        beep = new ToneGenerator(AudioManager.FLAG_PLAY_SOUND, 100);
        firstBeep = new ToneGenerator(AudioManager.VIBRATE_TYPE_NOTIFICATION, 100);

        
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				try {
					if(currentBeep == 1){
						firstBeep.startTone(ToneGenerator.TONE_SUP_PIP, 100);
						currentBeep++;
					}
					else if(currentBeep == Horloge.this.measure){
						beep.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 100);
						currentBeep = 1;
					}
					else{
						beep.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 100);
						currentBeep++;
					}
					
					
					
				} catch (Exception e) {
					System.err.println("ERROR when beeping");
				}
		
			}
		};
		
		timer.schedule(timerTask, new Date(), 60000/tempo);
	}
	
	public void stop(){
		timer.cancel();
	}
	
	public void purge(){
		timer.purge();
	}
	
}
