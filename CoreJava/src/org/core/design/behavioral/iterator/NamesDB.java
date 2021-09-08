package org.core.design.behavioral.iterator;

public class NamesDB {

	public MyIterator getIterator() {
		return new NamesDbIterator();
	}

	String[] names = { "Raj", "Rani", "Rohan", "Roman" };

	private class NamesDbIterator implements MyIterator {
		int index;

		@Override
		public boolean hasNext() {
			return (index < names.length);
		}

		@Override
		public String next() {
			if (this.hasNext()) {
				return names[index++];
			}
			return null;
		}

	}
}
