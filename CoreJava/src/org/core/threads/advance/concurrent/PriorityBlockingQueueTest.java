package org.core.threads.advance.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Person> bQueue = new PriorityBlockingQueue<Person>();
		bQueue.add(new Person(33, "Rohan"));
		bQueue.add(new Person(36, "Anshu"));
		bQueue.add(new Person(23, "Sohil"));
		bQueue.add(new Person(43, "Bharat"));
		System.out.println("Accessing queue");
		while (!bQueue.isEmpty()) {
			System.out.println(bQueue.take());
		}
	}
}

class Person implements Comparable<Person> {
	int age;
	String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person person) {
		return this.name.compareTo(person.getName());
	}

	@Override
	public String toString() {
		return this.name + " - " + this.age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
