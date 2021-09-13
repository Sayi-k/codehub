package org.core.threads.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(1);
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 4; i++) {
			int num = (int) (Math.random() * 10);
			System.out.println("Factorial to be calcualed : " + num);
			Future<Integer> future = service.submit(new CallableFactorialTest(num));
			futureList.add(future);
		}
		System.out.println("Results are");
		for (Future<Integer> future : futureList) {
			System.out.println(future.get());
		}
		System.out.println("End");
		try {
			throw new Exception();
		} catch (Exception ex) {

		}
	}

}

class CallableFactorialTest implements Callable<Integer> {
	int factNum;
	int result = 1;

	public CallableFactorialTest(int n) {
		factNum = n;
	}

	@Override
	public Integer call() throws Exception {
		if (factNum == 0 || factNum == 1) {
			return result;
		}
		for (int i = 2; i <= factNum; i++) {
			result = result * i;
		}
		Thread.sleep(500);
		return result;
	}

}
