package org.core.ds.hashmap;

public class Entry<K, V> {
	K key;
	V value;
	private Entry<K, V> next;
	
	public Entry(K k, V v, Entry<K, V> node) {
		key = k;
		value = v;
		next = node;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}
}
