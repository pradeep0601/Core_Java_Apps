package com.pradeep.java.practise.concurrency;

public class ShutDownHookTest {

	public static void main(String[] args) {
		
		System.out.println("main started execution");
		
		Runtime runtime = Runtime.getRuntime();
		
		runtime.addShutdownHook(new Thread(){
			@Override
			public void run() {
				super.run();
				System.out.println("Thread executed through ShutdownHook");
			}
		});
		
		System.out.println("Main is going to sleep ....press ctrl+c to exit");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
