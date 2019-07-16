package com.github.rasam29.reactiveApp.kahoo.editText;

import android.text.Editable;
import android.text.TextWatcher;

import io.reactivex.ObservableEmitter;

public abstract class ISPTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }




}
