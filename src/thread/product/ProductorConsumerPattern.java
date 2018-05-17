package thread.product;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorConsumerPattern {

	public static void main(String[] args) {
		ProductorConsumerPattern p = new ProductorConsumerPattern();
		p.blockCollection();
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
	}
	

	/**
	 * 阻塞队列实现
	 */
	public void blockCollection(){
		BlockingQueue<String> s = new ArrayBlockingQueue<String>(3);
		Productor p1 = new Productor(s);
//		Productor p2 = new Productor(s);
//		Productor p3 = new Productor(s);
		Consumer c1 = new Consumer(s);
//		Consumer c2 = new Consumer(s);
//		Consumer c3 = new Consumer(s);
//		Consumer c4 = new Consumer(s);
//		Consumer c5 = new Consumer(s);
		p1.start();
//		p2.start();
//		p3.start();
		c1.start();
//		c2.start();
//		c3.start();
//		c4.start();
//		c5.start();
	}
	
	/**
	 * 通过wait notifyall实现的
	 */
	public void notifyall(){
		LinkedList<String> s = new LinkedList<>();
		s.add(String.valueOf(s.size()));
		s.add(String.valueOf(s.size()));
		s.add(String.valueOf(s.size()));
		s.add(String.valueOf(s.size()));
		s.add(String.valueOf(s.size()));

		Productor p1 = new Productor(s);
		Productor p2 = new Productor(s);
		Productor p3 = new Productor(s);
		Productor p4 = new Productor(s);
		Productor p5 = new Productor(s);
		Productor p6 = new Productor(s);
		Consumer c1 = new Consumer(s);
		Consumer c2 = new Consumer(s);
		Consumer c3 = new Consumer(s);
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		c3.start();
		
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		
	}
	
}
