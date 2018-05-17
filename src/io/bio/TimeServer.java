package io.bio;

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
			while(true){
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
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
