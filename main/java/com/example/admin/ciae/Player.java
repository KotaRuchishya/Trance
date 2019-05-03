package com.example.admin.ciae;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Player extends AppCompatActivity implements View.OnClickListener {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pausePosition;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        t=(TextView)findViewById(R.id.texttv);
        Typeface custom_font= Typeface.createFromAsset(getAssets(),"fonts/chardons.ttf");
        t.setTypeface(custom_font);
        play=(Button)findViewById(R.id.play);
        pause=(Button)findViewById(R.id.pause);
        stop=(Button)findViewById(R.id.stop);


        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if(mediaPlayer==null) {

                    if(Global.song.equals("Chaar Kadam")) {

                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.charkadam);
                        mediaPlayer.start();
                    }
                    else if(Global.song.equals("Dangal"))
                    {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dangal);
                        mediaPlayer.start();
                    }
                    else if(Global.song.equals("Soch"))
                    {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sochnasake);
                        mediaPlayer.start();
                    }
                    else if(Global.song.equals("Hum hai"))
                    {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.humhai);
                        mediaPlayer.start();
                    }
                    else if(Global.song.equals("Ziddi Dil"))
                    {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ziddi);
                        mediaPlayer.start();
                    }
                    else if(Global.song.equals("Kar har maidan fateh"))
                    {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karharmaidanfateh);
                        mediaPlayer.start();
                    }
                } else if (!mediaPlayer.isPlaying()) {

                    mediaPlayer.seekTo(pausePosition);
                    mediaPlayer.start();
                }

                break;
            case R.id.pause:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                    pausePosition=mediaPlayer.getCurrentPosition();
                }

                break;
            case R.id.stop:
                if(mediaPlayer!=null) {
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;
        }
    }


}


