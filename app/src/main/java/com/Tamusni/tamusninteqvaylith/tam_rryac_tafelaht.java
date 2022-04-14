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

public class tam_rryac_tafelaht extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<tam_info_dbl> messagesList;
    private tam_info_dbl_adp adapter; LinearLayout cnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_rryac_tafelaht);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();
        cnx = findViewById(R.id.netlong);

    }
    protected void onStart() {
        super.onStart();
        Query query = Myref.child("tam_Rryac_tafelaht");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    tam_info_dbl tiwelfinee = new tam_info_dbl();
                    tiwelfinee.setUrlmimg(snapshot.child("test").getValue().toString());
                    tiwelfinee.setUrlmimgg(snapshot.child("test1").getValue().toString());
                    tiwelfinee.setDescription(snapshot.child("manee").getValue().toString());
                    tiwelfinee.setDate(snapshot.child("name").getValue().toString());
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

        startActivity(new Intent(getApplicationContext(),Tasentrit.class));
        finish();

    }
}