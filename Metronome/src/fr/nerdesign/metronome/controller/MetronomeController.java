package fr.nerdesign.metronome.controller;

import fr.nerdesign.metronome.MetronomeActivity;
import fr.nerdesign.metronome.model.Horloge;
import fr.nerdesign.metronome.model.Metronome;

public class MetronomeController {
	
	private MetronomeActivity metronomeActivity;
	private Metronome metronome;
	private Horloge horloge;

	public MetronomeController(MetronomeActivity metronomeActivity){
		this.metronomeActivity = metronomeActivity;
		metronome = new Metronome();
	}
	
	public int getTempo(){
		return metronome.getTempo();
	}
	
	public void setTempo(int tempo){
		metronome.setTempo(tempo);
	}
	
	public void startMetronome(){
		if(horloge != null){
			horloge.stop();
		}
		horloge = new Horloge(metronome.getTempo(), metronome.getMeasure(), metronome.getBeep(), metronome.getFirstBeep());
	}
	
	public void stopMetronome(){
		if(horloge != null){
			horloge.stop();
		}
		
	}
	
	public void upMeasure(){
		metronome.upMeasure();
		metronomeActivity.updateMeasureView(metronome.getMeasure());
		
		if(horloge != null){
			horloge.stop();
		}
		horloge = new Horloge(metronome.getTempo(), metronome.getMeasure(), metronome.getBeep(), metronome.getFirstBeep());
	}
	
	public void downMeasure(){
		metronome.downMeasure();
		metronomeActivity.updateMeasureView(metronome.getMeasure());
		 
		if(horloge != null){
			horloge.stop();
		}
		horloge = new Horloge(metronome.getTempo(), metronome.getMeasure(), metronome.getBeep(), metronome.getFirstBeep());
	}

	
}
