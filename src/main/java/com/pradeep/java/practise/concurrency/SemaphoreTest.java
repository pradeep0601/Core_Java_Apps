package com.pradeep.java.practise.concurrency;

import java.util.concurrent.Semaphore;

class Shared{
	public static int count = 0;
}
class MyThread implements Runnable {

	private Semaphore semaphore;

	public MyThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("A")){
			System.out.println(Thread.currentThread().getName() +" acquiring lock");
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() +" acquired the lock");
				for(int i = 0; i < 5; i++) {
					Shared.count++;
					System.out.println(Thread.currentThread().getName() +" : count : "+Shared.count);
					Thread.sleep(1000);
				}
				System.out.println(Thread.currentThread().getName() +" releasing the lock");
				semaphore.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println(Thread.currentThread().getName() +" acquiring lock");
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() +" acquired the lock");
				for(int i = 0; i < 5; i++) {
					Shared.count--;
					System.out.println(Thread.currentThread().getName() +" : count : "+Shared.count);
					Thread.sleep(1000);
				}
				System.out.println(Thread.currentThread().getName() +" releasing the lock");
				semaphore.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		MyThread myThread1 = new MyThread(semaphore);
		MyThread myThread2 = new MyThread(semaphore);
		Thread thread1 = new Thread(myThread1, "A");
		Thread thread2 = new Thread(myThread2, "B");
		thread1.start();
		thread2.start();

	}

}
