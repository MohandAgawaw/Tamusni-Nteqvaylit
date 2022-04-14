package com.Tamusni.tamusninteqvaylith;

import android.os.Parcel;
import android.os.Parcelable;

public class Questionnn implements Parcelable {
    public static final String LVL_1_1 = "LVL_1";
    public static final String LVL_2_2 = "LVL_2";
    public static final String LVL_3_3 = "LVL_3";
    public static final String LVL_4_4 = "LVL_4";
    public static final String LVL_5_5 = "LVL_5";

    private String questionnn;
    private String pic;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;
    private String LVL;

    public Questionnn(String questionnn,String pic, String option1, String option2, String option3,String option4, int answerNr, String LVL) {
        this.questionnn = questionnn;
        this.pic = pic;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.LVL = LVL;
    }

    protected Questionnn(Parcel in) {
        questionnn = in.readString();
        pic = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        option4 = in.readString();
        answerNr = in.readInt();
        LVL = in.readString();
    }

    public Questionnn() {

    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionnn);
        dest.writeString(pic);
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
    public static final Parcelable.Creator<Questionnn> CREATOR = new Parcelable.Creator<Questionnn>() {
        @Override
        public Questionnn createFromParcel(Parcel in) {
            return new Questionnn(in);
        }
        @Override
        public Questionnn[] newArray(int size) {
            return new Questionnn[size];
        }
    };
    public String getQuestionnn() {
        return questionnn;
    }
    public void setQuestionnn(String questionnn) {
        this.questionnn = questionnn;
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
    public int getAnswerNr() {
        return answerNr;
    }
    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getPic() {
        return pic;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLVL() {
        return LVL;
    }

    public void setLVL(String LVL) {
        this.LVL = LVL;
    }

    public static String[] getLvll() {
        return new String[]{
                LVL_1_1,LVL_2_2,LVL_3_3,LVL_4_4,LVL_5_5

        };
    }


}
