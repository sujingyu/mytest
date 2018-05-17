package io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {

	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel asocketChannel;
	
	public AsyncTimeServerHandler(int port) {
		this.port = port;
		try {
			asocketChannel = AsynchronousServerSocketChannel.open();
			asocketChannel.bind(new InetSocketAddress(port));
			System.out.println("the server is start in "+port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		latch = new CountDownLatch(1);
		asocketChannel.accept(this,new AcceptCompletionHandler());
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
