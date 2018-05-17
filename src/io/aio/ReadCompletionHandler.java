package io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

import javax.annotation.processing.Completion;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer>{

	private AsynchronousSocketChannel channel;
	
	public ReadCompletionHandler(AsynchronousSocketChannel c) {
		channel = c;
	}
	
	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] body = new byte[attachment.remaining()];
		attachment.get(body);
		try {
			String req = new String(body);
			System.out.println("the timeServer receive order:"+req);
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req)?
					new Date(System.currentTimeMillis()).toString():"BAD ORDER";
			dowrite(currentTime);
		} catch (Exception e) {
		}
		
	}
	
	private void dowrite(String curr){
		byte[] bytes = curr.getBytes();
		ByteBuffer writebuffer = ByteBuffer.allocate(curr.length());
		writebuffer.put(bytes);
		writebuffer.flip();
		channel.write(writebuffer,writebuffer,new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				if(attachment.hasRemaining()){
					channel.write(attachment,attachment,this);
				}
			}
			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
