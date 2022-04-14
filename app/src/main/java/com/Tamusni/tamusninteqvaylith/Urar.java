package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Urar extends AppCompatActivity {
Button Quizz,urar2,urar3;
    private  final  int Time_Slash = 3500;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urar);
        urar2 = findViewById(R.id.urar2);
        urar3 = findViewById(R.id.urar3);
        Quizz = findViewById(R.id.quiz);
        ImageView img = findViewById(R.id.imglogo);
        dialog();
        img.setBackgroundResource(R.drawable.logo1);


        urar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),urarwisin.class));
            }
        });
        urar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),urar3.class));
            }
        });

        Quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),activity_starting_screen.class));

                Toast.makeText(Urar.this,"Urar N Tuttriwin",Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void dialog() {
        progressDialog = new ProgressDialog(Urar.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog_tamusni);

        LottieAnimationView lottieAnimationView = progressDialog.findViewById(R.id.ltrid);
        lottieAnimationView.setAnimation(R.raw.gamedia);
        TextView textView = progressDialog.findViewById(R.id.idtexte);
        textView.setText("Ansuf ɣar Urar");
        progressDialog.getWindow().setBackgroundDrawableResource(

                android.R.color.transparent

        );

        Button closedd = progressDialog.findViewById(R.id.closed);
        closedd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.hide();
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressDialog.hide();
            }
        };
        new Handler().postDelayed(runnable,Time_Slash);

    }

    @Override

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Avantcentre.class));

        finish();


    }
}
