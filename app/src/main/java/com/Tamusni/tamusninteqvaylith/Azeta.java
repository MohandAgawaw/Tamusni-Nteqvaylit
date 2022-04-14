package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

public class Azeta extends AppCompatActivity {
    Button btn3,btn5,btn6,btn7,btn8;
    private DatabaseReference Myref;
    private ImageView imageplayps;
    private TextView timecu,timedur;
    private SeekBar playseek;
    private MediaPlayer mediaPlayer;
    LinearLayout lnrvcl;
    private final Handler handler = new Handler();
    ImageView imgbtn3,imgbtn5,imgbtn6,imgbtn7,imgbtn8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azeta);
        btn3=findViewById(R.id.btn3);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);

        imgbtn3=findViewById(R.id.imgbtn3);
        imgbtn5=findViewById(R.id.imgbtn5);
        imgbtn6=findViewById(R.id.imgbtn6);
        imgbtn7=findViewById(R.id.imgbtn7);
        imgbtn8=findViewById(R.id.imgbtn8);
        Myref = FirebaseDatabase.getInstance().getReference();
        imageplayps = findViewById(R.id.btnply);
        timecu = findViewById(R.id.txttimecu);
        timedur = findViewById(R.id.timedur);
        playseek = findViewById(R.id.seekbarid);
        lnrvcl = findViewById(R.id.scr);
        mediaPlayer = new MediaPlayer();
        playseek.setMax(100);
        ImageView  img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        btn3.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_aadil.class));
            mediaPlayer.pause();
        });
        btn5.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_abarnus.class));
            mediaPlayer.pause();
        });
        btn6.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_azeta.class));
            mediaPlayer.pause();
        });
        btn7.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_tisfifin.class));
            mediaPlayer.pause();
        });
        btn8.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_taqendurt.class));
            mediaPlayer.pause();
        });
        imgbtn3.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_aadil.class));
            mediaPlayer.pause();
        });

        imgbtn5.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_abarnus.class));
            mediaPlayer.pause();
        });
        imgbtn6.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_azeta.class));
            mediaPlayer.pause();
        });
        imgbtn7.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_tisfifin.class));
            mediaPlayer.pause();
        });
        imgbtn8.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_azeta_taqendurt.class));
            mediaPlayer.pause();
        });
        imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        imageplayps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);

                }else {
                    mediaPlayer.start();
                    imageplayps.setImageResource(R.drawable.ic_baseline_stop_24);
                    updatseek();
                    if (!mediaPlayer.isPlaying()){
                        preparemediaplyr();
                    }
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


        if (!mediaPlayer.isPlaying()){
            preparemediaplyr();
        }



    }

    private void preparemediaplyr(){

        Query query = Myref.child("music");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = "" + dataSnapshot.child("azeta").getValue().toString();
                    if(texteinfo != ""){
                        try {
                            mediaPlayer.setDataSource(texteinfo);
                            mediaPlayer.prepareAsync();

                            //mediaPlayer.prepare();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        lnrvcl.setVisibility(View.INVISIBLE);
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub
                                updatseek();
                                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                                lnrvcl.setVisibility(View.VISIBLE);
                                timedur.setText(milliscd(mediaPlayer.getDuration()));
                            }
                        });
                    }else {
                        lnrvcl.setVisibility(View.INVISIBLE);
                    }

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putInt("possition", mediaPlayer.getCurrentPosition());
        mediaPlayer.pause();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        int pos = savedInstanceState.getInt("possition");
        mediaPlayer.seekTo(pos);
        super.onRestoreInstanceState(savedInstanceState);
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
        finish();
        mediaPlayer.stop();
    }
}
