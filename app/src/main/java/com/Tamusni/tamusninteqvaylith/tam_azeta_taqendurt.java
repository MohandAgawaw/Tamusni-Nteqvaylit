package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tam_azeta_taqendurt extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout cnx;
    private DatabaseReference Myref;
    private ArrayList<tam_info_dbl> messagesList;
    private tam_info_dbl_adp adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_azeta_taqendurt); recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();
        cnx = findViewById(R.id.netlong);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Query query = Myref.child("tam_azzeta_taqendurt");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    tam_info_dbl tiwelfinee = new tam_info_dbl();
                    tiwelfinee.setUrlmimg(snapshot.child("test").getValue().toString());
                    tiwelfinee.setDate(snapshot.child("name").getValue().toString());
                    tiwelfinee.setDescription(snapshot.child("manee").getValue().toString());
                    tiwelfinee.setUrlmimgg(snapshot.child("test1").getValue().toString());
                    messagesList.add(tiwelfinee);
                }

                cnx.setVisibility(View.INVISIBLE);
                adapter = new tam_info_dbl_adp(getApplicationContext(),messagesList);
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

        finish();

    }
}