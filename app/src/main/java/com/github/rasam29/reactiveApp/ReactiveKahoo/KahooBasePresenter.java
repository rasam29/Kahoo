package com.github.rasam29.reactiveApp.ReactiveKahoo;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class KahooBasePresenter<T extends KahooIntent> {
    private T kahooViewIntent;
    private Disposable disposable;


     void unsub() {
        this.kahooViewIntent = null;

    }

    public void sub(T t) {
        this.kahooViewIntent = t;
         disposable = bindIntent().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(baseState -> {
             if (isAttached()){
                 getView().render(baseState);
             }
         });
    }





    private boolean isAttached() {
        return kahooViewIntent !=null;
    }


    public T getView() {
        return kahooViewIntent;
    }


    public abstract Observable<BaseState> bindIntent();
}
