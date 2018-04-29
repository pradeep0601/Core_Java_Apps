package com.pradeep.java.practise.concurrency;

class TestJoinMethod2Thread implements Runnable {

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

public class TestJoinMethod2 {

	public static void main(String[] args) {
		TestJoinMethod2Thread testJoinMethod2Thread = new TestJoinMethod2Thread();
		
		Thread thread1 = new Thread(testJoinMethod2Thread, "Test Thread1");
		Thread thread2 = new Thread(testJoinMethod2Thread, "Test Thread2");
		Thread thread3 = new Thread(testJoinMethod2Thread, "Test Thread3");
		
		thread1.start();
		try {
			thread1.join(1500);//when thread1 is completes its task for 1500 miliseconds(3 times) then thread2 and thread3 starts executing.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		thread3.start();

	}

}
