package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;

public class modefie extends AppCompatActivity {
Button exit,save;
EditText name,Prename;
TextView mail;
    DatabaseReference databaseReference;
    FirebaseUser Userr;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modefie);
        save = findViewById(R.id.saved);
        exit = findViewById(R.id.exit);
        name = findViewById(R.id.idname);
        mail = findViewById(R.id.idemail);
        Prename = findViewById(R.id.idprename);







        firebaseAuth = FirebaseAuth.getInstance();
        Userr = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("student");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().isEmpty()|| Prename.getText().toString().isEmpty()){
                    Toast.makeText(modefie.this,"Aru ayen teǧǧiḍ d ilem...",Toast.LENGTH_SHORT).show();
                    return;
                }
                upinfu();
                try  {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
            }
        });
        getUserinfo();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void upinfu() {
        DatabaseReference Mdriii = FirebaseDatabase.getInstance().getReference("awalndiri");
        Mdriii.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String NASHI = name.getText().toString();
                String NASHII = Prename.getText().toString();

                if (dataSnapshot.child(NASHI).exists() ) {

                    Toast.makeText(modefie.this, "Dacut Trevga Agi ? ", Toast.LENGTH_SHORT).show();


                } else {
                    if (dataSnapshot.child(NASHII).exists() ) {
                        Toast.makeText(modefie.this, "Dacut Trevga Agi ? ", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    final String NAME = name.getText().toString().trim();
                    final String Prenomm = Prename.getText().toString().trim();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("nom", "" + NAME);
                    hashMap.put("prenom", "" + Prenomm);
                    databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);
                    Toast.makeText(modefie.this,"Dayen",Toast.LENGTH_SHORT).show();
                    finish();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void getUserinfo() {
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    String Name = "" + dataSnapshot.child("nom").getValue().toString();
                    String Mail = ""+ dataSnapshot.child("email").getValue().toString();
                    String Prenom = "" + dataSnapshot.child("prenom").getValue().toString();

                    mail.setText(Mail);
                    name.setText(Name);
                    Prename.setText(Prenom);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}