package com.Tamusni.tamusninteqvaylith;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class tam_amezruy_videcase extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout cnx;
    private DatabaseReference Myref;
    private ArrayList<tam_info> messagesList;
    private tam_info_adap adapter;
    String number2;
    TextView textView;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_amezruy_videcase);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();
        cnx = findViewById(R.id.netlong);
        textView = findViewById(R.id.titelhis);
        number2 = getIntent().getStringExtra("number2");
        databaseReference = FirebaseDatabase.getInstance().getReference("Amezruy");
        textView.setText(number2);
    }
    protected void onStart() {
        super.onStart();

        databaseReference.child(number2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ClearAll();
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        tam_info tiwelfinee = new tam_info();
                        tiwelfinee.setDescription(snapshot.child("History").getValue().toString());
                        tiwelfinee.setDate(snapshot.child("Titel").getValue().toString());
                        tiwelfinee.setUrlmimg(snapshot.child("Pic").getValue().toString());
                        messagesList.add(tiwelfinee);


                    }

                    cnx.setVisibility(View.INVISIBLE);
                    adapter = new tam_info_adap(getApplicationContext(), messagesList);
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
        super.onBackPressed();
        finish();
    }
}