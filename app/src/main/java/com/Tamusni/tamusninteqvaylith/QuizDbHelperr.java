package com.Tamusni.tamusninteqvaylith;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelperr extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuizz.db";

    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;
    public QuizDbHelperr(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContractt.QuestionsTablee.TABLE_NAME + " ( " +
                QuizContractt.QuestionsTablee._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContractt.QuestionsTablee.COLUMN_QUESTION + " TEXT, " +
                QuizContractt.QuestionsTablee.COLUMN_OPTION1 + " TEXT, " +
                QuizContractt.QuestionsTablee.COLUMN_OPTION2 + " TEXT, " +
                QuizContractt.QuestionsTablee.COLUMN_OPTION3 + " TEXT, " +
                QuizContractt.QuestionsTablee.COLUMN_OPTION4 + " TEXT, " +
                QuizContractt.QuestionsTablee.COLUMN_ANSWER_NR + " INTEGER," +
                QuizContractt.QuestionsTablee.COLUMN_DIFFICULTY + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTablee();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContractt.QuestionsTablee.TABLE_NAME);
        onCreate(db);
    }
    private void fillQuestionsTablee() {
        Questionn q1 = new Questionn(" d Aylak d wiyad i tisldaccen wala kecc", "d-isem-ik", "idrimen-ik", "Tawlaft-ik","Amur-ik", 1,Questionn.LVL_1_1);
        addQuestionn(q1);
        Questionn q2 = new Questionn("Tesεa aqmmuc ur tesεi uglan, tesεa aεbude ur tesεi izarman, teεa ifasen ur tesεi idaren", "Afus", "Adar", "Sebadh","Acetid", 3,Questionn.LVL_1_1);
        addQuestionn(q2);
        Questionn q3 = new Questionn("itedu ar zdat, itedu ar defir, ur yelsi acttid, ur t-inaq usmid, ur tinaq ukkeffir ", "Tikli", "Adu", "Tilli","Aman", 3,Questionn.LVL_1_1);
        addQuestionn(q3);
        Questionn q4 = new Questionn(" ewtaɣt ar lqaεa yugi adiarez, ewtaɣt ar temda yefruri", "kaghed", "Adlis", "Agemad","Abahri", 1,Questionn.LVL_1_1);
        addQuestionn(q4);
        Questionn q5 = new Questionn("Yerfed acḥal d aqenṭar ur as-yezmir i umeṣmar", "Assif", "Illel", "Agefur","Adfel", 2,Questionn.LVL_1_1);
        addQuestionn(q5);
        Questionn q6 = new Questionn("Thadarth imdhrifen wa ur itla3i wa", "Timqvart", "Assif", "tasumta","tayla", 1,Questionn.LVL_2_2);
        addQuestionn(q6);
        Questionn q7 = new Questionn("Jeddi boura3douf yettezi yetouffe", "tigẓelt", "izi", "Taɣeṛma","aɣilas", 2,Questionn.LVL_2_2);
        addQuestionn(q7);
        Questionn q8 = new Questionn("L3insa3 sedaw uzru sum ad ydu", "axṛib", "anzaren", "ul","axili", 2,Questionn.LVL_2_2);
        addQuestionn(q8);
        Questionn q9 = new Questionn("D iḥlalaḍen d iblalaḍen ulac tamurt ur wiḍen", "idrimen", "ṛṛay", "llsas","zzher", 1,Questionn.LVL_2_2);
        addQuestionn(q9);
        Questionn q10 = new Questionn("10 n ṭṭelbat qelben tilwiḥin-nsent ar defir", "awrir", "timezgida", "iccaren","iɣid", 3,Questionn.LVL_2_2);
        addQuestionn(q10);
        Questionn q11 = new Questionn("Tesεa ayefki ur tettaẓeg .tesεa afriwen ur tettafeg", "tafunast", "tafruxt", "taneqleţ","taghat", 3,Questionn.LVL_3_3);
        addQuestionn(q11);
        Questionn q12 = new Questionn("Aεeqqa n yirden yeččur axxam", "ass", "taftilt", "itij","avrid", 2,Questionn.LVL_3_3);
        addQuestionn(q12);
        Questionn q13 = new Questionn("Jeddi meεkikuf mi teεkef te3rurt iṣub s azaɣar yewwi-d tasekurt", "taqulaεt", "taqubet", "taqjunt","adu", 1,Questionn.LVL_3_3);
        addQuestionn(q13);
        Questionn q14 = new Questionn("Ţzaleɣ ţazaleɣ ur qḍiεeɣ mmis n uweday", "d abrid", "d adu", "d tilli","d axxam", 1,Questionn.LVL_3_3);
        addQuestionn(q14);
        Questionn q15 = new Questionn("Ibbed di tizi yeɣar a zizi", "d afrux", "d amcic", "d ayaẓiḍ", "d azger",3,Questionn.LVL_3_3);
        addQuestionn(q15);
        Questionn q16= new Questionn("Ɛemmi εmarra yetturar cṭara yettaǧa rrbayeḥ yettawi lexṣṣara", "iɣi", "aɣerbal", "ahlalas", "abeckid",2,Questionn.LVL_4_4);
        addQuestionn(q16);
        Questionn q17 = new Questionn("Yeggul ad iεeddi ɣasbma taggara-as d lmut", "tayri", "assirem", "tilleli", "tafat",2,Questionn.LVL_4_4);
        addQuestionn(q17);
        Questionn q18 = new Questionn("Takurt n lxiḍ tetturar af serrir", "tissist", "aman", "tafruxt", "tayazit",1,Questionn.LVL_4_4);
        addQuestionn(q18);
        Questionn q19 = new Questionn("lεesker daxel n lḥebs win d-ifɣen ad tečč tmes", "tawwurt", "awren", "awwu", "tafeka",3,Questionn.LVL_4_4);
        addQuestionn(q19);
        Questionn q20 = new Questionn("Yebges yexnunes", "tameɣra", "imeṣṣleḥ", "esvar","arbah", 2,Questionn.LVL_4_4);
        addQuestionn(q20);
        Questionn q21 = new Questionn("Snat n tsetmatin ur ttemẓarat", "immi", "tafat", "alen", "tamuɣli",3,Questionn.LVL_5_5);
        addQuestionn(q21);
        Questionn q22 = new Questionn("Yedduri maεna yebzeg", "ifasen", "iles", "aman", "tilleli",2,Questionn.LVL_5_5);
        addQuestionn(q22);
        Questionn q23 = new Questionn("Taεekkazt n belεebbas tettazal am yiḍ am wass", "assif", "illel", "tafsut", "agfur",1,Questionn.LVL_5_5);
        addQuestionn(q23);
        Questionn q24 = new Questionn("Yekker yilef di ḥemza ḍefren-t-id di xemsa", "utci", "tilkit", "atan","adfel", 2,Questionn.LVL_5_5);
        addQuestionn(q24);
        Questionn q25 = new Questionn("Yettḍili-d ur d-ikeččem", "adu", "amnar n tewwurt", "abarani","aɣarsiw", 2,Questionn.LVL_5_5);
        addQuestionn(q25);

    }
    private void addQuestionn(Questionn questionn) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContractt.QuestionsTablee.COLUMN_QUESTION, questionn.getQuestionn());
        cv.put(QuizContractt.QuestionsTablee.COLUMN_OPTION1, questionn.getOption1());
        cv.put(QuizContractt.QuestionsTablee.COLUMN_OPTION2, questionn.getOption2());
        cv.put(QuizContractt.QuestionsTablee.COLUMN_OPTION3, questionn.getOption3());
        cv.put(QuizContractt.QuestionsTablee.COLUMN_OPTION4, questionn.getOption4());
        cv.put(QuizContractt.QuestionsTablee.COLUMN_ANSWER_NR, questionn.getAnswerNr());
        cv.put(QuizContractt.QuestionsTablee.COLUMN_DIFFICULTY, questionn.getDifficulty());
        db.insert(QuizContractt.QuestionsTablee.TABLE_NAME, null, cv);
    }
    @SuppressLint("Range")
    public ArrayList<Questionn> getAllQuestions() {
        ArrayList<Questionn> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContractt.QuestionsTablee.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Questionn questionn = new Questionn();
                questionn.setQuestionn(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_QUESTION)));
                questionn.setOption1(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION1)));
                questionn.setOption2(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION2)));
                questionn.setOption3(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION3)));
                questionn.setOption4(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION4)));
                questionn.setAnswerNr(c.getInt(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_ANSWER_NR)));
                questionn.setDifficulty(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_DIFFICULTY)));
                questionList.add(questionn);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    @SuppressLint("Range")
    public ArrayList<Questionn> getQuestionn(String difficulty) {
        ArrayList<Questionn> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] select = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContractt.QuestionsTablee.TABLE_NAME + " WHERE " +
                        QuizContractt.QuestionsTablee.COLUMN_DIFFICULTY + " = ?", select);
        if (c.moveToFirst()) {
            do {
                Questionn questionn = new Questionn();
                questionn.setQuestionn(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_QUESTION)));
                questionn.setOption1(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION1)));
                questionn.setOption2(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION2)));
                questionn.setOption3(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION3)));
                questionn.setOption4(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_OPTION4)));
                questionn.setAnswerNr(c.getInt(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_ANSWER_NR)));
                questionn.setDifficulty(c.getString(c.getColumnIndex(QuizContractt.QuestionsTablee.COLUMN_DIFFICULTY)));
                questionList.add(questionn);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
