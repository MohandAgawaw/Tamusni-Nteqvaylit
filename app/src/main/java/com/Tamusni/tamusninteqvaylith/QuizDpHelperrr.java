package com.Tamusni.tamusninteqvaylith;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QuizDpHelperrr extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuizzz.db";

    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;



    public QuizDpHelperrr(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public QuizDpHelperrr(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContracttt.QuestionsTable.TABLE_NAME + " ( " +
                QuizContracttt.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContracttt.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContracttt.QuestionsTable.COLUMN_Pic + " TEXT, " +
                QuizContracttt.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContracttt.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContracttt.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContractt.QuestionsTablee.COLUMN_OPTION4 + " TEXT, " +
                QuizContracttt.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER," +
                QuizContracttt.QuestionsTable.COLUMN_LVL + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    private void fillQuestionsTable() {
        Questionnn q1 = new Questionnn("Isem-is","aberwaq", "Ṛiḥan", "Aberwaq", "Agurim","Tactiwin", 2 , Questionnn.LVL_1_1);
        addQuestionnn(q1);
        Questionnn q2 = new Questionnn("Isem-is","abusna", "Amagraman", "Mejjir", "Iskerci","Abusna", 4 , Questionnn.LVL_1_1);
        addQuestionnn(q2);
        Questionnn q3 = new Questionnn("Isem-is","acikaw", "Tactiwin", "Tasselɣa", "Amagraman","Acikaw", 4 , Questionnn.LVL_1_1);
        addQuestionnn(q3);
        Questionnn q4 = new Questionnn("Isem-is","illili", "Illili", "Tiskert", "Tifeɣwet","Bibṛaṣ", 1 , Questionnn.LVL_1_1);
        addQuestionnn(q4);
        Questionnn q5 = new Questionnn("Isem-is","tasemmumt", "Iskerci", "Tasemmumt", "Tiskert","Bibṛaṣ", 2 , Questionnn.LVL_1_1);
        addQuestionnn(q5);
        Questionnn q6 = new Questionnn("Isem-is","aweqas", "aqirniḍ", "tafyfart", "tazarumid","Aweqas", 4 , Questionnn.LVL_2_2);
        addQuestionnn(q6);
        Questionnn q7 = new Questionnn("Isem-is","aginwir", "abesmar", "Aɣinwir", "aḍahin","tazebrumt", 2 , Questionnn.LVL_2_2);
        addQuestionnn(q7);
        Questionnn q8 = new Questionnn("Isem-is","amehri", "tafyfart", "aḍahin", "abesmar","Amehri", 4 , Questionnn.LVL_2_2);
        addQuestionnn(q8);
        Questionnn q9 = new Questionnn("Isem-is","agumar", "Agumaṛ", "abesmar", "tazarumid ","aqirniḍ", 1 , Questionnn.LVL_2_2);
        addQuestionnn(q9);
        Questionnn q10 = new Questionnn("Isem-is","tadgagatt", "abareɣ", "acebbirdu", "Tadɣaɣatt","ifis", 3 , Questionnn.LVL_2_2);
        addQuestionnn(q10);
        Questionnn q11 = new Questionnn("Isem-is","acerra", "aqecwal", "aḍelaɛ", "aceṛṛaɛ","aṛremuɛ", 3 , Questionnn.LVL_3_3);
        addQuestionnn(q11);
        Questionnn q12 = new Questionnn("Isem-is","arssem", "sṛima", "Tacqimt", "Rkav","Arssem", 4 , Questionnn.LVL_3_3);
        addQuestionnn(q12);
        Questionnn q13 = new Questionnn("Isem-is","tinqalin", "Tinqalin", "Tabarda", "Acewri","Azenbil", 1 , Questionnn.LVL_3_3);
        addQuestionnn(q13);
        Questionnn q14 = new Questionnn("Isem-is","zevra", "Uzal", "Edraɛ", "Zevra","Abarwaq", 3 , Questionnn.LVL_3_3);
        addQuestionnn(q14);
        Questionnn q15 = new Questionnn("Isem-is","tagrast", "aḍelaɛ", "Taɣṛast n ḥelfa", "aqecwal","aceṛṛaɛ", 2 , Questionnn.LVL_3_3);
        addQuestionnn(q15);
        Questionnn q16 = new Questionnn("Isem-is","abz", "Tisemsemt", "abzim", "Taɛeṣṣabt","Talullit", 2 , Questionnn.LVL_4_4);
        addQuestionnn(q16);
        Questionnn q17 = new Questionnn("Isem-is","taxabact", "Abruc", "Talullit", "Igeḍmen","Taxabact", 4 , Questionnn.LVL_4_4);
        addQuestionnn(q17);
        Questionnn q18 = new Questionnn("Isem-is","axellal", "Axellal", "abzim", "Tisemsemt","Taɛeṣṣabt", 1 , Questionnn.LVL_4_4);
        addQuestionnn(q18);
        Questionnn q19 = new Questionnn("Isem-is","ardif", "Taɛeṣṣabt", "Ardif", "Tisemsemt","Abagus", 2 , Questionnn.LVL_4_4);
        addQuestionnn(q19);
        Questionnn q20 = new Questionnn("Isem-is","ixelxalen", "Imeqyasen", "Ixelxalen", "Taɛeṣṣabt","Abagus", 2 , Questionnn.LVL_4_4);
        addQuestionnn(q20);
        Questionnn q21 = new Questionnn("Isem-is","aferrug", "Aɣanim", "Talwaḥt", "Aferruğ","Abraḥ", 3 , Questionnn.LVL_5_5);
        addQuestionnn(q21);
        Questionnn q22 = new Questionnn("Isem-is","acbayli", "Akuffi", "Tabetit", "Aqecwal","Acbayli", 4 , Questionnn.LVL_5_5);
        addQuestionnn(q22);
        Questionnn q23 = new Questionnn("Isem-is","akuffi", "Akuffi", "Acbayli", "Tabetit","Aqecwal", 1 , Questionnn.LVL_5_5);
        addQuestionnn(q23);
        Questionnn q24 = new Questionnn("Isem-is","ayazil", "Ayazil", "Aqardac", "Tafarcit","Midudan", 1 , Questionnn.LVL_5_5);
        addQuestionnn(q24);
        Questionnn q25 = new Questionnn("Isem-is","abar", "Axnec", "Tafala", "Aɛbar","taceṭṭabit", 3 , Questionnn.LVL_5_5);
        addQuestionnn(q25);

    }

    private void addQuestionnn(Questionnn questionnn) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContracttt.QuestionsTable.COLUMN_QUESTION, questionnn.getQuestionnn());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_Pic, questionnn.getPic());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_OPTION1, questionnn.getOption1());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_OPTION2, questionnn.getOption2());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_OPTION3, questionnn.getOption3());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_OPTION4, questionnn.getOption4());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_ANSWER_NR, questionnn.getAnswerNr());
        cv.put(QuizContracttt.QuestionsTable.COLUMN_LVL, questionnn.getLVL());
        db.insert(QuizContracttt.QuestionsTable.TABLE_NAME, null, cv);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContracttt.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }


    @SuppressLint("Range")
    public ArrayList<Questionnn> getAllQuestionnns() {
        ArrayList<Questionnn> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContracttt.QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Questionnn questionnn = new Questionnn();
                questionnn.setQuestionnn(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_QUESTION)));
                questionnn.setPic(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_Pic)));
                questionnn.setOption1(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION1)));
                questionnn.setOption2(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION2)));
                questionnn.setOption3(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION3)));
                questionnn.setOption4(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION4)));
                questionnn.setAnswerNr(c.getInt(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_ANSWER_NR)));
                questionnn.setLVL(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_LVL)));
                questionList.add(questionnn);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    @SuppressLint("Range")
    public ArrayList<Questionnn> getQuestions(String LVL) {
        ArrayList<Questionnn> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{LVL};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContracttt.QuestionsTable.TABLE_NAME +
                " WHERE " + QuizContracttt.QuestionsTable.COLUMN_LVL + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Questionnn questionnn = new Questionnn();
                questionnn.setQuestionnn(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_QUESTION)));
                questionnn.setPic(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_Pic)));
                questionnn.setOption1(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION1)));
                questionnn.setOption2(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION2)));
                questionnn.setOption3(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION3)));
                questionnn.setOption4(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_OPTION4)));
                questionnn.setAnswerNr(c.getInt(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_ANSWER_NR)));
                questionnn.setLVL(c.getString(c.getColumnIndex(QuizContracttt.QuestionsTable.COLUMN_LVL)));
                questionList.add(questionnn);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
