package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Tbeltam extends AppCompatActivity {
Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbeltam);
        btn1=findViewById(R.id.btniwa);
        btn2 = findViewById(R.id.btnatabass);
        btn3 = findViewById(R.id.btntizmarin);
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tbel_iwasifen.class));
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tbel_atabass.class));
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tam_tbel_tizemarin.class));
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