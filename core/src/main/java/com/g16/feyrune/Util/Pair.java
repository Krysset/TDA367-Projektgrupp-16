package com.g16.feyrune.Util;

public class Pair <T, N>{
    public final T fst;
    public final N snd;

    public Pair(T fst, N snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public T getFst() {
        return fst;
    }

    public N getSnd() {
        return snd;
    }
}
