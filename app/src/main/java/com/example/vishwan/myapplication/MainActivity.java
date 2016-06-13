package com.example.vishwan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cleveroad.audiovisualization.AudioVisualization;
import com.cleveroad.audiovisualization.DbmHandler;
import com.cleveroad.audiovisualization.GLAudioVisualizationView;

public class MainActivity extends AppCompatActivity {

    private AudioVisualization audioVisualization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GLAudioVisualizationView tempGlAudioVisualizationView = (GLAudioVisualizationView)findViewById(R.id.visualizer_view);
        audioVisualization = (AudioVisualization) tempGlAudioVisualizationView;
        audioVisualization.linkTo(DbmHandler.Factory.newVisualizerHandler(getApplicationContext(), 0));
    }

    @Override
    public void onResume() {
        super.onResume();
        audioVisualization.onResume();
    }

    @Override
    public void onPause() {
        audioVisualization.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        audioVisualization.release();
        super.onDestroy();
    }
}
