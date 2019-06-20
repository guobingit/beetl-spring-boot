package com.gb.demo.thread;

/**
 * 简单线程测试
 * Created by guobin on 2017/3/2.
 */
public class TicketThread {
	
	class SellTicket implements Runnable {
		
		private int tnum = 10;
		
		@Override
		public void run() {
			for (int i = 0; i < 30; i++) {
				synchronized (this) {
					if (tnum <= 0) {
						return;
					}
					try {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName() + "sell ticket---" + tnum);
						tnum--;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void test() {
		SellTicket s = new SellTicket();
		for (int i = 0; i < 3; i++) {
			new Thread(s).start();
		}
		
	}
	
	public static void main(String[] args) {
		new TicketThread().test();
	}
	
}
