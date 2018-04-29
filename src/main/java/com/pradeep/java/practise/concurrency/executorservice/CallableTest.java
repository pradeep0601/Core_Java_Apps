package com.pradeep.java.practise.concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//testCallableSubmit(executorService);
		testCallableInvokeAny(executorService);
		testCallableInvokeAll(executorService);
		executorService.shutdown();
	}
	
	public static void testCallableSubmit(ExecutorService executorService) throws InterruptedException, ExecutionException{
		Future<String> future = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Asynchronous Callable");
				for(int i = 0; i < 100; i++){
					System.out.println(Thread.currentThread().getName()+" : i = "+i);
				}
				return "Callable Result";
			}
		});

		System.out.println("====After Callable=====");
		System.out.println("future.get() = "+future.get());
		System.out.println("====After future get=====");

	}
	
	public static void testCallableInvokeAny(ExecutorService executorService) throws InterruptedException, ExecutionException{
	
		List<Callable<String>> callables = new ArrayList<>();
		
		Callable<String> callable1 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable1";
			}
		};
		Callable<String> callable2 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable2";
			}
		};
		Callable<String> callable3 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable3";
			}
		};
		Callable<String> callable4 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable4";
			}
		};

		Callable<String> callable5 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable5";
			}
		};

		callables.add(callable1);
		callables.add(callable2);
		callables.add(callable3);
		callables.add(callable4);
		callables.add(callable5);
		
		String result = executorService.invokeAny(callables);
		
		System.out.println("==invokeAny(-) result = "+result);
	}

	public static void testCallableInvokeAll(ExecutorService executorService) throws InterruptedException, ExecutionException{
		
		List<Callable<String>> callables = new ArrayList<>();
		
		Callable<String> callable1 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable1";
			}
		};
		Callable<String> callable2 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable2";
			}
		};
		Callable<String> callable3 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable3";
			}
		};
		Callable<String> callable4 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable4";
			}
		};

		Callable<String> callable5 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Callable5";
			}
		};

		callables.add(callable1);
		callables.add(callable2);
		callables.add(callable3);
		callables.add(callable4);
		callables.add(callable5);
		
		List<Future<String>> futures = executorService.invokeAll(callables);
		
		System.out.println("===InvokeAll(-) result : ");
		for(Future<String> future : futures){
			System.out.println(future.get());
		}
	}
	}