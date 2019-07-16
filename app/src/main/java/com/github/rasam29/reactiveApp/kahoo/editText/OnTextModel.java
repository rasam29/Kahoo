package com.github.rasam29.reactiveApp.kahoo.editText;

public class OnTextModel {
    private CharSequence s;
    private int start;
    private int count;
    private int after;

    public OnTextModel(CharSequence s, int start, int count, int after) {
        this.s = s;
        this.start = start;
        this.count = count;
        this.after = after;
    }

    public CharSequence getS() {
        return s;
    }

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public int getAfter() {
        return after;
    }
}
