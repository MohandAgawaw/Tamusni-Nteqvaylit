package com.Tamusni.tamusninteqvaylith;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;


public class Tamusni extends AppCompatActivity {
    WebView wbv;
    ProgressDialog progressDialog;
    private  final  int Time_Slash = 3500;
Button feta,tafeka,Tasenzikt,Tira,azeta,tazeqa,amezruy,igharsiwen,amarkal,tasenetrit,tafada,taqubet,Tbelbtn,plant;
    private DatabaseReference Myref;
    private ImageView imageplayps;
    private TextView timecu,timedur;
    private SeekBar playseek;
    private MediaPlayer mediaPlayer;
    LinearLayout lnrvcl;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamusni);
        Tasenzikt = findViewById(R.id.tasenzikt);
        feta = findViewById(R.id.fetta);
        tafeka = findViewById(R.id.tafeka);
        Tbelbtn = findViewById(R.id.tbel);
        azeta = findViewById(R.id.azeta);
        tazeqa = findViewById(R.id.tazeqa);
        amezruy = findViewById(R.id.amezruy);
        plant = findViewById(R.id.plante);
        igharsiwen = findViewById(R.id.igharsiwen);
        amarkal = findViewById(R.id.amrakal);
        taqubet = findViewById(R.id.Tiqubtin);
        tasenetrit = findViewById(R.id.Tasnetrit);
        tafada = findViewById(R.id.tafada);
        ImageView img = findViewById(R.id.imglogo);
        Tira = findViewById(R.id.tira);
        img.setBackgroundResource(R.drawable.logo1);
        ImageView  imgg = findViewById(R.id.imglogo2);
        Myref = FirebaseDatabase.getInstance().getReference();
        imageplayps = findViewById(R.id.btnply);
        timecu = findViewById(R.id.txttimecu);
        timedur = findViewById(R.id.timedur);
        playseek = findViewById(R.id.seekbarid);
        lnrvcl = findViewById(R.id.scr);
        mediaPlayer = new MediaPlayer();
        playseek.setMax(100);
        imgg.setBackgroundResource(R.drawable.logo1);
        wbv = findViewById(R.id.Webviewww);

        dialog();
        WebSettings webSettings = wbv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()|| !networkInfo.isAvailable()){
            Dialog dialog = new Dialog(this);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_alertediaa);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
            dialog.show();
            Button btnrt = dialog.findViewById(R.id.btnrtr);
            btnrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), Avantcentre.class));
                    finish();

                    recreate();
                }


            });

        }
        feta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fetta.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        tafeka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tam_tafek.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tigedrin.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        Tbelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Tbeltam.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        taqubet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Tiqubtin.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        azeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();
                startActivity(new Intent(getApplicationContext(), Azeta.class));


            }
        });
        tazeqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tazeqa.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        amezruy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Amezruy.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        igharsiwen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.Tamusni.tamusninteqvaylith.igharsiwen.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        amarkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Amarkal.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        tasenetrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tasentrit.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();
            }
        });
        tafada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tafada.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        Tira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.Tamusni.tamusninteqvaylith.Tira.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();

            }
        });
        Tasenzikt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TasenZikt.class));
                imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                mediaPlayer.pause();
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

    private void dialog() {
        progressDialog = new ProgressDialog(Tamusni.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog_tamusni);

        Button closedd = progressDialog.findViewById(R.id.closed);
        closedd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.hide();
            }
        });

        LottieAnimationView lottieAnimationView = progressDialog.findViewById(R.id.ltrid);
        lottieAnimationView.setAnimation(R.raw.tamusnidia);
        TextView textView = progressDialog.findViewById(R.id.idtexte);
        textView.setText("Ansuf ɣar Tamusni");
        progressDialog.getWindow().setBackgroundDrawableResource(

                android.R.color.transparent

        );



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressDialog.hide();
            }
        };
        new Handler().postDelayed(runnable,Time_Slash);

    }

    private void preparemediaplyr(){

        Query query = Myref.child("music");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = "" + dataSnapshot.child("tamusni").getValue().toString();
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

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Avantcentre.class));
        finish();
        mediaPlayer.stop();
    }
}
