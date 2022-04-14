package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TasenZikt extends AppCompatActivity {
Button btn1,btn2,btn3;
ImageView imgbtn1,imgbtn2,imgbtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasen_zikt);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        imgbtn1=findViewById(R.id.imgbtn1);
        imgbtn2=findViewById(R.id.imgbtn2);
        imgbtn3=findViewById(R.id.imgbtn3);
        ImageView  img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tasenzikt_tibladin.class));
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tasenzikt_ifran.class));
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tasenzikt_azru.class));
                finish();
            }
        });
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tasenzikt_tibladin.class));
                finish();
            }
        });
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tasenzikt_ifran.class));
                finish();
            }
        });
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tasenzikt_azru.class));
                finish();
            }
        });
    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
