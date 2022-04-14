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
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

import static android.R.layout.simple_spinner_item;


public class Tamurth extends AppCompatActivity {
    RecyclerView recyclerView;
    String spinnerchoi;
    Button btn;
    private DatabaseReference Myref;
    private ArrayList<messages> messagesList;
    private Adapter adapter;
    private Spinner spinnerWilaya;
    private ImageView imageplayps;
    private TextView timecu,timedur;
    private SeekBar playseek;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    LinearLayout lnrvcl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamurth);
        recyclerView = findViewById(R.id.RecyclerView);
        btn = findViewById(R.id.nadhi);
        ImageView img = findViewById(R.id.imglogo);
        imageplayps = findViewById(R.id.btnply);
        timecu = findViewById(R.id.txttimecu);
        img.setBackgroundResource(R.drawable.logo1);
        spinnerWilaya = findViewById(R.id.spinnerr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lnrvcl = findViewById(R.id.scr);
        final String[] spinnerwilaya = tam.getAllWilaya();
        ArrayAdapter<String> adapterwilaya = new ArrayAdapter<String>(this,
                simple_spinner_item, spinnerwilaya);
        lnrvcl.setVisibility(View.INVISIBLE);
        adapterwilaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWilaya.setAdapter(adapterwilaya);

        LinearLayoutManager layoutManager = new LinearLayoutManager( this);

        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();
        ClearAll();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerchoi = spinnerWilaya.getSelectedItem().toString();


                if(spinnerchoi == "Tizi Wezzu"){
                    Query query = Myref.child("tiziouzou");

                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("imagetizi").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("nametizi").getValue().toString());
                                tiwelfinee.setDate(snapshot.child("date").getValue().toString());
                                messagesList.add(tiwelfinee);

                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();



                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                if(spinnerchoi == "Ğiğel"){
                    Query query = Myref.child("jijel");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                                messagesList.add(tiwelfinee);


                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                if(spinnerchoi == "Bgayet"){
                    Query query = Myref.child("vgayeth");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                                messagesList.add(tiwelfinee);


                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                if(spinnerchoi == "Bumerdas"){
                    Query query = Myref.child("bomerdes");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                                messagesList.add(tiwelfinee);


                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                if(spinnerchoi == "Burğ Bu3rarij"){
                    Query query = Myref.child("borj");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                                messagesList.add(tiwelfinee);


                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                if(spinnerchoi == "Setif"){
                    Query query = Myref.child("setif");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                                messagesList.add(tiwelfinee);


                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                if(spinnerchoi == "Tubiret"){
                    Query query = Myref.child("bouira");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ClearAll();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                messages tiwelfinee = new messages();
                                tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                                tiwelfinee.setDescription(snapshot.child("name").getValue().toString());

                                messagesList.add(tiwelfinee);


                            }


                            adapter = new Adapter(getApplicationContext(),messagesList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }



            }


        });timedur = findViewById(R.id.timedur);
        playseek = findViewById(R.id.seekbarid);
        mediaPlayer = new MediaPlayer();
        playseek.setMax(100);

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
        preparemediaplyr();
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
    private void preparemediaplyr(){
        Query query = Myref.child("music");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = "" + dataSnapshot.child("tiwlafin_tamurt").getValue().toString();
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




    }







    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();

        finish();

    }

    private  void ClearAll(){
        if (messagesList != null ){
            messagesList.clear();


            if ( adapter != null){
                adapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }

}
