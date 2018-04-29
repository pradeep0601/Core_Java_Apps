package com.pradeep.java.practise.concurrency;

import java.util.ArrayList;
import java.util.List;

class SharedClass{
	private List<String> data = new ArrayList<>();
	
	public synchronized void writeData(){
		for(int i = 1; i <= 5; i++){
			data.add("data - "+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized List<String> readData(){
		try {
			if(data.size() != 5){
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}	
}

public class ReaderWriter {

	public static void main(String[] args) {
		SharedClass sharedClass = new SharedClass();
		WriterThread writerRunnable = new WriterThread(sharedClass);
		ReaderThread readerRunnable = new ReaderThread(sharedClass);
		
		Thread writerThread = new Thread(writerRunnable, "Writer Thread");
		Thread readerThread1 = new Thread(readerRunnable, "Reader Thread1");
		Thread readerThread2 = new Thread(readerRunnable, "Reader Thread2");
		Thread readerThread3 = new Thread(readerRunnable, "Reader Thread3");
		Thread readerThread4 = new Thread(readerRunnable, "Reader Thread4");
		Thread readerThread5 = new Thread(readerRunnable, "Reader Thread5");
		
		writerThread.start();
		
		readerThread1.start();
		readerThread2.start();
		readerThread3.start();
		readerThread4.start();
		readerThread5.start();
	}

	static class ReaderThread implements Runnable{
		SharedClass sharedClass;
		public ReaderThread(SharedClass sharedClass) {
		this.sharedClass = sharedClass;
		}
		@Override
		public void run() {
			List<String> data = sharedClass.readData();
			System.out.println(Thread.currentThread().getName() +" is executing : data = "+data);
		}
	}
	static class WriterThread implements Runnable{
		SharedClass sharedClass;
		public WriterThread(SharedClass sharedClass) {
		this.sharedClass = sharedClass;
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+" is executing");
			sharedClass.writeData();
		}
	}
}
