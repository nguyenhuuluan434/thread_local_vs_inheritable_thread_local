package com.example.threadlocal;

public class main {
    //the thead run main function what will be parent thread
    //
    public static void main(String[] args) {
        ThreadLocalUtils.<String>getInstance().setAll("This data will set all two type");
        System.out.println(new StringBuilder(" Parent data what resident in thread local: ").append(ThreadLocalUtils.getInstance().getThreadLocal()));
        System.out.println(new StringBuilder(" Parent data what resident inheritable thread local : ").append(ThreadLocalUtils.getInstance().getInheritableThreadLocal()));
        System.out.println("##########################");
        ChildThread childThread = new ChildThread();
        childThread.start();

    }
}
