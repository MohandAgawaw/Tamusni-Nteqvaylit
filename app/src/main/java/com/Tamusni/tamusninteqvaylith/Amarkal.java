package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Amarkal extends AppCompatActivity {

    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amarkal);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        btn1.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_amarkal_asaghlu.class));
            finish();
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),tam_amarkal_igemad.class));
            finish();
        });
    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
