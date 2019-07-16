package com.github.rasam29.reactiveApp.ReactiveKahoo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class KahooActivity<T extends KahooIntent, Y extends KahooBasePresenter> extends AppCompatActivity {
    public Y presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = injectPresenter();
    }


    @Override
    protected void onPause() {
        super.onPause();
        presenter.unsub();
    }

    public abstract Y injectPresenter();
}
