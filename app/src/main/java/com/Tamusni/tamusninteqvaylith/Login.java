package com.Tamusni.tamusninteqvaylith;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.parse.Parse;
import com.parse.ParseInstallation;


public class Login extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private  final  int Time_Slash = 3000;

    FirebaseUser firebaseuser;
EditText editText,editemail;
Button btn_login,btnn;
ProgressBar pbr;
CheckBox chek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseuser = firebaseAuth.getCurrentUser();
        editemail = findViewById(R.id.editText3);
        editText = findViewById(R.id.editText);
        btn_login =  findViewById(R.id.BTN_ar);
        btnn =  findViewById(R.id.btnih);
        pbr =   findViewById(R.id.pBr);
        chek = findViewById(R.id.chek);
        pbr.setVisibility(View.INVISIBLE);


        SharedPreferences mPrefs = getSharedPreferences("cheke",MODE_PRIVATE);

        String cheke = mPrefs.getString("remembre", "");

        if(cheke.equals("true")){
            Intent ImLoggedIn = new Intent(getApplicationContext(), Avantcentre.class);
            startActivity(ImLoggedIn);
        }
        btnn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent ImLoggedIn = new Intent(getApplicationContext(), mdpobl.class);
        startActivity(ImLoggedIn);
    }
});

 chek.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked()){
            Toast.makeText(Login.this, "Teda", Toast.LENGTH_SHORT).show();
        }else if (!buttonView.isChecked()){
            Toast.makeText(Login.this, "T-kes", Toast.LENGTH_SHORT).show();
        }



    }
});








    btn_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String Email = editemail.getText().toString().trim();
            final String Password = editText.getText().toString().trim();
            try  {
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            } catch (Exception e) {

            }

            if(TextUtils.isEmpty(Email)){
                Toast.makeText(Login.this, "Aru Tirwat", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(Password)){
                Toast.makeText(Login.this, "Aru Awal Ufir", Toast.LENGTH_SHORT).show();
                return;
            }


            firebaseAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                if (chek.isChecked()){

                                    SharedPreferences   mPrefs = getSharedPreferences("cheke",MODE_PRIVATE);
                                    SharedPreferences.Editor editor = mPrefs.edit();
                                    editor.putString("remembre","true");
                                    editor.apply();

                                }else if (!chek.isChecked()){
                                    SharedPreferences mPrefs = getSharedPreferences("cheke",MODE_PRIVATE);
                                    SharedPreferences.Editor editor = mPrefs.edit();
                                    editor.putString("remembre","false");
                                    editor.apply();


                                }
                                pbr.setProgress(100);
                                pbr.setVisibility(View.VISIBLE);

                                Runnable runnable = new Runnable() {
                                    @Override
                                    public void run() {


                                        Intent ImLoggedIn = new Intent(getApplicationContext(), Avantcentre.class);
                                        startActivity(ImLoggedIn);
                                        Toast.makeText(Login.this, "Ansuf Yisek", Toast.LENGTH_SHORT).show();
                                        finishd();
                                    }
                                };
                                new Handler().postDelayed(runnable,Time_Slash);



                            } else {

                                Toast.makeText(Login.this, "Seɣti Tucda naɣ zer Tuqna azetta...", Toast.LENGTH_SHORT).show();

                            }




                        }
                    });
        }
    });
}

    private void finishd() {
        finish();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
        finish();

    }

}

