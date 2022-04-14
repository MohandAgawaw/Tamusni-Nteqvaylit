package com.Tamusni.tamusninteqvaylith;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
     Button btn_start,btn_tk,btn_fr;
LinearLayout lnfr,lntq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_tk = (Button) findViewById(R.id.btn_tk);
        btn_fr = (Button) findViewById(R.id.btn_fr);
        lnfr = findViewById(R.id.leanfr);
        lntq = findViewById(R.id.leantaq);

        lnfr.setVisibility(View.INVISIBLE);
      btn_start = (Button) findViewById(R.id.btn_one);

        btn_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnfr.setVisibility(View.INVISIBLE);
                lntq.setVisibility(View.VISIBLE);
            }
        });

        btn_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lntq.setVisibility(View.INVISIBLE);
                lnfr.setVisibility(View.VISIBLE);
            }
        });








        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
        fileList();
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();


    }
}
