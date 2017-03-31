package threadpool;


public class TestPool {

	public static void main(String[] args) {

		TestPool test = new TestPool();
		ThreadPool tp = ThreadPool.getInstance();
		for(int i =1 ;i<10;i++){
			Task t =test.new Task(i);
			tp.execute(t);
		}
		tp.destroy();
	}
	
	public class Task implements  Runnable {
		public int i = 0;
		public Task(int x) {
			this.i = x;
		}
		public void run() {
			System.out.println(Thread.currentThread().getName()+" "+i);

		}
	}
}
