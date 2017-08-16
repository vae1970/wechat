package com.vae.wechat.test;

public class Alarms {
    public static void main(String[] args) {
        Clock ck = new Clock();
        new XiaoMing(ck);
    }
}

class Clock implements Runnable{
    public Boolean isAlarm;
    public Boolean shutdown;
    public int times;
    public static final int clockMin = 3;

    public Clock() {
        isAlarm = false;
        shutdown = false;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            isAlarm = true;
            times = i+1;
            System.out.println(times + " clock * " + clockMin + " !");
            synchronized (this) {
                notifyAll();
//                System.out.println(times + " clock notify");
                try {
//                    System.out.println(times + " clock wait start");
                    wait(1000 * clockMin);
//                    System.out.println(times + " clock wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        shutdown = true;
        System.out.println("shutdown");
    }
}

class XiaoMing implements Runnable{
    private Clock clk;

    public XiaoMing(Clock clk) {
        this.clk = clk;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true) {
            if (clk.isAlarm) {
                System.out.println(this.clk.times + " close!");
                clk.isAlarm = false;
                synchronized (this.clk) {
                    try {
                        System.out.println(this.clk.times + " wait!");
                        this.clk.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                if(clk.shutdown) {
                    break;
                }
            }
//            if (clk.isAlarm || !clk.isAlarm) {
//
//                System.out.println(this.clk.times + " xiaoming");
//            }
        }
    }
}
