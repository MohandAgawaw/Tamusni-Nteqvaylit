package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Isefra extends AppCompatActivity {
ImageButton mtb,smoh,siulho,tarwa,samir,yamina;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    private  final  int Time_Slash = 3500;

    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<recycleisefra> messagesList;
    private recyclisefraadp adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isefra);
        mtb = findViewById(R.id.mtb);
        smoh = findViewById(R.id.smoh);
        samir = findViewById(R.id.anza);
        tarwa = findViewById(R.id.tarwa);
        siulho = findViewById(R.id.siulhocine);
        yamina = findViewById(R.id.yam);
        ImageView img = findViewById(R.id.imglogo);
        dialog();
        img.setBackgroundResource(R.drawable.logo1);
        databaseReference = FirebaseDatabase.getInstance().getReference("Isefra");
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();



        yamina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),yamina.class);
                startActivity(intent);

            }
        });
        samir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),anza.class);
                startActivity(intent);

            }
        });
        tarwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(),tarwaisfra.class);
                startActivity(start);

            }
        });
        siulho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(),SiulHocine.class);
                startActivity(start);
            }
        });
        smoh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(),simoh.class);
                startActivity(start);

            }
        });
        mtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(),Matoub.class);
                startActivity(start);

            }
        });
    }
    private void dialog() {
        progressDialog = new ProgressDialog(Isefra.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog_tamusni);
        LottieAnimationView lottieAnimationView = progressDialog.findViewById(R.id.ltrid);
        lottieAnimationView.setAnimation(R.raw.isefradia);
        TextView textView = progressDialog.findViewById(R.id.idtexte);
        textView.setText("Ansuf ɣar Isefra");
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
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    ClearAll();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        recycleisefra tiwelfinee = new recycleisefra();
                        tiwelfinee.setUrlmimg(snapshot.child("pic").getValue().toString());
                        tiwelfinee.setDate(snapshot.child("name").getValue().toString());
                        messagesList.add(tiwelfinee);
                    }


                    adapter = new recyclisefraadp(getApplicationContext(),messagesList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void ClearAll() {
        if (messagesList != null ){
            messagesList.clear();

            if ( adapter != null){
                adapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }
    @Override

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Avantcentre.class));

        finish();


    }
}
