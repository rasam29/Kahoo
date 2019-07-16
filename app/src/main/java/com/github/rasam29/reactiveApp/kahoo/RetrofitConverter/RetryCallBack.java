package com.github.rasam29.reactiveApp.kahoo.RetrofitConverter;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by R.Arabzadeh on 11/12/2018.
 */

public abstract class RetryCallBack<T> implements Callback<T> {
    private int attempts = 1;
    private Call<T> recentRequest;

    @Override
    public final void onResponse(Call<T> call, Response<T> response) {
        if (onResponseCondittions(response)) {
            attempts = 1;
            onRetryResponse(call, response);
        } else retryRequest(call);
    }

    @Override
    public final void onFailure(Call<T> call, Throwable t) {
        if (!canRequest()) {
            attempts = 1;
            onRetryFailure(call, t);
        } else retryRequest(call);
    }

    private void retryRequest(Call<T> call) {
        attempts = attempts + 1;
        recentRequest = call.clone();
        recentRequest.enqueue(this);


    }

    protected abstract void onRetryResponse(Call<T> call, Response<T> response);

    protected abstract void onRetryFailure(Call<T> call, Throwable t);

    protected int getAttempts() {
        return 5;
    }


    private boolean canRequest() {
        return (attempts < getAttempts());
    }

    protected boolean onResponseCondittions(Response<T> response) {
        return true;
    }

    protected boolean onFailureCondittions(Throwable throwable) {
        return throwable.toString().contains("socket");
    }

}
