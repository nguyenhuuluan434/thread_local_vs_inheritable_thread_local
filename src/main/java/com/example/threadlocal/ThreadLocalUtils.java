package com.example.threadlocal;

import java.util.Objects;

public class ThreadLocalUtils<T> {
    private static ThreadLocalUtils INSTANCE = null;

    private ThreadLocal<T> threadLocal = new ThreadLocal<>();
    private ThreadLocal<T> inheritableThreadLocal = new InheritableThreadLocal<>();

    private <T> ThreadLocalUtils() {
    }

    public static <T> ThreadLocalUtils<T> getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (ThreadLocalUtils.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new ThreadLocalUtils();
                }
            }
        }
        return INSTANCE;
    }

    public void setAll(T value) {
        synchronized (ThreadLocalUtils.class) {
            threadLocal.set(value);
            inheritableThreadLocal.set(value);
        }
    }

    public void setThreadLocal(T value) {
        synchronized (threadLocal) {
            threadLocal.set(value);
        }
    }

    public void setInheritableThreadLocal(T value) {
        synchronized (inheritableThreadLocal) {
            inheritableThreadLocal.set(value);
        }
    }

    public T getThreadLocal() {
        return threadLocal.get();
    }

    public T getInheritableThreadLocal() {
        return inheritableThreadLocal.get();
    }

    public void remove() {
        threadLocal.remove();
        inheritableThreadLocal.remove();
    }


}
