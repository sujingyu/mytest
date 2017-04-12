package thread;

import java.util.LinkedList;

public class ProductorConsumerPattern {

	
	public LinkedList<String> storage = new LinkedList<>();
	public Integer max = 10;
	
	public static void main(String[] args) {

		ProductorConsumerPattern p = new ProductorConsumerPattern();
		Productor p1 = p.new Productor(p);
		Productor p2 = p.new Productor(p);
		Productor p3 = p.new Productor(p);
		Productor p4 = p.new Productor(p);
		Productor p5 = p.new Productor(p);
		Productor p6 = p.new Productor(p);
		Consumer c1 = p.new Consumer(p);
		Consumer c2 = p.new Consumer(p);
		Consumer c3 = p.new Consumer(p);
		Consumer c4 = p.new Consumer(p);
		Consumer c5 = p.new Consumer(p);
		Consumer c6 = p.new Consumer(p);
		Consumer c7 = p.new Consumer(p);

		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();
	}
	
	public class Productor extends  Thread {
		ProductorConsumerPattern p ;
		public Productor(ProductorConsumerPattern p) {
			this.p = p;
		}
		public void run() {
			p.produtor();
		}
	}
	
	public class Consumer extends  Thread {
		ProductorConsumerPattern p ;
		public Consumer(ProductorConsumerPattern p) {
			this.p = p;
		}
		public void run() {
			p.consumer();
		}
	}
	
	public void produtor() {
		synchronized (storage) {
			try {
				while(storage.size()>max){
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
	
	public void consumer() {
		synchronized (storage) {
			try {
				while(storage.size()<1){
					System.out.println("当前库存="+storage.size()+",消费线程休眠");
					storage.wait();
				}
				System.out.println("当前库存="+storage.size()+",消费一个");
				storage.removeFirst();
				storage.notifyAll();
			} catch (Exception e) {
			}
			
		}
	}
	
	

}
