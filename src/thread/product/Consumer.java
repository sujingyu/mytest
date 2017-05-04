package thread.product;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
//	Collection<String> storage ;
	BlockingQueue<String> storage = new ArrayBlockingQueue<>(5);
	public Consumer(Collection<String> l) {
		this.storage = (BlockingQueue<String>) l;
	}
	public void run() {
		consumer2();
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
	
	public void consumer2() {
		try {
			System.out.println("当前库存="+storage.size()+",消费一个。"+storage.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
