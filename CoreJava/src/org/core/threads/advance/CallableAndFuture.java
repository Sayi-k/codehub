package org.core.threads.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processer implements Callable<String> {
	int id;

	public Processer(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return "ID: " + id;
	}

}

public class CallableAndFuture {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Future<String>> futureList = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			futureList.add(service.submit(new Processer(i)));
		}
		
		System.out.println("All tasks got submitted");

		for (Future<String> future : futureList) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Tasks are over!!!");
	}
}
