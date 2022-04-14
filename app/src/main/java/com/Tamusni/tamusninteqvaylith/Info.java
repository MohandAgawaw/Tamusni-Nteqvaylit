package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    ImageView start;
    private SeekBar playseek;
    private TextView timecu,timedur;
    private MediaPlayer mediaPlayer;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        start = findViewById(R.id.btnply);
        String pageId = "1244573352350235";
        timecu = findViewById(R.id.txttimecu);
        timedur = findViewById(R.id.timedur);
        playseek = findViewById(R.id.seekbarid);
        start.setImageResource(R.drawable.ic_baseline_play_arrow_24);
         mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ayennela);
        timedur.setText(milliscd(mediaPlayer.getDuration()));
        playseek.setMax(100);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(mediaPlayer.isPlaying()){
                        handler.removeCallbacks(updater);
                        mediaPlayer.pause();
                        start.setImageResource(R.drawable.ic_baseline_play_arrow_24);

                    }else {
                        mediaPlayer.start();
                        start.setImageResource(R.drawable.ic_baseline_stop_24);
                        updatseek();
                    }

            }
        });
        playseek.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SeekBar seekBar = (SeekBar) view;
                int playpstn = (mediaPlayer.getDuration() / 100) * seekBar.getProgress();
                mediaPlayer.seekTo(playpstn);
                timecu.setText(milliscd(mediaPlayer.getCurrentPosition()));

                return false;
            }
        });
    }
    private  Runnable updater = new Runnable() {
        @Override
        public void run() {
            updatseek();
            long currentduration = mediaPlayer.getCurrentPosition();
            timecu.setText(milliscd(currentduration));
        }
    };
    private  void  updatseek(){
        if(mediaPlayer.isPlaying()){
            playseek.setProgress((int)(((float)mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration())* 100));
            handler.postDelayed(updater,1000);
        }
    }
    private String milliscd(long milliscd){
        String timerStr = "";
        String scnd;
        int hour = (int)(milliscd/(1000 * 60 * 60));
        int minutes = (int)(milliscd % (1000 * 60 * 60))/(1000 * 60);
        int seconds = (int)((milliscd % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (hour > 0) {
            timerStr= hour + ":";
        }
        if (seconds<10){
            scnd = "0"+ seconds;
        }else{
            scnd = "" + seconds;
        }
        timerStr = timerStr + minutes + ":"+scnd;
        return timerStr;
    }
    @Override

    public void onBackPressed() {

        super.onBackPressed();

        mediaPlayer.stop();
        startActivity(new Intent(getApplicationContext(), Avantcentre.class));


        finish();

    }
}
