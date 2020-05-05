package com.example.threadlocal;

public class Example {
}


class Worker implements Runnable {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(new StringBuilder(name).append(" - ").toString());
    }
}

class Context<T> {
    private final ThreadLocal<T> data;

    public Context(ThreadLocalType type) {
        if (type.equals(ThreadLocalType.Inheritable))
            data = new InheritableThreadLocal<>();
        else
            data = new ThreadLocal<>();
    }

    public T get() {
        return data.get();
    }

    public void set(T value) {
        data.set(value);
    }
}

enum ThreadLocalType {
    Normal(),
    Inheritable();

    ThreadLocalType() {
    }
}