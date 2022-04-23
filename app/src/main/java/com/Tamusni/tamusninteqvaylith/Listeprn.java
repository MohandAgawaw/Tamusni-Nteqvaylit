package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Listeprn extends AppCompatActivity {
    RecyclerView recyclerView;
    Switch aSwitch;
    private  final  int Time_Slash = 3000;
    Button brn,close;
    DatabaseReference databaseReference,dr;
    FirebaseUser Userr;
    RelativeLayout linearLayout;
String sss="";
    LottieAnimationView lottieAnimationView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference Myref;
    private ArrayList<listeget> messagesListt;
int in;
    private listetype adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeprn);
        recyclerView = findViewById(R.id.RecyclerViewliste);
        aSwitch = findViewById(R.id.switchd);
        firebaseAuth = FirebaseAuth.getInstance();
        Userr = firebaseAuth.getCurrentUser();
        linearLayout = findViewById(R.id.dzzzz);
        brn = findViewById(R.id.btnrtr);
        close = findViewById(R.id.closed);
        dr = FirebaseDatabase.getInstance().getReference("LIKES");
        databaseReference = FirebaseDatabase.getInstance().getReference("student");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myref = FirebaseDatabase.getInstance().getReference();
        messagesListt = new ArrayList<>();
        lottieAnimationView = findViewById(R.id.ltrid);
        linearLayout.setVisibility(View.INVISIBLE);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("msg", "" + 0);
                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);
                linearLayout.setVisibility(View.INVISIBLE);
            }
        });



        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    String Name = "" + dataSnapshot.child("vib").getValue().toString();

                    if (Name.equals("1")){
                        aSwitch.setChecked(true);


                    }


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        brn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("msg", "" + 0);
                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);
                startActivity(new Intent(getApplicationContext(), aide.class));
                finish();
            }
        });
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("msg").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String Name = "" + dataSnapshot.getValue().toString();

                    if (Name.equals("1")){
                        linearLayout.setVisibility(View.VISIBLE);
                        lottieAnimationView.setAnimation(R.raw.web);



                    }else {
                        linearLayout.setVisibility(View.INVISIBLE);
                    }


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(aSwitch.isChecked()){

                    Toast.makeText(getApplicationContext(),"Dayen tettwaẓṛeḍ \uD83D\uDCA1 ",Toast.LENGTH_LONG).show();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("vib", "" + "1");
                    databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);


                }else {
                    Toast.makeText(getApplicationContext(),"Dayen Tettwafreḍ \uD83D\uDC7B ",Toast.LENGTH_LONG).show();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("vib", "" + "0");
                    databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);

                }

                upinfo(in);

            }
        });

    }

    private void upinfo(int in) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "" +0);
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);
        Query query = Myref.child("student");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    listeget tiwelfinee = new listeget();
                    String st = ""+ (snapshot.child("vib").getValue().toString());

                    if(st.equals("1")){
                        tiwelfinee.setPostid(snapshot.child("userid").getValue().toString());
                        tiwelfinee.setDescription(snapshot.child("like").getValue().toString());
                        tiwelfinee.setUrlmimg(snapshot.child("image").getValue().toString());
                        tiwelfinee.setNamechat(snapshot.child("nom").getValue().toString());
                        tiwelfinee.setPrenom(snapshot.child("prenom").getValue().toString());
                        tiwelfinee.setGenr(snapshot.child("gender").getValue().toString());
                        sss = snapshot.child("userid").getValue().toString();
                        messagesListt.add(tiwelfinee);

                    }


                }


                adapter = new listetype(getApplicationContext(),messagesListt);
                recyclerView.setAdapter(adapter);
                Collections.sort(messagesListt,listeget.Bylike);
                adapter.notifyDataSetChanged();


            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void ClearAll() {
        if (messagesListt != null ){
            messagesListt.clear();

            if ( adapter != null){
                adapter.notifyDataSetChanged();
            }
        }
        messagesListt = new ArrayList<>();
    }

    @Override

    public void onBackPressed() {

        super.onBackPressed();

        startActivity(new Intent(getApplicationContext(), Avantcentre.class));

        finish();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "" + 0);
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);

    }
}