package org.core.base.collection;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);
		Map<Integer, String> map = new ConcurrentHashMap<>();
		// Map<Integer, String> map = Collections.synchronizedMap(new
		// HashMap<>());
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			service.submit(new Worker(map, i, latch));
		}
		latch.await();
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}

class Worker implements Runnable {

	Map<Integer, String> map;
	int i;
	CountDownLatch latch;

	public Worker(Map<Integer, String> map, int i, CountDownLatch latch) {
		this.map = map;
		this.i = i;
		this.latch = latch;
	}

	@Override
	public void run() {
		map.put(i, "map" + i);
		latch.countDown();
	}
}
