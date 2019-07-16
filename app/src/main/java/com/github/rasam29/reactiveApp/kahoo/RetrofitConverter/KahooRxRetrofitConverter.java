package com.github.rasam29.reactiveApp.kahoo.RetrofitConverter;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KahooRxRetrofitConverter<T> {

    public  Single<ResponseModel<T>> getFromCall(Call<T> call){
        return Single.create(emitter -> call.enqueue(new RetryCallBack<T>() {
            @Override
            public void onRetryResponse(Call<T> call1, Response<T> response) {
                emitter.onSuccess(new ResponseModel<>(response.body(),response.isSuccessful()));
            }

            @Override
            public void onRetryFailure(Call<T> call1, Throwable t) {
                emitter.onSuccess(new ResponseModel<>(t));
            }
        }));


    }
}
