package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	public TimeClientHandle(String host,int port) {
		try {
			this.host = host;
			this.port = port;
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		try {
			if(socketChannel.connect(new InetSocketAddress(host, port))){
				socketChannel.register(selector, SelectionKey.OP_READ);
				doWriter(socketChannel);
			}else{
				socketChannel.register(selector, SelectionKey.OP_CONNECT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(!stop){
			try {
				selector.select(1000);
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						e.printStackTrace();
						if(key!=null){
							key.cancel();
							if(key.channel()!=null){
								key.channel().close();
							}
						}
					}
				}
			} catch (Exception e) {
			}
		}
		if(selector!=null){
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private void doWriter(SocketChannel sc)throws Exception{
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writerBuffer = ByteBuffer.allocate(req.length);
		writerBuffer.put(req);
		writerBuffer.flip();
		sc.write(writerBuffer);
		if(!writerBuffer.hasRemaining()){
			System.out.println("send order 2 server succeed");
		}
	}

	
	private void handleInput(SelectionKey key) throws Exception{
		if(key.isValid()){
			SocketChannel sc = (SocketChannel) key.channel();
			if(key.isConnectable()){
				if(sc.finishConnect()){
					sc.register(selector, SelectionKey.OP_READ);
					doWriter(sc);
				}
				if(key.isReadable()){
					ByteBuffer readbuffer = ByteBuffer.allocate(1024);
					int readByte = sc.read(readbuffer);
					if(readByte>0){
						readbuffer.flip();
						byte[] bytes = new byte[readbuffer.remaining()];
						readbuffer.get(bytes);
						String body = new String(bytes);
						System.out.println("now is:"+body);
						this.stop = true;
					}else{
						key.cancel();
						sc.close();
					}
				}
			}
		}
		
	}
}
