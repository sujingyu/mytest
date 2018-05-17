package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.TestPool.Task;

/**
 * 线程池的默认实现
 * @author kingdee
 *
 */
public class DefaultPool {

	//可缓存的线程池 队列只能存放一个任务 但是最大线程数量为无限大
	public static ExecutorService cachePool = Executors.newCachedThreadPool();
	//固定大小的线程池 队列大小为无限大
	public static ExecutorService fixedPool = Executors.newFixedThreadPool(3);
	//固定大小为1的线程池 队列大小为无限大 等同于 newFixedThreadPool(1)
	public static ExecutorService singlePool = Executors.newSingleThreadExecutor();
	//可以执行定时任务的线程池，最大线程数量为无限大
	public static ExecutorService scheduledPool = Executors.newScheduledThreadPool(3);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultPool dp = new DefaultPool();
		ExecutorService fixedPool = Executors.newCachedThreadPool();
		for(int i =1 ;i<10;i++){
			Task t =dp.new Task(i);
			fixedPool.execute(t);
		}
	}
	
	
	public class Task implements  Runnable {
		public int i = 0;
		public Task(int x) {
			this.i = x;
		}
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);

		}
	}
}
