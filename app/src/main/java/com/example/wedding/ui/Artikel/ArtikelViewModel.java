package com.example.wedding.ui.Artikel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArtikelViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ArtikelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Artikel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}