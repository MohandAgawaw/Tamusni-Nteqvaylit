package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class tam_tafada_ayyur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_tafada_ayyur);
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(getApplicationContext(),Tafada.class));
        finish();

    }
}