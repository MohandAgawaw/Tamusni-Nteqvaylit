package com.Tamusni.tamusninteqvaylith;
import android.os.Parcel;
import android.os.Parcelable;
public class Question implements Parcelable {
    public static final String LVL_1_1 = "LVL_1";
    public static final String LVL_2_2 = "LVL_2";
    public static final String LVL_3_3 = "LVL_3";
    public static final String LVL_4_4 = "LVL_4";
    public static final String LVL_5_5 = "LVL_5";
    public static final String LVL_6_6 = "LVL_6";



    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;
    private String LVL;
    public Question(String question, String option1, String option2, String option3, String option4 , int answerNr, String LVL) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.LVL = LVL;
    }
    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        option4 = in.readString();
        answerNr = in.readInt();
        LVL = in.readString();
    }

    public Question() {

    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeString(option4);
        dest.writeInt(answerNr);
        dest.writeString(LVL);
    }

    public int describeContents() {
        return 0;
    }
    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }
        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }
    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getLVL() {
        return LVL;
    }

    public void setLVL(String LVL) {
        this.LVL = LVL;
    }

    public static String[] getAllLvll() {
        return new String[]{
                LVL_1_1,LVL_2_2,LVL_3_3,LVL_4_4,LVL_5_5,LVL_6_6

        };
    }
}