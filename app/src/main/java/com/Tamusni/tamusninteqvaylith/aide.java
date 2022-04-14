package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class aide extends AppCompatActivity {
TextView link,tarlink;
ImageButton prd2,prd3,prd4,tarwalink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide);


        tarwalink = findViewById(R.id.tarwaidlnk);
        tarlink = findViewById(R.id.tarwa);
        prd2 = findViewById(R.id.imgbtq2);
        prd3 = findViewById(R.id.imgbtq3);
        prd4 = findViewById(R.id.imgbtq4);
        link = findViewById(R.id.linkbtq);

        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        tarwalink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openn =new Intent(Intent.ACTION_VIEW);
                openn.setData(Uri.parse("https://www.facebook.com/groups/2900546866837318"));
                startActivity(openn);
            }
        });
        tarlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openn =new Intent(Intent.ACTION_VIEW);
                openn.setData(Uri.parse("https://www.facebook.com/groups/2900546866837318"));
                startActivity(openn);
            }
        });
        prd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openn =new Intent(Intent.ACTION_VIEW);
                openn.setData(Uri.parse("https://boutique-kabyle.org/products/t-shirt-a-manches-courtes-logo-symbol-kabyle-pour-homme-femme-10"));
                startActivity(openn);
            }
        });
        prd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openn =new Intent(Intent.ACTION_VIEW);
                openn.setData(Uri.parse("https://boutique-kabyle.org/products/bob-avec-logo-berbere-kabyle"));
                startActivity(openn);
            }
        });
        prd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openn =new Intent(Intent.ACTION_VIEW);
                openn.setData(Uri.parse("https://boutique-kabyle.org/products/chaussure-boutiquekabyle-1"));
                startActivity(openn);
            }
        });

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openn =new Intent(Intent.ACTION_VIEW);
                openn.setData(Uri.parse("https://www.boutique-kabyle.org/"));
                startActivity(openn);
            }
        });


    }



    @Override

    public void onBackPressed() {

        super.onBackPressed();

        startActivity(new Intent(getApplicationContext(), Avantcentre.class));

        finish();


    }
}
