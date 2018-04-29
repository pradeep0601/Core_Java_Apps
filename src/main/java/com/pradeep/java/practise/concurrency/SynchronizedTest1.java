package com.pradeep.java.practise.concurrency;

class Table {

	public synchronized void printTable(int number) {

		System.out.println("======"+Thread.currentThread().getName()+"==============");
		for (int i = 1; i <= 10; i++) {
			System.out.println(number + "*" + i + " = " + number * i);
		}
	}

}

class FirstThread implements Runnable {

	Table table;

	public FirstThread(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		table.printTable(5);

	}

}

class SecondThread implements Runnable {

	Table table;

	public SecondThread(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		table.printTable(10);

	}

}

public class SynchronizedTest1 {

	public static void main(String[] args) {

		Table table = new Table();
		
		Thread thread1 = new Thread(new FirstThread(table), "First Thread");
		
		Thread thread2 = new Thread(new SecondThread(table), "Second Thread");
		
		thread1.start();
		thread2.start();
	}

}
