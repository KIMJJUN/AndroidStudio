package com.andrstudy.toggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener,SeekBar.OnSeekBarChangeListener {
    private ToggleButton toggleButton;
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private SeekBar seekBar,seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.ToggleButton);
        toggleButton.setOnCheckedChangeListener(this);

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(this);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener(this);

        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Toast.makeText(this,compoundButton.getText() + "- state is " + b, Toast.LENGTH_SHORT).show();
        if(compoundButton.getId() == toggleButton.getId()){
            if(b){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {

        RadioButton Button = (RadioButton) v;
        Toast.makeText(this, Button.getText(),Toast.LENGTH_SHORT).show();
        if(Button.getId() == R.id.radioButton){
            progressBar2.incrementProgressBy(1);
        }else if(Button.getId() == R.id.radioButton2){
            progressBar2.incrementProgressBy(-1);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b){
           progressBar2.setProgress(i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
