package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Slash extends AppCompatActivity {
private  final  int Time_Slash = 3700;

    Animation zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);
        zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        img = findViewById(R.id.image);
        img.startAnimation(zoom);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
                finish();
            }
        };
        new Handler().postDelayed(runnable,Time_Slash);


    }
}
