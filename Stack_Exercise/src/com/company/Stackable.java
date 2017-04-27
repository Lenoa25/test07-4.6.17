package com.company;

/**
 * Created by hackeru on 2/21/2017.
 */
public interface Stackable<T> {
    T pop();
    boolean push(T t);
    boolean isEmpty();
}
