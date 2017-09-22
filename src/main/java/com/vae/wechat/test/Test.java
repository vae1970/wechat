package com.vae.wechat.test;

/**
 * 完成
 */
class MyThread extends Thread{

    String name;
    String name2;
    MyThread next;
    boolean start;

    public MyThread () {

    }
    public MyThread (String name,boolean b) {
        this.name = name;
        this.name2 = name;
        this.start = b;
        this.start();
    }

    public void setNext(MyThread a) {
        this.next = a;
    }

    public void run(){
        if (start) {
            System.out.println("name");
            synchronized (this.name) {
                try {
                    System.out.println("this.name.wait();");
                    this.name.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name+"   finish");
            }
        } else {
            System.out.println("name2");
            synchronized (this.name2) {
                this.name2.notifyAll();
                System.out.println(this.name+"   notifyAll");
            }
        }



    }
}

class Run implements Runnable {

    public Run () {

    }

    @Override
    public void run() {

    }
}

public class Test {
    public static void main(String[] args) {
        String name = "a";
        MyThread myThread1 = new MyThread(name,true);
        MyThread myThread2 = new MyThread(name,true);
        MyThread myThread3 = new MyThread(name,true);
        MyThread myThread4 = new MyThread(name,false);


    }

}
