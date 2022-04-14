package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class anza extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<iseframsg> messagesList;
    private isadapter isadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anza);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        messagesList = new ArrayList<>();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Query query = Myref.child("anza");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    iseframsg tiwelfinee = new iseframsg();
                    tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                    messagesList.add(tiwelfinee);


                }


                isadapter = new isadapter(getApplicationContext(),messagesList);
                recyclerView.setAdapter(isadapter);
                isadapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void ClearAll() {
        if (messagesList != null ){
            messagesList.clear();

            if ( isadapter != null){
                isadapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }

    public void onBackPressed() {

        super.onBackPressed();
        finish();

    }

}
