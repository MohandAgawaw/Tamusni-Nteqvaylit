package com.Tamusni.tamusninteqvaylith;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";

    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;



    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER," +
                QuizContract.QuestionsTable.COLUMN_LVL + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    private void fillQuestionsTable() {
        Question q1_1 = new Question("anwa i d_yennan asefru_agi :\n" +
                "Aɛdaw d lxadeɛ ..aḥbib d ṭṭameɛ..ala Ṛebbi ma yecfeɛ . ", "Arezqi Ul Bacir", "Ccix Muḥend Ulḥusin", "Ahmed Belɛid","Ahmed Lahlu", 2 ,Question.LVL_1_1);
        addQuestion(q1_1);
        Question q2_2 = new Question("anda i yemmut Si Muḥ Umḥend ? ", "Micli -Asqif N'Tmana", "Micli -At Buyusef", "Micli -At Hicem","Micli -Tala N Wudi", 1 , Question.LVL_1_1);
        addQuestion(q2_2);
        Question q3_3 = new Question("anwa i yuran adlis_a -mmis igellil..!?", "Mulud At Mɛammer", "Muḥia", "Ṭaher Ǧaɛut","Mulud Ferɛun", 4 , Question.LVL_1_1);
        addQuestion(q3_3);
        Question q4_4 = new Question("anwa i ymesgan ukkud Ccix Muḥend Ulḥusin !?!", "Muḥ Umḥend", "Ccix Mukrani", "Arezqi Ul Bacir","Ahmed U el Kadhi", 1 , Question.LVL_1_1);
        addQuestion(q4_4);
        Question q5_5 = new Question("melmi i nɣan Ṭaher Ǧaɛut !?", "02 deg yunyu 1991", "02 deg yunyu 1993", "06 deg yunyu 1993","02 deg yunyu 1998", 2 , Question.LVL_1_1);
        addQuestion(q5_5);
        Question q6 = new Question("amek i as_qqaren i jsk zik ger useggas n 1974-1977!?", "JS Tizi ouzou", "JS Kabylie", "JS kawkabi","Jeunesse Électronique Tizi-Ouzou", 3 , Question.LVL_2_2);
        addQuestion(q6);
        Question q7 = new Question("melmi i tiwwi JSK tarbaɛt nilmeẓyen n leqbayel taqbuct_is tamenzut n la CAF !??", "Deg useggas n 1999", "Deg useggas n 2000", "Deg useggas n 2001","Deg useggas n 2002", 2 , Question.LVL_2_2);
        addQuestion(q7);
        Question q8 = new Question("melmi i d talalit n le \"MOB\"!!", "03 deg yulyu 1957", "06 deg yulyu 1953", "05 deg yulyu 1955","05 deg yulyu 1954", 4 , Question.LVL_2_2);
        addQuestion(q8);
        Question q9 = new Question("melmi i tiwwi Mob taqbuct_is n Lezzayer tamenzut !?", "02 deg mayyu 2015", "03 deg mayyu 2014", "02 deg mayyu 2017","02 deg mayyu 2012", 1 , Question.LVL_2_2);
        addQuestion(q9);
        Question q10 = new Question("melmi d talalit n \"jsmb\"!??", "17 deg mayyu 1933", "17 deg mayyu 1936", "17 deg mayyu 1931","17 deg mayyu 1939", 2 , Question.LVL_2_2);
        addQuestion(q10);
        Question q11_11 = new Question("azemz n lmut n unaẓur Sliman Ɛazem ?", "28 deg yennayer 1988", "29 deg yennayer 1983", "20 deg yennayer 1983","28 deg yennayer 1983", 4 , Question.LVL_3_3);
        addQuestion(q11_11);
        Question q12_12 = new Question("anwa i yecnan tizlit_a \"ewwet nneḥ \"?", "Ulaḥlu", "Sliman Ɛazem", "Ḥamiduc","Ḥasen aḥris", 4 , Question.LVL_3_3);
        addQuestion(q12_12);
        Question q13_13 = new Question("anwa i yecnan tizlit_a \"Tiwizt n ṭnac ..\"?", "Ḥamiduc", "Ulaḥlu", "Takfarinas","Idir", 1 , Question.LVL_3_3);
        addQuestion(q13_13);
        Question q14_14 = new Question("melmi i d_teffeɣ tesfift n da Lwennas \"Err_as tili\"?", "Deg useggas 1984", "Deg useggas 1987", "Deg useggas 1988","Deg useggas 1986", 4 , Question.LVL_3_3);
        addQuestion(q14_14);
        Question q15_15 = new Question("anwa yecnan tizlit_agi \"Awer timlilit\"?", "Lewnis At Mengellat", "Ayt Meslayen", "Zdek Mulud","Farid Farragui", 3 , Question.LVL_3_3);
        addQuestion(q15_15);
        Question q16_16 = new Question("acḥal yesɛa Weẓru uselgu deg teɣzi ?", "1900 n lmitrat", "1860 n lmitrat", "1887 n lmitrat","1884 n lmitrat", 4 , Question.LVL_4_4);
        addQuestion(q16_16);
        Question q17_17 = new Question("Anda i d_tuzga taddart n Aḥmed Ulqaḍi ?", "At WaƐben , Micli", "At Mengelat , Micli", "At Yeḥya , Micli","Ililten , Micli", 3 , Question.LVL_4_4);
        addQuestion(q17_17);
        Question q18_18 = new Question("anda i d_yuzga Weẓru uɣeddu ?", "Iwaḍiyen", "Vuɣni", "Mizrana","AƐfir", 3 , Question.LVL_4_4);
        addQuestion(q18_18);
        Question q19_19 = new Question("anda i d_yuzga ugelmim aberkan ?", "Iɛekkuren", "Adekar", "Iɛeẓẓugen","Akfadu", 4 , Question.LVL_4_4);
        addQuestion(q19_19);
        Question q20_20= new Question("anda i d_yuzga lemqam n jeddi Mangellat ?", "Micli ,At Mangellat", "Micli ,At Buyusef", "Micli ,At Hicem","Micli ,At WaƐben", 1 , Question.LVL_4_4);
        addQuestion(q20_20);
        Question q21_21 = new Question("melmi i teɣli tgelda n Kuku..?", "Deg useggas n 1618", "Deg useggas n 1619", "Deg useggas n 1519","Deg useggas n 1620", 2 , Question.LVL_5_5);
        addQuestion(q21_21);
        Question q22_22 = new Question("ukkud i yennuɣ ugellid Frimus ?", "Aṛumi", "Afransi", "AƐrab","Atarki", 1 , Question.LVL_5_5);
        addQuestion(q22_22);
        Question q23_23 = new Question("At Qasi ḥekmen seg Tizi ɣer Tizi..anda ?", "tizi n'berber,Tizi n At ɛica", "Tizi Wezzu,Tizi n At ɛica", "Tizi n At ɛica, Tizi ukefadu","Tizi-Raced,Tizi ukefadu", 3 , Question.LVL_5_5);
        addQuestion(q23_23);
        Question q24_24 = new Question("acḥal imnayen i tesɛa tgelda n Kuku !", "80", "300", "260","120", 4 , Question.LVL_5_5);
        addQuestion(q24_24);
        Question q25_25 = new Question("acḥal iseggasen i yeḥkem Aḥmed Ulqaḍi... deg Lezzayer tamanaɣt ?", "6 iseggasen", "7 iseggasen", "2 iseggasen","10 iseggasen", 2 , Question.LVL_5_5);
        addQuestion(q25_25);
        Question q26_26 = new Question("ɣef anwa i d_ttmeslay Tisira n Ɛmeṛ Ftuc..?","Jeddi Ilul","Jeddi Atuf","Jeddi adil","Jeddi Anan",2,Question.LVL_6_6);
        addQuestion(q26_26);
        Question q27_27 = new Question("acḥal i tesɛa deg iseggasen igeldamen deg Weqbu..?","2500 iseggasen ɣer deffir","7160 iseggasen ɣer deffir","1560 iseggasen ɣer deffir","260 iseggasen ɣer deffir",2,Question.LVL_6_6);
        addQuestion(q27_27);
        Question q28_28 = new Question("acḥal n tarwa i yesɛa jeddi Umuk ?","2n tarwa","3n tarwa","7n tarwa","4n tarwa",4,Question.LVL_6_6);
        addQuestion(q28_28);
        Question q29_29 = new Question("anwa i d_yeǧǧan jeddi Ilas...?","Anan","adil","Ham","ber",1,Question.LVL_6_6);
        addQuestion(q29_29);
        Question q30_30 = new Question("anwa i d_yeǧǧan At Igujdal...!","atuf","ilan","ber","Aḍil",4,Question.LVL_6_6);
        addQuestion(q30_30);
    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuizContract.QuestionsTable.COLUMN_LVL, question.getLVL());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }
    @SuppressLint("Range")
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setLVL(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_LVL)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }


    @SuppressLint("Range")
    public ArrayList<Question> getQuestions(String LVL) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{LVL};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME +
                " WHERE " + QuizContract.QuestionsTable.COLUMN_LVL + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setLVL(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_LVL)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}