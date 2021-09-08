package org.core.design.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	public static void main(String[] args) {
		Runnable task = () ->{
			System.out.println(SingletonSynch.getInstance());
			System.out.println(SingletonInnerClass.getInstance());
		};
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i =0; i< 10; i++) {
			service.submit(task);
		}
		service.shutdownNow();
	}

}
