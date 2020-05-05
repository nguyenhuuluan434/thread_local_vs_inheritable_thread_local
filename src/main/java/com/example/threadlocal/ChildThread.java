package com.example.threadlocal;

public class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println(new StringBuilder(" Child data what resident in thread local: ").append(ThreadLocalUtils.getInstance().getThreadLocal()));
        System.out.println(new StringBuilder(" Child data what resident inheritable thread local : ").append(ThreadLocalUtils.getInstance().getInheritableThreadLocal()));
    }
}
