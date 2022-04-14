package com.Tamusni.tamusninteqvaylith.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("SIWḌED AWAL-IK");
    }

    public LiveData<String> getText() {
        return mText;
    }
}