package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class tam_tasenzikt_ifran extends AppCompatActivity {
    Button btn1,btn2;
    ImageView imgbtn1,imgbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_tasenzikt_ifran);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        imgbtn1=findViewById(R.id.imgbtn1);
        imgbtn2=findViewById(R.id.imgbtn2);
        btn1.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tasenzikt_ifran_ifran.class));
            finish();
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tasenzikt_tibladin_tissira.class));
            finish();
        });
        imgbtn1.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tasenzikt_ifran_ifran.class));
            finish();
        });
        imgbtn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_tasenzikt_tibladin_tissira.class));
            finish();
        });
    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(getApplicationContext(),TasenZikt.class));
        finish();

    }
}