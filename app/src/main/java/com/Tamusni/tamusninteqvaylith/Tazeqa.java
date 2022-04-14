package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Tazeqa extends AppCompatActivity {
Button btn1,btn2;
ImageView img1,img2;
ProgressBar progressBar;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tazeqa);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        img1= findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        progressBar = findViewById(R.id.procharg);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        ImageView  img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        btn1.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tazeqa_type.class));
            finish();
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tazeqa_element.class));
            finish();
        });
        img1.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tazeqa_type.class));
            finish();
        });
        img2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tazeqa_element.class));
            finish();
        });
        VideoView videoView = (VideoView)findViewById(R.id.tazeqavd);
        databaseReference.child("music").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    String Name = "" + dataSnapshot.child("videoaxam").getValue().toString();
                    Uri uri = Uri.parse(Name);
                    videoView.setVideoURI(uri);
                    MediaController mediaController = new MediaController(Tazeqa.this);
                    videoView.setMediaController(mediaController);
                    mediaController.setAnchorView(videoView);
                    videoView.requestFocus();
                    videoView.start();

                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    });

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
