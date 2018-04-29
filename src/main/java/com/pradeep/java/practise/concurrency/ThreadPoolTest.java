package com.pradeep.java.practise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i = 1; i <= 10; i++){
			Thread workerThread = new Thread(new WorkerThread(),"worker thread"+i);
			executorService.execute(workerThread);
		}

		executorService.shutdown();
		while(!executorService.isTerminated()){
			
		}
		if(executorService.isTerminated()){
			System.out.println("All threads execution completed.");
		}
	}

}

class WorkerThread implements Runnable {

	@Override
	public void run() {
		System.out.println("===="+Thread.currentThread().getName()+" execution started =====");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("===="+Thread.currentThread().getName()+" execution completed =====");
	}
}
