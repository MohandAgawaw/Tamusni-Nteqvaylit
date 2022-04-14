package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class urarwisin extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_LVL = "extraLVL";
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SHARED_PREFSS = "sharedPrefss";
    public static final String KEY_HIGHSCORE = "keyHighscoreee";
    public static final String KEY_lvl = "keyyyHighscore";
    Button buttonStartQuiz;
    private TextView textViewHighscore,textlvl;
    private int highscore = 0;
    private int rslt = 1;
    MediaPlayer mp;
    private Spinner spinnerDifficulty;
    Button pass;
Button btnevduurar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urarwisin);
        btnevduurar = findViewById(R.id.quizdu);
        textViewHighscore = findViewById(R.id.text_view_highscore);
        pass = findViewById(R.id.lvlpass);
        textlvl = findViewById(R.id.lvl);
        ImageView img = findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);
        String[] difficultyLevels = Questionnn.getLvll();

        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);
        spinnerDifficulty.setVisibility(View.INVISIBLE);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ref(1000);
                rslt += 1;
                updaterslt(rslt);

                if (pass.isPressed()){
                    highscore -= highscore;
                    updateHighscore(highscore);
                    Toast.makeText(urarwisin.this, "+1", Toast.LENGTH_SHORT).show();
                    pass.setTextColor(Color.parseColor("#C0BCBB"));
                    pass.setEnabled(false);

                }
            }




        });
        btnevduurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startQuiz();


            }
        });
    }

    private void startQuiz() {
        String LVL = String.valueOf(rslt);
        String difficulty = spinnerDifficulty.getSelectedItem().toString();
        Intent intent = new Intent(urarwisin.this, quizz1.class);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        intent.putExtra(EXTRA_LVL, LVL);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(quizz1.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }
    protected void onStart() {
        super.onStart();
        loadHighscore();
        loadlvl();


        if (rslt == 6){
            pass.setVisibility(View.INVISIBLE);
            spinnerDifficulty.setVisibility(View.VISIBLE);
        }else {



            if (highscore > 4) {

                if (rslt < 6) {

                    pass.setText("Sɛedi Aswir_" + rslt);
                    pass.setTextColor(Color.parseColor("#ff001e"));
                    pass.setEnabled(true);
                } else {
                    pass.setVisibility(View.INVISIBLE);

                }


            } else {

                pass.setText("Sɛedi Aswir " + rslt);
                pass.setTextColor(Color.parseColor("#C0BCBB"));
                pass.setEnabled(false);
            }

        }

    }
    private void Ref(int mili) {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                onStart();
            }
        };
        pass.postDelayed(runnable,mili);
    }
    private void loadlvl() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSS, MODE_PRIVATE);
        rslt = prefs.getInt(KEY_lvl, 1);

        textlvl.setText("Aswir : " + rslt);
    }
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("agemuḍ: " + highscore);
    }
    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("agemuḍ: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
    @SuppressLint("SetTextI18n")
    private void updaterslt(int rslt) {

        textlvl.setText("LVL : " + rslt);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_lvl, rslt);
        editor.apply();
    }
}