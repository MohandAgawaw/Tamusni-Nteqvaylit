package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class igharsiwen extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,btn6;
ImageView imgbtn1,imgbtn2,imgbtn3,imgbtn4,imgbtn5,imgbtn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igharsiwen);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        ImageView  img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        imgbtn1 = findViewById(R.id.img1);
        imgbtn2 = findViewById(R.id.img2);
        imgbtn3 = findViewById(R.id.img3);
        imgbtn4 = findViewById(R.id.img4);
        imgbtn5 = findViewById(R.id.img5);
        imgbtn6 = findViewById(R.id.img6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_illel.class));
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_tiniri.class));
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_temda.class));
                finish();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_yetfarfiren.class));
                finish();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_tezgi.class));
                finish();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_aba3uc.class));
                finish();
            }
        });
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_illel.class));
                finish();
            }
        });
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_tiniri.class));
                finish();
            }
        });
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_temda.class));
                finish();
            }
        });
        imgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_yetfarfiren.class));
                finish();
            }
        });
        imgbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_tezgi.class));
                finish();
            }
        });
        imgbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_igharsiwen_aba3uc.class));
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
