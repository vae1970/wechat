package com.vae.wechat.test;

/**
 * 完成
 */
class Sequence {
    private int num=1;
    public  int getNext() {
        return num++;
    }
}

class SequenceThread extends Thread {
    private Sequence sequence;
    private int order;
    private SequenceThread next;
    public boolean started=false;
    public SequenceThread(String name,int or,Sequence se){
        this.setName(name);
        this.sequence=se;
        this.order=or;
    }
    public void setNext(SequenceThread next){
        this.next=next;
    }
    public void run(){
        int num=sequence.getNext();
        this.started=true;
        while(num<11){
            if(num%4==order){
                System.out.printf(getName() + ":" + num);
                if(this.next.started){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    synchronized (this.next) {
                        this.next.notify();
                        System.out.println("\t\t\t"+ this.getName() + " this.next.notify();");
                    }
                }else{
                    this.next.start();
                    System.out.println("\t\t\t"+ this.getName() + " this.next.start();");
                }
                System.out.println("be   " + getName() + ":" + num);
//                if(num%4==1){
//                    try {
//                        Thread.sleep(4000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else if(num%4==2){
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else if(num%4==3){
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else if(num%4==0){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                try {
                    synchronized (this) {
                        System.out.println("\t\t\t"+ this.getName() + " this.wait();");
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("af   " + getName() + ":" + num);
                num=sequence.getNext();
            }
            //
        }
        System.exit(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Sequence sequ=new Sequence();
        SequenceThread a=new SequenceThread("A",1,sequ);
        SequenceThread b=new SequenceThread("B",2,sequ);
        SequenceThread c=new SequenceThread("C",3,sequ);
        SequenceThread d=new SequenceThread("D",0,sequ);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(a);
        a.start();
    }
}