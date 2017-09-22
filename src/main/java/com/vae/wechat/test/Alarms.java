package com.vae.wechat.test;

/**
 * 已完成
 */
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
    public static final int clockMin = 1;

    public Clock() {
        isAlarm = false;
        shutdown = false;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            isAlarm = true;
            System.out.println("Get up * 3 !");
            synchronized (this) {
                notifyAll();
                try {
                    wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        shutdown = true;
        /**
         * 需要在第十一次唤醒xiaoming让其break出去，不然xiaoming将一直停留在第十次的等待中
         */
        synchronized (this) {
            notifyAll();
        }
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
                System.out.println("Woshixiaoming!");
                clk.isAlarm = false;
                synchronized (this.clk) {
                    try {
                        this.clk.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                if(clk.shutdown)    break;
            }
        }
    }
}
