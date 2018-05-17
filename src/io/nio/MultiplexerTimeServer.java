package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable{

	private Selector selector;
	private ServerSocketChannel servChannel;
	private volatile boolean stop;
	
	public MultiplexerTimeServer(int port) {
		try {
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress("127.0.0.1",port),1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("the timeServer is start in port 8080");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void stop(){
		this.stop = true;
	}

	@Override
	public void run() {
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
			} catch (IOException e) {
				e.printStackTrace();
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
	
	
	
	private void handleInput(SelectionKey key) throws Exception{
		if(key.isValid()){
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readbuffer = ByteBuffer.allocate(1024);
				int readByte = sc.read(readbuffer);
				if(readByte>0){
					readbuffer.flip();
					byte[] bytes = new byte[readbuffer.remaining()];
					readbuffer.get(bytes);
					String body = new String(bytes);
					System.out.println("the timeServer receive order:"+body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?
							new Date(System.currentTimeMillis()).toString():"BAD ORDER";
					dowrite(sc, currentTime);
				}
			}
		}
		
	}
	
	private void dowrite(SocketChannel channel,String response) throws IOException{
		byte[] respByte = response.getBytes();
		ByteBuffer writebuffer = ByteBuffer.allocate(respByte.length);
		writebuffer.put(respByte);
		writebuffer.flip();
		channel.write(writebuffer);
	}
}
