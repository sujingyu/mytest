package io.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
	public static void main(String[] args) throws IOException  {
		Integer port = 8080;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("the timeServer is start in port 8080");
			Socket socket = null;
			TimeServerHandlerExecutePool executor = new TimeServerHandlerExecutePool(50, 10000);
			while(true){
				socket = server.accept();
				executor.execute(new TimeServerHandler(socket));
			}
		} finally {
			if(server!=null){
				System.out.println("the timeServer close");
				server.close();
				server =null;
			}
		}
		
	}
}
