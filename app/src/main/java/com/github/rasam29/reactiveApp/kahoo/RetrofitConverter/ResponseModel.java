package com.github.rasam29.reactiveApp.kahoo.RetrofitConverter;

public class ResponseModel<T> {
    private Throwable throwable;
    private int statusCode;
    private T Data;


    private boolean isSuccessFull;

    public ResponseModel(T data, boolean isSuccessFull) {
        Data = data;
        this.isSuccessFull = isSuccessFull;
    }

    public ResponseModel(Throwable throwable) {
        this.throwable = throwable;
    }

    public ResponseModel(int statusCode, T data) {
        this.statusCode = statusCode;
        Data = data;
    }

    public boolean isSuccessFull() {
        return isSuccessFull;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getData() {
        return Data;
    }
}
