package com.company;

public interface ObjectPool<T> {
    T get();

    void release(T obj);
}

