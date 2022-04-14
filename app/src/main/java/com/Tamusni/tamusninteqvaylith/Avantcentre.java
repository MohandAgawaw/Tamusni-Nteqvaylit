package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.onesignal.OneSignal;

public class Avantcentre extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "12c0094d-c512-4889-ace0-391eb7ef9459";
    private long backPressedTime;
    private Toast backToast;
    Button deku,Urar,Timucuha,Amawal,Tamusni,Tiwelfin,isfra,groupe;
    private DatabaseReference Myref;
    SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avantcentre);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        groupe = findViewById(R.id.grp);
        SP = getApplicationContext().getSharedPreferences("NAME", 0);
        deku = findViewById(R.id.deku);
        isfra = findViewById(R.id.Isefra);
        Tiwelfin = findViewById(R.id.tiwelfin);
        Tamusni = findViewById(R.id.tamusni);
        Urar = findViewById(R.id.urar);

        Timucuha = findViewById(R.id.timucuha);
        Amawal = findViewById(R.id.amawal);
        Myref = FirebaseDatabase.getInstance().getReference();
        groupe.setText("Tajmaɛt \uD83D\uDDE3");
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        ImageView  img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);

        Query query = Myref.child("center");
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String titell =  dataSnapshot.child("value").getValue().toString();
                    String Name =  dataSnapshot.child("link").getValue().toString();


                    if(titell.equals("live")){
                        groupe.setVisibility(View.VISIBLE);
                        groupe.setText("Turra yella srid \uD83D\uDD34");
                        groupe.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                try {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + Name));
                                    startActivity(intent);
                                } catch (Exception e) {
                                    Intent intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + Name));
                                    startActivity(intent);
                                }
                            }
                        });
                    }else {
                        groupe.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent LogOut = new Intent(getApplicationContext(), reunion.class);
                                startActivity(LogOut);
                                finish();
                            }
                        });
                    }


                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        Urar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LogOut = new Intent(getApplicationContext(), Urar.class);
                startActivity(LogOut);
                finish();
            }
        });
        Amawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Amawal.class));
                finish();
            }
        });
        Tamusni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tamusni.class));
                finish();
            }
        });
        Tiwelfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Tiwelfin.class));
                finish();
            }
        });
        Timucuha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Timucuha.class));

                finish();
            }
        });
        isfra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ImLoggedIn = new Intent(getApplicationContext(), Isefra.class);
                startActivity(ImLoggedIn);
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        item.getIcon();

        if (id == R.id.item1){
            startActivity(new Intent(getApplicationContext(),Centrer.class));
            finish();
        }else if (id == R.id.item2){
            startActivity(new Intent(getApplicationContext(),Chats.class));
            finish();
        }else if (id == R.id.item2_1){
            startActivity(new Intent(getApplicationContext(),Listeprn.class));
            finish();
        }else if (id == R.id.item3){
            startActivity(new Intent(getApplicationContext(),aide.class));
            finish();
        }else if (id == R.id.item4){
            startActivity(new Intent(getApplicationContext(),Info.class));
            finish();
        }else if (id == R.id.item5){
            startActivity(new Intent(getApplicationContext(),BotiqueSplash.class));
            finish();
        }else if (id == R.id.deku){
            dekuu();
            finish();
        }


        return true;
    }



    private void dekuu() {
        SharedPreferences mPrefs = getSharedPreferences("cheke", MODE_PRIVATE);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("remembre", "false");
        editor.apply();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            moveTaskToBack(true);
            backToast.cancel();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            super.onBackPressed();
            finish();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Tekki fell-as sin iberdan", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();

    }
}