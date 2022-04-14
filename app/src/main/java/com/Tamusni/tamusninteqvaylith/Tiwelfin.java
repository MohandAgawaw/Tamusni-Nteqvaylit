package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Tiwelfin extends AppCompatActivity {
Button btntw,igh,tz,id,tiq;
    private  final  int Time_Slash = 3500;
    WebView wbv;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiwelfin);
        btntw = findViewById(R.id.Tm);
        igh= findViewById(R.id.idurar);
        tz = findViewById(R.id.tz);
        id = findViewById(R.id.id);
        wbv = findViewById(R.id.Webview);
        tiq = findViewById(R.id.tiqdimin);
        ImageView img = findViewById(R.id.imglogo);
        dialog();
        img.setBackgroundResource(R.drawable.logo1);
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
                }


            });





        }
        tiq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tiwlafin_tiqdimin.class));

            }
        });
        igh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),imageidurar.class));

            }
        });
        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext(),photoideqi.class));

            }
        });
        tz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext(),phototazeqa.class));

            }
        });



        btntw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext(),Tamurth.class));

            }
        });
    }
    private void dialog() {
        progressDialog = new ProgressDialog(Tiwelfin.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog_tamusni);

        LottieAnimationView lottieAnimationView = progressDialog.findViewById(R.id.ltrid);
        lottieAnimationView.setAnimation(R.raw.photodia);
        TextView textView = progressDialog.findViewById(R.id.idtexte);
        textView.setText("Ansuf ɣar Tiwlafin");
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
