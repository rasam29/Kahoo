package com.github.rasam29.reactiveApp.kahoo;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.github.rasam29.reactiveApp.kahoo.editText.BeforeTextModel;
import com.github.rasam29.reactiveApp.kahoo.editText.ISPTextWatcher;
import com.github.rasam29.reactiveApp.kahoo.editText.OnTextModel;

import io.reactivex.Observable;

public class KahooViewBindings {

    public static Observable<View> onClick(final View view) {
        return Observable.create(emitter -> {
            view.setOnClickListener(emitter::onNext);
        });


    }

    public static Observable<Boolean> onLongClick(View view) {

        return Observable.create(emitter -> {
            view.setOnLongClickListener(v -> {
                emitter.onNext(true);

                return true;
            });
        });
    }

    public static Observable<OnTextModel> setTextChange(EditText editText) {
        return Observable.create(emitter -> editText.addTextChangedListener(new ISPTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emitter.onNext(new OnTextModel(s, start, before, count));
            }
        }));
    }

    public static Observable<BeforeTextModel> setBeforeTextChange(EditText editText) {
        return Observable.create(emitter -> editText.addTextChangedListener(new ISPTextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                emitter.onNext(new BeforeTextModel(s, start, count, after));
            }
        }));
    }

    public static Observable<Editable> setAfterTextChange(EditText editText) {
        return Observable.create(emitter -> editText.addTextChangedListener(new ISPTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                emitter.onNext(s);
            }
        }));
    }


}
