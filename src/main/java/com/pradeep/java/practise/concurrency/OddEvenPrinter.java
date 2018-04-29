package com.pradeep.java.practise.concurrency;

class Printer {

	private int data = 1;

	public synchronized void printOdd() throws InterruptedException {
		if (data % 2 != 0) {
			System.out.println(Thread.currentThread().getName() + " : data : " + data);
			data++;
			notify();
		}else{
			notify();
			wait();
		}
	}

	public synchronized void printEven() throws InterruptedException {
		if (data % 2 == 0) {
			System.out.println(Thread.currentThread().getName() + " : data : " + data);
			data++;
			notify();
		}else{
			notify();
			wait();
		}
	}
}

public class OddEvenPrinter {

	public static void main(String[] args) {
		Printer printer = new Printer();
		OddPrinter oddPrinter = new OddPrinter(printer);
		EvenPrinter evenPrinter = new EvenPrinter(printer);

		Thread oddThread = new Thread(oddPrinter, "Odd Printer");
		Thread evenThread = new Thread(evenPrinter, "Even Printer");

		oddThread.start();
		evenThread.start();

	}

	static class OddPrinter implements Runnable {
		private Printer printer;

		public OddPrinter(Printer printer) {
			this.printer = printer;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				try {
					printer.printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class EvenPrinter implements Runnable {
		private Printer printer;

		public EvenPrinter(Printer printer) {
			this.printer = printer;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				try {
					printer.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
