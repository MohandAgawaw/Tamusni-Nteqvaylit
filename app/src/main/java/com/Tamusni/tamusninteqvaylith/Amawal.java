package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Amawal  extends AppCompatActivity {
    Button btn_nadi;
    private  final  int Time_Slash = 3500;
    EditText TextNadi;
    TextView resultattext,Cmb;
    WebView wbv;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_amawal);
        btn_nadi = findViewById(R.id.Nadha);
        TextNadi = findViewById(R.id.awalikk);
        Cmb = findViewById(R.id.cmb);
        resultattext = findViewById(R.id.RSLT);
        wbv = findViewById(R.id.Webvieww);
        ImageView img = findViewById(R.id.imglogo);
        dialog();
        img.setBackgroundResource(R.drawable.logo1);
        WebSettings webSettings = wbv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()) {
            Dialog dialog = new Dialog(this);


            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_alertediaa);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
            dialog.show();
            Button btnrt = dialog.findViewById(R.id.btnrtr);
            btnrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), Avantcentre.class));
                    finish();
                    recreate();
                }


            });


        }
        DatabaseReference Mdrii = FirebaseDatabase.getInstance().getReference("cmb");
        Mdrii.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Cmb.setText(dataSnapshot.child("valeur").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btn_nadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(TextNadi.getText().toString())) {
                    Toast.makeText(Amawal.this, "Aru Awal-ik (im) ", Toast.LENGTH_SHORT).show();


                } else {

                    DatabaseReference Mdrii = FirebaseDatabase.getInstance().getReference("Amawal");

                    Mdrii.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            String NASHI = TextNadi.getText().toString();

                            if (dataSnapshot.child(NASHI).exists()) {

                                resultattext.setText(dataSnapshot.child(NASHI).getValue().toString());

                                return;

                            } else {
                                DatabaseReference Mdriii = FirebaseDatabase.getInstance().getReference("azaz");
                                Mdriii.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                        String NASHI = TextNadi.getText().toString();

                                        if (dataSnapshot.child(NASHI).exists()) {

                                            resultattext.setText(dataSnapshot.child(NASHI).getValue().toString());
                                            return;

                                        } else {
                                            DatabaseReference Mdriii = FirebaseDatabase.getInstance().getReference("amawalwisin");
                                            Mdriii.addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                                    String NASHI = TextNadi.getText().toString();

                                                    if (dataSnapshot.child(NASHI).exists()) {

                                                        resultattext.setText(dataSnapshot.child(NASHI).getValue().toString());
                                                        return;

                                                    } else {

                                                        Toast.makeText(Amawal.this, "Ulac Awal agi deg mawal nagh ", Toast.LENGTH_SHORT).show();
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }


            }
        });
    }
    private void dialog() {
        progressDialog = new ProgressDialog(Amawal.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog_tamusni);

        LottieAnimationView lottieAnimationView = progressDialog.findViewById(R.id.ltrid);
        lottieAnimationView.setAnimation(R.raw.amawaldia);
        TextView textView = progressDialog.findViewById(R.id.idtexte);
        textView.setText("Ansuf ɣar Amawal");
        progressDialog.getWindow().setBackgroundDrawableResource(

                android.R.color.transparent

        );

        Button closedd = progressDialog.findViewById(R.id.closed);
        closedd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.hide();
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressDialog.hide();
            }
        };
        new Handler().postDelayed(runnable,Time_Slash);

    }

    @Override

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Avantcentre.class));


        finish();


    }

}
