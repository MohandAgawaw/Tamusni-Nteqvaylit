package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class photoanimaux extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<messages> messagesList;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query = Myref.child("ani");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    messages tiwelfinee = new messages();
                    tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                    tiwelfinee.setDescription(snapshot.child("name").getValue().toString());
                    messagesList.add(tiwelfinee);


                }


                adapter = new Adapter(getApplicationContext(),messagesList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),Tiwelfin.class));
        finish();
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

}
