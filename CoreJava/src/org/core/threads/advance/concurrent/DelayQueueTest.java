package org.core.threads.advance.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<DelayElement> delayrdQueue = new DelayQueue<>();
		delayrdQueue.put(new DelayElement(4000, "First element"));
		delayrdQueue.put(new DelayElement(3000, "Second element"));
		delayrdQueue.put(new DelayElement(400, "Third element"));
		delayrdQueue.put(new DelayElement(8000, "Fourth element"));
		delayrdQueue.put(new DelayElement(2000, "Fifth element"));
		System.out.println("Accessing Queue");
		while (!delayrdQueue.isEmpty()) {
			System.out.println(delayrdQueue.take());
		}
	}
}

class DelayElement implements Delayed {
	long duration;
	String message;

	public DelayElement(int duration, String message) {
		this.duration = System.currentTimeMillis() + duration;
		this.message = message + " - " + duration;
	}

	@Override
	public int compareTo(Delayed delayed) {
		if (this.duration < ((DelayElement) delayed).getDuration())
			return -1;
		if (this.duration > ((DelayElement) delayed).getDuration())
			return 1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.duration - System.currentTimeMillis(), unit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return this.message + " -- " + (this.duration - System.currentTimeMillis()) / 1000 + "seconds";
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}