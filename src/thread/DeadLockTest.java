package thread;

public class DeadLockTest {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	
	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
	}

}


 class Thread1 extends Thread{
	@Override
	public void run() {
		synchronized (DeadLockTest.lock1) {
			try {
				System.out.println("Thread1 get lock1,thread1 sleeping");
				sleep(1000);
				System.out.println("Thread1 wake up");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (DeadLockTest.lock2) {
				System.out.println("Thread1 get lock2");
			}
		}
	}
	
}

 class Thread2 extends Thread{
	@Override
	public void run() {
		synchronized (DeadLockTest.lock2) {
			System.out.println("Thread2 get lock2");
			synchronized (DeadLockTest.lock1) {
				System.out.println("Thread2 get lock1");
			}
		}
	}
	
}