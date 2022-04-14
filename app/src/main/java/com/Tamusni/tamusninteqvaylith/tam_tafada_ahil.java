package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class tam_tafada_ahil extends AppCompatActivity {
TextView titel,pre,deu,troi,quar,cinc,six,sept,huit;
    private DatabaseReference Myref;
ImageView preim,deuim,troiim,quarim,cincim,sixim,septim,huitim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_tafada_ahil);
        pre = findViewById(R.id.prem);
        deu= findViewById(R.id.deu);
        titel= findViewById(R.id.titelperiod);
        Myref = FirebaseDatabase.getInstance().getReference();
        troi= findViewById(R.id.troi);
        quar= findViewById(R.id.quatr);
        cinc= findViewById(R.id.cinc);
        ImageView  img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        six= findViewById(R.id.six);
        sept= findViewById(R.id.sept);
        huit= findViewById(R.id.huit);
        preim=findViewById(R.id.preimg);
        deuim=findViewById(R.id.deumg);
        troiim=findViewById(R.id.troiimg);
        quarim=findViewById(R.id.quatrimg);
        cincim=findViewById(R.id.cincimg);
        sixim=findViewById(R.id.siximg);
        septim=findViewById(R.id.sptimg);
        huitim=findViewById(R.id.huitimg);



           }
    @Override
    protected void onStart() {
        super.onStart();
        ProgressBar pbr;
        pbr =   findViewById(R.id.pBr);
        Query query = Myref.child("tafada").child("ahil");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfotit = " " + dataSnapshot.child("titel").getValue().toString();
                    titel.setText(texteinfotit);


                    String texteinfo1 = " " + dataSnapshot.child("1").child("nam").getValue().toString();
                    String image1 = dataSnapshot.child("1").child("img").getValue().toString();
                    pre.setText(texteinfo1);
                    Picasso.get().load(image1).into(preim);

                    String texteinfo2 = " " + dataSnapshot.child("2").child("nam").getValue().toString();
                    String image2 = dataSnapshot.child("2").child("img").getValue().toString();
                    deu.setText(texteinfo2);
                    Picasso.get().load(image2).into(deuim);

                    String texteinfo3 = " " + dataSnapshot.child("3").child("nam").getValue().toString();
                    String image3 = dataSnapshot.child("3").child("img").getValue().toString();
                    troi.setText(texteinfo3);
                    Picasso.get().load(image3).into(troiim);

                    String texteinfo4 = " " + dataSnapshot.child("4").child("nam").getValue().toString();
                    String image4 = dataSnapshot.child("4").child("img").getValue().toString();
                    quar.setText(texteinfo4);
                    Picasso.get().load(image4).into(quarim);

                    String texteinfo5 = " " + dataSnapshot.child("5").child("nam").getValue().toString();
                    String image5 = dataSnapshot.child("5").child("img").getValue().toString();
                    cinc.setText(texteinfo5);
                    Picasso.get().load(image5).into(cincim);

                    String texteinfo6 = " " + dataSnapshot.child("6").child("nam").getValue().toString();
                    String image6 = dataSnapshot.child("6").child("img").getValue().toString();
                    six.setText(texteinfo6);
                    Picasso.get().load(image6).into(sixim);

                    String texteinfo7 = " " + dataSnapshot.child("7").child("nam").getValue().toString();
                    String image7 = dataSnapshot.child("7").child("img").getValue().toString();
                    sept.setText(texteinfo7);
                    Picasso.get().load(image7).into(septim);

                    String texteinfo8 = " " + dataSnapshot.child("8").child("nam").getValue().toString();
                    String image8 = dataSnapshot.child("8").child("img").getValue().toString();
                    huit.setText(texteinfo8);
                    Picasso.get().load(image8).into(huitim);


                    pbr.setVisibility(View.INVISIBLE);


                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(getApplicationContext(),Tafada.class));
        finish();

    }
}