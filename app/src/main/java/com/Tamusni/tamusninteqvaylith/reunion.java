package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class reunion extends AppCompatActivity {
Button btn1,btn2;
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion);
        btn1 = findViewById(R.id.rjw);
        btn2 = findViewById(R.id.cree);
        editText = findViewById(R.id.cnfname);

        URL url;
        try {
            url = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions defoptn=
                    new JitsiMeetConferenceOptions.Builder().setServerURL(url).build();
            JitsiMeet.setDefaultConferenceOptions(defoptn);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setFeatureFlag("invite.enabled", false).setFeatureFlag("meeting-password.enabled", true).setRoom(editText.getText().toString())
                        .build();
                JitsiMeetActivity.launch(reunion.this,options);
                finish();
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = editText.getText().toString();
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, string);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Avantcentre.class));
        finish();
    }
}