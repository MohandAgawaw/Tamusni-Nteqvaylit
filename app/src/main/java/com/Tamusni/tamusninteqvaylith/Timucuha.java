package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Timucuha extends AppCompatActivity {
    ProgressDialog progressDialog;
    private  final  int Time_Slash = 3500;
Button post9,post8,post7,post6,post5,post4,post3,post2,post1;
    private DatabaseReference Myref;
    ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timucuha);
        post1 = findViewById(R.id.post1);
        post2 = findViewById(R.id.post2);
        post3 = findViewById(R.id.post3);
        post4 = findViewById(R.id.post4);
        post5 = findViewById(R.id.post5);
        post6 = findViewById(R.id.post6);
        post7 = findViewById(R.id.post7);
        post8 = findViewById(R.id.post8);
        post9 = findViewById(R.id.post9);
        dialog();
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        progressBar2 = findViewById(R.id.progressBar2);
        Myref = FirebaseDatabase.getInstance().getReference();

        post9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tglda.class));
            }
        });
        post8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),afardas.class));
            }
        });
        post7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),aqalus.class));
            }
        });
        post6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),sbe3.class));            }
        });
        post5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tasadicitan.class));
            }
        });
        post2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tawkilt.class));

            }
        });
        post3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),awa.class);
                startActivity(intent);

            }
        });
        post4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tar.class));

            }
        });
        post1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),post1.class));

            }
        });

        post1.setVisibility(View.INVISIBLE);
        post2.setVisibility(View.INVISIBLE);
        post3.setVisibility(View.INVISIBLE);
        post4.setVisibility(View.INVISIBLE);
        post5.setVisibility(View.INVISIBLE);
        post6.setVisibility(View.INVISIBLE);
        post7.setVisibility(View.INVISIBLE);
        post8.setVisibility(View.INVISIBLE);
        post9.setVisibility(View.INVISIBLE);
    }



    @Override
    protected void onStart() {
        progressBar2.setVisibility(View.VISIBLE);
        super.onStart();
        Query query = Myref.child("timucuha");
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    progressBar2.setVisibility(View.INVISIBLE);
                    String post_1 = " " + dataSnapshot.child("post1").child("name1").getValue().toString();
                    String post_1_act =""+ dataSnapshot.child("post1").child("act").getValue().toString();
                    final String txtpst1 = post1.getText().toString().trim();
                    final String txtpst2 = post2.getText().toString().trim();
                    final String txtpst3 = post3.getText().toString().trim();
                    final String txtpst4 = post4.getText().toString().trim();
                    final String txtpst5 = post5.getText().toString().trim();
                    final String txtpst6 = post6.getText().toString().trim();
                    final String txtpst7 = post7.getText().toString().trim();
                    final String txtpst8 = post8.getText().toString().trim();
                    final String txtpst9 = post9.getText().toString().trim();


                    if(post_1_act.equals(String.valueOf(1))){
                        post1.setText(post_1);
                        if(TextUtils.isEmpty(txtpst1)){
                            post1.setVisibility(View.INVISIBLE);
                        }else{
                            post1.setVisibility(View.VISIBLE);

                        }

                    }

                    String post_2 = " " + dataSnapshot.child("post2").child("name2").getValue().toString();
                    String post_2_act =""+ dataSnapshot.child("post2").child("act").getValue().toString();
                    if(post_2_act.equals(String.valueOf(1))){
                        post2.setText(post_2);
                        if(TextUtils.isEmpty(txtpst2)){
                            post2.setVisibility(View.INVISIBLE);
                        }else{
                            post2.setVisibility(View.VISIBLE);

                        }
                    }

                    String post_3 = " " + dataSnapshot.child("post3").child("name3").getValue().toString();
                    String post_3_act =""+ dataSnapshot.child("post3").child("act").getValue().toString();
                    if(post_3_act.equals(String.valueOf(1))){
                        post3.setText(post_3);
                        if(TextUtils.isEmpty(txtpst3)){
                            post3.setVisibility(View.INVISIBLE);
                        }else{
                            post3.setVisibility(View.VISIBLE);

                        }
                    }
                    String post_4 = " " + dataSnapshot.child("post4").child("name4").getValue().toString();
                    String post_4_act =""+ dataSnapshot.child("post4").child("act").getValue().toString();
                    if(post_4_act.equals(String.valueOf(1))){
                        post4.setText(post_4);
                        if(TextUtils.isEmpty(txtpst4)){
                            post4.setVisibility(View.INVISIBLE);
                        }else{
                            post4.setVisibility(View.VISIBLE);

                        }
                    }
                    String post_5 = " " + dataSnapshot.child("post5").child("name5").getValue().toString();
                    String post_5_act =""+ dataSnapshot.child("post5").child("act").getValue().toString();
                    if(post_5_act.equals(String.valueOf(1))){
                        post5.setText(post_5);
                        if(TextUtils.isEmpty(txtpst5)){
                            post5.setVisibility(View.INVISIBLE);
                        }else{
                            post5.setVisibility(View.VISIBLE);

                        }

                    }
                    String post_6 = " " + dataSnapshot.child("post6").child("name6").getValue().toString();
                    String post_6_act =""+ dataSnapshot.child("post6").child("act").getValue().toString();
                    if(post_6_act.equals(String.valueOf(1))){
                        post6.setText(post_6);
                        if(TextUtils.isEmpty(txtpst6)){
                            post6.setVisibility(View.INVISIBLE);
                        }else{
                            post6.setVisibility(View.VISIBLE);

                        }
                    }
                    String post_7 = " " + dataSnapshot.child("post7").child("name7").getValue().toString();
                    String post_7_act =""+ dataSnapshot.child("post7").child("act").getValue().toString();
                    if(post_7_act.equals(String.valueOf(1))){
                        post7.setText(post_7);
                        if(TextUtils.isEmpty(txtpst7)){
                            post7.setVisibility(View.INVISIBLE);
                        }else{
                            post7.setVisibility(View.VISIBLE);

                        }
                    }
                    String post_8 = " " + dataSnapshot.child("post8").child("name8").getValue().toString();
                    String post_8_act =""+ dataSnapshot.child("post8").child("act").getValue().toString();
                    if(post_8_act.equals(String.valueOf(1))){
                        post8.setText(post_8);
                        if(TextUtils.isEmpty(txtpst8)){
                            post8.setVisibility(View.INVISIBLE);
                        }else{
                            post8.setVisibility(View.VISIBLE);

                        }
                    }
                    String post_9 = " " + dataSnapshot.child("post9").child("name9").getValue().toString();
                    String post_9_act =""+ dataSnapshot.child("post9").child("act").getValue().toString();
                    if(post_9_act.equals(String.valueOf(1))){
                        post9.setText(post_9);
                        if(TextUtils.isEmpty(txtpst9)){
                            post9.setVisibility(View.INVISIBLE);
                        }else{
                            post9.setVisibility(View.VISIBLE);

                        }
                    }

                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void dialog() {
        progressDialog = new ProgressDialog(Timucuha.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog_tamusni);

        LottieAnimationView lottieAnimationView = progressDialog.findViewById(R.id.ltrid);
        lottieAnimationView.setAnimation(R.raw.histoiredia);
        TextView textView = progressDialog.findViewById(R.id.idtexte);
        textView.setText("Ansuf ɣar Timucuha");
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
