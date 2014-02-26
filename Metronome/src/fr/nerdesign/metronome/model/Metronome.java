package fr.nerdesign.metronome.model;

import android.media.AudioManager;
import android.media.ToneGenerator;

public class Metronome {

	private int tempo;
	private int measure;
	private ToneGenerator beep;
	private ToneGenerator firstBeep;
	
	public Metronome(){
		tempo = 60;
		measure = 4;
        beep = new ToneGenerator(AudioManager.FLAG_PLAY_SOUND, 100);
        firstBeep = new ToneGenerator(AudioManager.VIBRATE_TYPE_NOTIFICATION, 100);
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getMeasure() {
		return measure;
	}

	public void upMeasure() {
		if(this.measure < 8){
			this.measure++;
		}
	}
	
	public void downMeasure(){
		if(this.measure > 2){
			this.measure--;

		}
	}

	public ToneGenerator getBeep() {
		return beep;
	}

	public void setBeep(ToneGenerator beep) {
		this.beep = beep;
	}

	public ToneGenerator getFirstBeep() {
		return firstBeep;
	}

	public void setFirstBeep(ToneGenerator firstBeep) {
		this.firstBeep = firstBeep;
	}
	
	
	
}
