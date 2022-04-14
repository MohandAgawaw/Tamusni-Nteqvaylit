package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.parse.Parse;
import com.parse.ParseInstallation;

import worker8.com.github.radiogroupplus.RadioGroupPlus;


public class Inscription extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private int STORAGE_PERMISSION_CODE = 1;
    WebView wbv;
    private DatabaseReference Myref;
    EditText Nome,Prenom,txt_EMAIL,Pass,Passs;
   Button Inscrir;
    RadioGroupPlus radioGroup;
    RadioButton radioButton;
   RadioButton AmalaY,Unthi;
    DatabaseReference datebaseReference;
    String gender="";
    ProgressBar pbr1;

    StorageReference storageReference;
    FirebaseStorage Store;
    private DatabaseReference mDatabaseRef;
    private static final int PICK_IMAGE = 1;
    private StorageReference mStorageRef;
    String titell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        radioGroup = findViewById(R.id.radioGroup);
        mStorageRef = FirebaseStorage.getInstance().getReference("student");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("student");
        Store = FirebaseStorage.getInstance();
        storageReference = Store.getReference();
        ParseInstallation.getCurrentInstallation().saveInBackground();
        Nome = findViewById(R.id.editText4);
      Prenom = findViewById(R.id.editText5);
        Myref = FirebaseDatabase.getInstance().getReference();
      txt_EMAIL = findViewById(R.id.editText6);
      Pass = findViewById(R.id.editText10);
      Passs = findViewById(R.id.editText11);
      pbr1 =  findViewById(R.id.pBr1);
      Inscrir = findViewById(R.id.inscrir);
      AmalaY = findViewById(R.id.radioButton);
      Unthi =  findViewById(R.id.radioButton2);
        DatabaseReference Mdriii = FirebaseDatabase.getInstance().getReference("awalndiri");
        datebaseReference = FirebaseDatabase.getInstance().getReference("student");
        firebaseAuth =FirebaseAuth.getInstance();
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);


        Query query = Myref.child("inscription");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                     titell = "" + dataSnapshot.child("link").getValue().toString();



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        pbr1.setVisibility(View.INVISIBLE);

        wbv = findViewById(R.id.Webviewww);
        WebSettings webSettings = wbv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()|| !networkInfo.isAvailable()){
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
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                    finish();
                    recreate();
                }


            });


        }

        Inscrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mdriii.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(Nome.getText().toString()).exists() ) {
                            if (TextUtils.isEmpty(Nome.getText().toString())) {
                                Toast.makeText(Inscription.this, "Aru Isem", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            Toast.makeText(Inscription.this, "Dacut Trevga Agi ?", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (dataSnapshot.child(Prenom.getText().toString()).exists()) {
                            if (TextUtils.isEmpty(Prenom.getText().toString())) {
                                Toast.makeText(Inscription.this, "Aru Nqama", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            Toast.makeText(Inscription.this, "Dacut Trevga Agi ?", Toast.LENGTH_SHORT).show();
                            return;
                        }else {
                            final String Nom = Nome.getText().toString().trim();
                            final String Email = txt_EMAIL.getText().toString().trim();
                            final String Password = Pass.getText().toString().trim();
                            final String prenom = Prenom.getText().toString().trim();
                            final String password = Passs.getText().toString().trim();
                            final  String img = titell;
                            final  String licked = "0";
                            final  String visibilite = "0";
                            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                            String passptr = "[a-zA-Z0-9._-]+[0-9]";
                            if (!Email.matches(emailPattern) && Email.length() > 0)
                            {
                                Toast.makeText(Inscription.this, "Aru Tirwat @amedya.com", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(Email))
                            {
                                Toast.makeText(Inscription.this, "Aru Tirwat @amedya.com", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (Password.length() < 5) {

                                if(TextUtils.isEmpty(Password)){
                                    Toast.makeText(Inscription.this, "Aru Awal Ufir", Toast.LENGTH_SHORT).show();
                                    return;
                                }else {
                                    Toast.makeText(Inscription.this, "Aru Awal Ufir ad yes3u senig 5 isekilen", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                            if(!Password.matches(passptr)){
                                Toast.makeText(Inscription.this, "Aru isekilen a-z aked uttun 0-9", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(prenom)) {
                                Toast.makeText(Inscription.this, "Aru Nqama", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (!(password.equals(Password))) {
                                Toast.makeText(Inscription.this, "Seɣ awal uffir wissin", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(Nom)) {
                                Toast.makeText(Inscription.this, "Aru Isem", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (AmalaY.isChecked()) {
                                gender = "Amalay";
                            } else if (Unthi.isChecked()) {
                                gender = "Unti";
                            }else {
                                Toast.makeText(Inscription.this, "Amalay Niɣ Unti ? ", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            firebaseAuth.createUserWithEmailAndPassword(Email, password)
                                    .addOnCompleteListener(Inscription.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {

                                                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                                String userid = firebaseUser.getUid();

                                                pbr1.setVisibility(View.VISIBLE);
                                                pbr1.setProgress(100);
                                                student information = new student(

                                                        img, Nom, prenom, Email, Password, gender, licked, visibilite, userid

                                                );

                                                FirebaseDatabase.getInstance().getReference("student").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                        .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {


                                                    @SuppressLint("ResourceType")
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {


                                                        Toast.makeText(Inscription.this, "Tettwajṛeḍ akken iwata...", Toast.LENGTH_SHORT).show();
                                                        startActivity(new Intent(getApplicationContext(), Login.class));

                                                        finish();



                                                    }
                                                });
                                            } else {
                                                if(gender.equals("Amalay")){
                                                    Toast.makeText(Inscription.this, "Tirwat inek  tettwaxdem yakan", Toast.LENGTH_SHORT).show();

                                                }else {
                                                    Toast.makeText(Inscription.this, "Tirwat inem tettwaxdem yakan", Toast.LENGTH_SHORT).show();

                                                }

                                            }

                                        }
                                    });


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                try  {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
            }
        });
    }



    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();

    }
}

