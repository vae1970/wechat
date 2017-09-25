package com.vae.wechat.test;

import java.util.ArrayList;
import java.util.List;

public class Get implements Runnable{
    private int threadName;
    private static List<Integer> list = null;
    private static int MAX = 100;

    static {
        list = new ArrayList<>();
//        list = new CopyOnWriteArrayList<>();
        for (int i=1; i<MAX+1; i++) {
            list.add(i);
        }
    }

    public Get() {
    }

    public Get(int threadName) {
        this.threadName = threadName;
    }

    private synchronized void get () {
        if (list.size()>0) {
            int lastIndex = list.size()-1;
            System.out.println("thread" + threadName + ": " + list.get(lastIndex));
            list.remove(lastIndex);
        }
    }

    @Override
    public void run() {
        while (list.size() > 0) {
            get();
        }
    }
}

class test {
    public static void main(String[] args) {
        Get get = new Get(1);
        Get get2 = new Get();
        Get get3 = new Get();

        Thread thread1 = new Thread(get);
        Thread thread2 = new Thread(get);
        Thread thread3 = new Thread(get);
        Thread thread4 = new Thread(get);
        Thread thread5 = new Thread(get);
        Thread thread6 = new Thread(get);
        Thread thread7 = new Thread(get);
        Thread thread8 = new Thread(get);
        Thread thread9 = new Thread(get);
        Thread thread10 = new Thread(get2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}

