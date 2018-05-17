package singleton;

/**
 * 静态内部类
 * @author kingdee
 *
 */
public class SingleTon5 {

	private static class SingleTonHolder{
		private static SingleTon5 instance = new SingleTon5();
	}
	private SingleTon5(){}
	
	public static SingleTon5 getInstance(){
		return SingleTonHolder.instance;
	}
	
}
