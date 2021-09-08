package org.core.design.structural.adapter;

import org.core.design.structural.adapter.Socket.Volt;

public class SocketAdapter implements AdapterInterface {

	Socket socket = new Socket();
	@Override
	public Volt getVolt120() {
		return socket.getVolt();
	}

	@Override
	public Volt getVolt40() {
		int vol = socket.getVolt().val/3;
		return socket.new Volt(vol);
	}

}
