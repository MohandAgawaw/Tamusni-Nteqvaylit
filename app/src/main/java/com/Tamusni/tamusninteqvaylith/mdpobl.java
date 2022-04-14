package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.HashMap;

public class mdpobl extends AppCompatActivity {
    private  final  int Time_Slash = 3700;
    Button save;
    EditText name,isemm;
LinearLayout lnv,lns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdpobl);
        name = findViewById(R.id.editTex);
        isemm = findViewById(R.id.isem);
        save = findViewById(R.id.BTN_ar);
        lns = findViewById(R.id.sign);
        lnv = findViewById(R.id.validite);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().isEmpty()|| isemm.getText().toString().isEmpty()){
                    Toast.makeText(mdpobl.this,"aru",Toast.LENGTH_SHORT).show();
                    return;
                }

                upinfu();

            }
        });
        lnv.setVisibility(View.INVISIBLE);
    }



    private void upinfu() {
        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(isemm.getText().toString());
        parseUser.setEmail(name.getText().toString());
        parseUser.setPassword(isemm.getText().toString());
        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null){
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                            finish();
                        }
                    };
                    new Handler().postDelayed(runnable,Time_Slash);

                    Toast.makeText(mdpobl.this,"Dayen",Toast.LENGTH_SHORT).show();
                    lnv.setVisibility(View.VISIBLE);
                    lns.setVisibility(View.INVISIBLE);
                }else {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}