package org.core.design.creational.singleton;

public class SingletonSynch {

	private static SingletonSynch instance = null;

	private SingletonSynch() {
	}

	public static synchronized SingletonSynch getInstance() {
		if (null == instance) {
			instance = new SingletonSynch();
		}
		return instance;
	}
}
