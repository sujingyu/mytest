package thread.product;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	Collection<String> storage ;
	BlockingQueue<String> bstorage;
	boolean runing = true;

	public Consumer(Collection<String> l) {
		this.storage =  l;
	}
	public Consumer(BlockingQueue<String> l) {
		this.bstorage =  l;
	}
	

	public void run() {
		consumer3();
	}
	
	public void consumer1() {
		synchronized (storage) {
			try {
				while(storage.size()<1){
					System.out.println("当前库存="+storage.size()+",消费线程休眠");
					storage.wait();
				}
				System.out.println("当前库存="+storage.size()+",消费一个");
				storage.remove(String.valueOf(storage.size()-1));
				storage.notifyAll();
			} catch (Exception e) {
			}
			
		}
	}
	
	public void consumer2()   {
		try {
			System.out.println("当前库存="+bstorage.size()+",消费一个。"+bstorage.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void consumer3()   {
		try {
			while(runing){
				System.out.println("当前库存="+bstorage.size()+",消费一个。"+bstorage.take());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
