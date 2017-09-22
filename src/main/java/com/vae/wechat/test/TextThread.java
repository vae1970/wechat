package com.vae.wechat.test;

public class TextThread
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO 自动生成方法存根
        TxtThread tt1 = new TxtThread();
        TxtThread tt2 = new TxtThread();
        TxtThread tt3 = new TxtThread();
        TxtThread tt4 = new TxtThread();

        tt4 = tt3 = tt2 = tt1;

        new Thread(tt1).start();
        new Thread(tt2).start();
        new Thread(tt3).start();
        new Thread(tt4).start();
    }
}
class TxtThread implements Runnable
{
    int num = 100;
    String str = new String();
    public void run()
    {
        while (true)
        {
            synchronized(str)
            {
                if (num>0)
                {
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch(Exception e)
                    {
                        e.getMessage();
                    }
                    System.out.println(Thread.currentThread().getName()+ "this is "+ num--);
                }
            }
        }
    }
}
