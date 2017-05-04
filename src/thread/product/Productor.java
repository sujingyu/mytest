package thread.product;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class Productor extends Thread {
//	Collection<String> storage ;
	BlockingQueue<String> storage;
	
	public void produtor1() {
		synchronized (storage) {
			try {
				while(storage.size()>10){
					System.out.println("当前库存="+storage.size()+",生产线程休眠");
					storage.wait();
				}
				System.out.println("当前库存="+storage.size()+",生产一个");
				int size = storage.size();
				storage.add(String.valueOf(size));
			} catch (Exception e) {
			}
			storage.notifyAll();
		}
	}
	
	public void produtor2() throws Exception {
		System.out.println("当前库存="+storage.size()+",生产一个");
		storage.put("abcd");
	}
	
	public Productor(Collection<String> storage) {
		this.storage = (BlockingQueue<String>) storage;
	}
	
	public void run() {
		try {
			produtor2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
