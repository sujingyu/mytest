package io.threadpool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;
	
	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String currentTime = null;
			String body = null;
			while(true){
				body = in.readLine();
				if(body == null){
					break;
				}
				System.out.println("the timeServer receive order :"+body);
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
				out.println(currentTime);
				
			}
		} catch (Exception e) {
			if(in != null){
				try {
					in.close();
					in = null;
				} catch (Exception e2) {
				}
			}
			if(out!=null){
				try {
					out.close();
					out = null;
				} catch (Exception e2) {
				}
			}
			if(this.socket!=null){
				try {
					this.socket.close();
					this.socket = null;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
	}

}
