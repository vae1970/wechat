package com.vae.wechat.test;

class MyThread extends Thread{

    String name;
    MyThread next;
    boolean start = false;

    public MyThread () {

    }
    public MyThread (String name) {
        this.name = name;
    }

    public void setNext(MyThread a) {
        this.next = a;
    }

    public void run(){
        start = true;
        if (!this.next.start) {
            synchronized (this.next) {
//                System.out.println(this.name+"   synchronized (this)");
                this.next.start();
            }
        } else {
//            synchronized (this.next) {
//                this.next.notify();
//            }
        }
//        System.out.println(this.name + "----------------------");

        synchronized (this) {
//            try {
                System.out.println("synchronized (this." + this.name + ")");
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}

public class Test {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("a");
        MyThread myThread2 = new MyThread("b");
        MyThread myThread3 = new MyThread("c");
        MyThread myThread4 = new MyThread("d");
        MyThread myThread5 = new MyThread("e");
        MyThread myThread6 = new MyThread("f");
        MyThread myThread7 = new MyThread("g");
        MyThread myThread8 = new MyThread("h");
        myThread1.setNext(myThread2);
        myThread2.setNext(myThread3);
        myThread3.setNext(myThread4);
        myThread4.setNext(myThread5);
        myThread5.setNext(myThread6);
        myThread6.setNext(myThread7);
        myThread7.setNext(myThread8);
        myThread8.setNext(myThread1);
        myThread1.start();

    }

}
