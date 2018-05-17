package thread.product;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Productor extends Thread {
	Collection<String> storage ;
	BlockingQueue<String> bstorage ;
	boolean runing = true;
	
	public Productor(Collection<String> storage) {
		this.storage = storage;
	}
	
	public Productor(BlockingQueue<String> storage) {
		this.bstorage = storage;
	}
	
	public void run() {
		productor3();
	}
	
	public void productor1() {
		synchronized (storage) {
			try {
				while(storage.size()>3){
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
	
	public void productor2()  {
		try {
			bstorage.put(String.valueOf(bstorage.size()));
			System.out.println("当前库存="+bstorage.size()+",生产一个");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void productor3(){
		try {
			while (runing) {
				System.out.println("生产一个~");
				bstorage.put("abc");
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
