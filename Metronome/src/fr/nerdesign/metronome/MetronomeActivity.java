package fr.nerdesign.metronome;

import android.app.Activity;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import fr.nerdesign.metronome.controller.MetronomeController;


public class MetronomeActivity extends Activity {
	
	MetronomeController metronomeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metronome);
        
        metronomeController = new MetronomeController(this);
        
        updateTempoView();
        setSliderListener();
        
    }


    private void updateTempoView(){
        TextView tempoView = ((TextView) findViewById(R.id.tempo));
        tempoView.setText(metronomeController.getTempo()+"");
    }
    
    public void start(View view){
    	metronomeController.startMetronome();
    }
    
    public void stop(View view){
    	metronomeController.stopMetronome();
    }
    
    public void updateTempo(View view){
    	SeekBar slider = (SeekBar) findViewById(R.id.slider);
    	int newTempo = slider.getProgress();
    	metronomeController.setTempo(newTempo);
    	updateTempoView();
    }
    
    private void setSliderListener(){
    	SeekBar slider = (SeekBar) findViewById(R.id.slider);
    	slider.setMax(200);
    	slider.setProgress(metronomeController.getTempo());
    	slider.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
		    	metronomeController.startMetronome();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				metronomeController.stopMetronome();
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
		    	metronomeController.setTempo(progress);
		    	updateTempoView();
			}
		});
    }
    
    public void downMeasure(View view){
    	metronomeController.downMeasure();    }
    
    public void upMeasure(View view){
    	metronomeController.upMeasure();
    }
    
    public void updateMeasureView(int measure){
    	TextView measureView = (TextView) findViewById(R.id.measure);
    	measureView.setText(measure + "");
    }
    
    
}
