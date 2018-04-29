package com.pradeep.java.practise.concurrency;

class TestJoinMethod1Thread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " : i = " + i);
		}

	}

}

public class TestJoinMethod1 {

	public static void main(String[] args) {
		TestJoinMethod1Thread testJoinMethod1Thread = new TestJoinMethod1Thread();
		
		Thread thread1 = new Thread(testJoinMethod1Thread, "Test Thread1");
		Thread thread2 = new Thread(testJoinMethod1Thread, "Test Thread2");
		Thread thread3 = new Thread(testJoinMethod1Thread, "Test Thread3");
		
		thread1.start();
		try {
			thread1.join();//when thread1 completes its task then thread2 and thread3 starts executing.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		thread3.start();

	}

}
