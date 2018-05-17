package io.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExecutePool {
	
	private ExecutorService executor;
	
	public TimeServerHandlerExecutePool(int maxpoolsize,int queueSize) {
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 
				maxpoolsize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
	} 
	
	public void execute(Runnable task){
		executor.execute(task);
	}
}
