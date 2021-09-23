package org.core.base.practice;

public class ImmutableTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Dummy dum = new Dummy(20);
		Immutable im = new Immutable(dum);
		dum.val = 40;
		Dummy newDum = im.getDum();
		System.out.println(dum.val);
		System.out.println(newDum.val);
	}
}

final class Immutable {
	private final Dummy dum;
	
	public Dummy getDum() throws CloneNotSupportedException {
		return (Dummy) dum.clone();
	}

	public Immutable(Dummy dum) {
		this.dum = new Dummy(dum.val);
	}
}

class Dummy implements Cloneable{
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	int val;
	
	public Dummy(int val) {
		this.val = val;
	}
}
