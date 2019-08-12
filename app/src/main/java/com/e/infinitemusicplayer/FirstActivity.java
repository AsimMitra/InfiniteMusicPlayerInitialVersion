package com.e.infinitemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    Button play, pause, stop;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        play = findViewById(R.id.button);
        pause = findViewById(R.id.button2);
        stop = findViewById(R.id.button3);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                if(mediaPlayer==null){
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.alanwalkerfaded);
                mediaPlayer.start(); }
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }
                break;
            case R.id.button2:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                    pauseCurrentPosition=mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.button3:
                if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null;}
                break;
        }
    }
}