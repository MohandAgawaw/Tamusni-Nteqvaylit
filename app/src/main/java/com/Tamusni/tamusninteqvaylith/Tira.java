package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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


public class Tira extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,btn6;
    private ImageView imageplayps;

    private TextView timecu,timedur;
    private SeekBar playseek;
    private MediaPlayer mediaPlayer;
    DatabaseReference databaseReference;
    private Handler handler = new Handler();
    LinearLayout lnrvcl;
    private DatabaseReference Myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tira);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mediaPlayer = new MediaPlayer();
        Myref = FirebaseDatabase.getInstance().getReference();
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        imageplayps = findViewById(R.id.btnply);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        ImageView  img = findViewById(R.id.imglogo);
        imageplayps = findViewById(R.id.btnply);
        timecu = findViewById(R.id.txttimecu);
        timedur = findViewById(R.id.timedur);
        mediaPlayer = new MediaPlayer();
        lnrvcl = findViewById(R.id.scr);
        img.setBackgroundResource(R.drawable.logo1);
        btn6=findViewById(R.id.btn6);

        playseek = findViewById(R.id.seekbarid);
        btn1.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tirra_ideqi.class));
            finish();

            mediaPlayer.stop();
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tirra_ifri.class));
            finish();

            mediaPlayer.stop();
        });
        btn3.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tirra_tahnayin.class));
            finish();

            mediaPlayer.stop();
        });
        btn4.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tirra_tecrad.class));
            finish();

            mediaPlayer.stop();
        });
        btn5.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tirra_uqalus.class));
            finish();
            mediaPlayer.stop();
        });
        btn6.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tirra_uzzeta.class));
            finish();
            mediaPlayer.stop();
        });
        lnrvcl.setVisibility(View.INVISIBLE);
        preparemediaplyr();
        vazy();
        btn1.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putInt("possition", mediaPlayer.getCurrentPosition());
        mediaPlayer.pause();
        super.onSaveInstanceState(outState);
    }

    protected void vazy() {
        super.onStart();
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
        btn5.setVisibility(View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        databaseReference.child("tirrabtn").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    String bbtn1 = "" + dataSnapshot.child("ideqi").getValue().toString();
                    String bbtn2 = "" + dataSnapshot.child("ifri").getValue().toString();
                    String bbtn3 = "" + dataSnapshot.child("ihnayen").getValue().toString();
                    String bbtn4 = "" + dataSnapshot.child("tichrad").getValue().toString();
                    String bbtn5 = "" + dataSnapshot.child("aqalus").getValue().toString();
                    String bbtn6 = "" + dataSnapshot.child("azeta").getValue().toString();

                    if (bbtn1.equals("on")){

                        btn1.setVisibility(View.VISIBLE);

                    }else {
                        btn1.setVisibility(View.INVISIBLE);
                    }
                    if (bbtn2.equals("on")){

                        btn2.setVisibility(View.VISIBLE);
                    }else {
                        btn2.setVisibility(View.INVISIBLE);
                    }
                    if (bbtn3.equals("on")){
                        btn3.setVisibility(View.VISIBLE);
                    }else {
                        btn3.setVisibility(View.INVISIBLE);
                    }
                    if (bbtn4.equals("on")){
                        btn4.setVisibility(View.VISIBLE);
                    }else {
                        btn4.setVisibility(View.INVISIBLE);
                    }
                    if (bbtn5.equals("on")){
                        btn5.setVisibility(View.VISIBLE);
                    }else {
                        btn5.setVisibility(View.INVISIBLE);
                    }
                    if (bbtn6.equals("on")){
                        btn6.setVisibility(View.VISIBLE);
                    }else {
                        btn6.setVisibility(View.INVISIBLE);
                    }

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        int pos = savedInstanceState.getInt("possition");
        mediaPlayer.seekTo(pos);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void preparemediaplyr(){

        Query query = Myref.child("music");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = "" + dataSnapshot.child("tirra").getValue().toString();
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
    protected void onStart() {
        super.onStart();

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


    @Override

    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        finish();

    }
}
