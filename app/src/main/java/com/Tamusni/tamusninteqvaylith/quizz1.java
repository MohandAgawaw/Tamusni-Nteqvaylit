package com.Tamusni.tamusninteqvaylith;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class quizz1 extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.tamusninteqvaylith.EXTRA_NUMBER";

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private TextView textViewLVL;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3,rb4;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private ArrayList<Questionnn> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Questionnn currentQuestion;
    private int score;
    private boolean answered;
    private long backPressedTime;
    ImageView img;

    private int rslt = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz1);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        img = findViewById(R.id.fotogame);
        textViewLVL = findViewById(R.id.text_view_difficulty);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(quizz1.this, "ile??naya-k (m) ! fren tiririt .", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });


        Intent intent = getIntent();
        String LVL = intent.getStringExtra(urarwisin.EXTRA_LVL);
        String sniper = intent.getStringExtra(urarwisin.EXTRA_DIFFICULTY);
        int iflvl = Integer.parseInt(LVL);
        String lvll = "LVL_"+LVL;
        if(iflvl != 6){
            textViewLVL.setText("Aswir :" + lvll);
            if (savedInstanceState == null) {
                QuizDpHelperrr dbHelperrr = new QuizDpHelperrr(this);
                questionList = dbHelperrr.getQuestions(lvll);
                questionCountTotal = questionList.size();
                Collections.shuffle(questionList);
                showNextQuestion();


            } else {
                questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
                questionCountTotal = questionList.size();
                questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
                currentQuestion = questionList.get(questionCounter - 1);
                score = savedInstanceState.getInt(KEY_SCORE);
                timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
                answered = savedInstanceState.getBoolean(KEY_ANSWERED);
                if (!answered) {
                    startCountDown();
                } else {
                    updateCountDownText();
                    showSolution();
                }
            }
        }else {

            textViewLVL.setText("Aswir :" + sniper);
            if (savedInstanceState == null) {
                QuizDpHelperrr dbHelperrr = new QuizDpHelperrr(this);
                questionList = dbHelperrr.getQuestions(sniper);
                questionCountTotal = questionList.size();
                Collections.shuffle(questionList);
                showNextQuestion();

            } else {
                questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
                questionCountTotal = questionList.size();
                questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
                currentQuestion = questionList.get(questionCounter - 1);
                score = savedInstanceState.getInt(KEY_SCORE);
                timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
                answered = savedInstanceState.getBoolean(KEY_ANSWERED);
                if (!answered) {
                    startCountDown();
                } else {
                    updateCountDownText();
                    showSolution();
                }
            }
        }

    }



    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);


        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestionnn());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            String IMAGS = currentQuestion.getPic();
            Picasso.get().load(IMAGS).resize(500,500).error(getResources().getIdentifier(IMAGS,"drawable",getPackageName())).into(img);

            questionCounter++;
            textViewQuestionCount.setText("Asteqsi: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Farned");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("agemu??? : " + score);
        }
        showSolution();
    }
    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getAnswerNr()) {
            case 1:

                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("D tiririt 1 ig wulmen  .");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("D tiririt 2 ig wulmen  .");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("D tiririt 3 ig wulmen  .");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("D tiririt 4 ig wulmen  .");
                break;
        }
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Asul");
        } else {
            buttonConfirmNext.setText("Yekfa");
        }
    }
    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();


        } else {
            Toast.makeText(this, "Tekki fell-as sin iberdan", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }







    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }
}