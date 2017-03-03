package com.gb.demo.thread;

/**
 * run方法写操作，用start方法启动
 * Created by guobin on 2017/3/2.
 */
public class MyTestThread extends Thread {

    private String name;

    public MyTestThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"*********"+name);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTestThread thread1 = new MyTestThread("线程1");
        MyTestThread thread2 = new MyTestThread("线程2");
        thread1.start();
        thread2.start();

    }
}
