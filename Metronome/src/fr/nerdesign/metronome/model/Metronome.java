package fr.nerdesign.metronome.model;

public class Metronome {

	private int tempo;
	private int measure;
	
	public Metronome(){
		tempo = 60;
		measure = 4;
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
	
	
	
}
