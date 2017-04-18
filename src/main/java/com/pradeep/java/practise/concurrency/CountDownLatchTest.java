package com.pradeep.java.practise.concurrency;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Pradeep
 *
 */
public class CountDownLatchTest {

	private static CountDownLatch latch = new CountDownLatch(3);

	private static final Logger logger = LoggerFactory.getLogger(CountDownLatchTest.class);

	public static void main(String[] args) {

		Thread loggingService = new Thread(new Service(latch), "loggingService");
		Thread auditingService = new Thread(new Service(latch), "auditingService");
		Thread monitoringService = new Thread(new Service(latch), "monitoringService");

		logger.info("main thread is going to start all the threads");

		loggingService.start();
		auditingService.start();
		monitoringService.start();

		try {
			logger.info("main thread calling await()");
			latch.await();
			logger.info("main thread execution finished");
		} catch (InterruptedException e) {
			logger.error("Thread:{} interrupted with exception.", Thread.currentThread().getName(), e.getMessage());
			e.printStackTrace();
		}

	}

}

class Service implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	private CountDownLatch latch;

	public Service(CountDownLatch latch) {
		super();
		logger.info("Service(-) latch: {}", latch);
		this.latch = latch;
	}

	public void run() {
		logger.info("Thread: {} execution started.", Thread.currentThread().getName());

		try {
			Thread.sleep(10000);
			latch.countDown();
			logger.info("Thread: {} execution completed.", Thread.currentThread().getName());

		} catch (InterruptedException e) {
			logger.error("Thread:{} interrupted with exception.", Thread.currentThread().getName(), e.getMessage());
			e.printStackTrace();
		}

	}

}