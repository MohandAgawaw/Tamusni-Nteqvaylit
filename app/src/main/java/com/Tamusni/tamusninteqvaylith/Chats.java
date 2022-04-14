package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.ArrayList;

public class Chats extends AppCompatActivity {
    Button chat;
    LinearLayout lnrvcl;
    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<chatss> messagesListt;
    private ImageView imageplayps;
    private TextView timecu,timedur;
    private SeekBar playseek;
    private MediaPlayer mediaPlayer;
    private Adapterr adapter;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        recyclerView = findViewById(R.id.RecyclerViewchat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesListt = new ArrayList<>();
        imageplayps = findViewById(R.id.btnply);
        timecu = findViewById(R.id.txttimecu);
        timedur = findViewById(R.id.timedur);
        playseek = findViewById(R.id.seekbarid);
        lnrvcl = findViewById(R.id.scr);
        mediaPlayer = new MediaPlayer();
        playseek.setMax(100);
        lnrvcl.setVisibility(View.INVISIBLE);
     chat = findViewById(R.id.chat);
     chat.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(Chats.this,aide.class);
             startActivity(intent);
             finish();
         }
     });

    }



    @Override
    protected void onStart() {
        super.onStart();
        Query query = Myref.child("chats");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    chatss tiwelfinee = new chatss();
                    tiwelfinee.setUrlmimg(snapshot.child("img").getValue().toString());
                    tiwelfinee.setNamechat(snapshot.child("name").getValue().toString());
                    tiwelfinee.setDescription(snapshot.child("msg").getValue().toString());
                    messagesListt.add(tiwelfinee);
                }


                adapter = new Adapterr(getApplicationContext(),messagesListt);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
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


        preparemediaplyr();

    }

    private void ClearAll() {
        if (messagesListt != null ){
            messagesListt.clear();

            if ( adapter != null){
                adapter.notifyDataSetChanged();
            }
        }
        messagesListt = new ArrayList<>();
    }

    private void preparemediaplyr(){
        Query query = Myref.child("music");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = "" + dataSnapshot.child("cheat").getValue().toString();
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

        startActivity(new Intent(getApplicationContext(), Avantcentre.class));
        mediaPlayer.stop();
        finish();


    }
}
