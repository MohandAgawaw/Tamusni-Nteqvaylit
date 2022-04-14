package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tiwlafin_tiqdimin extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout cnx;
    private DatabaseReference Myref;
    private ArrayList<messages> messagesList;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiwlafin_tiqdimin);
        recyclerView = findViewById(R.id.RecyclerView);
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        cnx = findViewById(R.id.netlong);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Query query = Myref.child("tiwlafin_tiqdimin");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    messages tiwelfinee = new messages();
                    tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                    messagesList.add(tiwelfinee);


                }


                cnx.setVisibility(View.INVISIBLE);
                adapter = new Adapter(getApplicationContext(),messagesList);
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

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}