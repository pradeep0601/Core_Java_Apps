package com.pradeep.java.practise.concurrency;

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" execution started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" execution completed");
	}
	
}
public class ThreadGroupTest {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("Thread Group - A");
		Thread t1 = new Thread(tg, new MyRunnable(), "Thread - one");
		Thread t2 = new Thread(tg, new MyRunnable(), "Thread - two");
		Thread t3 = new Thread(tg, new MyRunnable(), "Thread - three");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Thread group name : "+tg.getName());
		//tg.interrupt();
		
		tg.list();

	}

}
