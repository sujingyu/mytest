package thread;

import java.util.ArrayList;
import java.util.List;


/**
 * 实现一个简单的线程池实例
 * @author kingdee
 *
 */
public class ThreadPool {
	
	public static ThreadPool instance = new ThreadPool(5);//线程池实例
	public int core = 5;//核心池的大小
	public workThread[] works = null;//工作线程
	public List<Runnable> tasks = new ArrayList<>();//任务队列
	
	public ThreadPool(int num){//初始化线程池
		this.core = num;
		works = new workThread[num];
		for(int i=0;i<core;i++){
			works[i] = new workThread();
			works[i].start();
		}
	}
	
	public static ThreadPool getInstance(){//获得线程池实例
		return instance;
	}
	
	public void execute(Runnable r){//向线程池提交任务
		synchronized (tasks) {
			tasks.add(r);
			tasks.notify();
		}
	}
	
	public void destroy(){
		try {
			while(tasks!=null){
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			
		}
		for(int i=0;i<core;i++){
			works[i].shutdown();
			works[i]=null;
		}
		instance =null;
	}
	
	public class workThread extends Thread{
		private boolean isrunning = true;
		@Override
		public void run() {
			Runnable r = null;
			while(isrunning){
				synchronized (tasks) {
					try {
						while(isrunning&&tasks.isEmpty()){
							tasks.wait();
						}
						if(!tasks.isEmpty()){
							r = tasks.remove(0);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				r.run();
				r = null;
			}
		}
		public void shutdown(){
			isrunning = false;
		}
	}
}
