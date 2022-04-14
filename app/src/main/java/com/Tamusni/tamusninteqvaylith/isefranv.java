package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class isefranv extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference Myref;
    private ArrayList<iseframsg> messagesList;
    private isadapter isadapter;
    ImageView imageView;
    LinearLayout cnx;
    TextView textView;
    DatabaseReference databaseReference;
    String number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isefranv);
        cnx = findViewById(R.id.netlong);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference("isefra");
        messagesList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("isefra");
        number2 = getIntent().getStringExtra("ise");
        imageView = findViewById(R.id.imageisefra);
        textView = findViewById(R.id.titelhis);
    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.child(number2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    Glide.with(getApplicationContext())
                            .load(dataSnapshot.child("pic").getValue().toString())
                            .into(imageView);
                    textView.setText(dataSnapshot.child("name").getValue().toString());

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Query query = Myref.child(number2).child("Isefra");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    iseframsg tiwelfinee = new iseframsg();
                    tiwelfinee.setDescription(snapshot.child("asefru").getValue().toString());

                    messagesList.add(tiwelfinee);
                }
                cnx.setVisibility(View.INVISIBLE);
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
}