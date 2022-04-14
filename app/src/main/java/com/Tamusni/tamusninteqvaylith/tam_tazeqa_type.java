package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tam_tazeqa_type extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<info_tirra> messagesList;
    private info_tirra_adp adapter;
    LinearLayout cnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_tazeqa_type);  recyclerView = findViewById(R.id.RecyclerView);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>(); cnx = findViewById(R.id.netlong);
    } protected void onStart() {
        super.onStart();
        Query query = Myref.child("tam_tazeqa_anaw");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    info_tirra tiwelfinee = new info_tirra();
                    tiwelfinee.setLink(snapshot.child("video").getValue().toString());
                    if(snapshot.child("video").getValue().toString().isEmpty()){
                        tiwelfinee.setPic1(snapshot.child("test").getValue().toString());
                        tiwelfinee.setPic2(snapshot.child("test1").getValue().toString());
                    }
                    tiwelfinee.setTitel(snapshot.child("titel").getValue().toString());
                    tiwelfinee.setDiscri(snapshot.child("disci").getValue().toString());
                    messagesList.add(tiwelfinee);
                }

                cnx.setVisibility(View.INVISIBLE);
                adapter = new info_tirra_adp(getApplicationContext(),messagesList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
        super.onBackPressed();

        startActivity(new Intent(getApplicationContext(),Tazeqa.class));
        finish();

    }
}