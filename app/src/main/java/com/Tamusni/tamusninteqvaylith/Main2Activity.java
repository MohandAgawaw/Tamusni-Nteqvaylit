package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    Button btn_start,btn_start1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2r);
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        SharedPreferences mPrefs = getSharedPreferences("cheke",MODE_PRIVATE);

        String cheke = mPrefs.getString("remembre", "");

        if(cheke.equals("true")){
            Intent ImLoggedIn = new Intent(getApplicationContext(), Avantcentre.class);
            startActivity(ImLoggedIn);
        }
        btn_start = (Button) findViewById(R.id.btn_lgn);
        btn_start1 = (Button) findViewById(R.id.btn_ins);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        btn_start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inscription();
            }
        });

    }
    public void Inscription() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Login() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
            System.exit(1);
            finish();
    }
}