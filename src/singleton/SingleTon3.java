package singleton;

/**
 * 懒汉 全局线程安全
 * @author kingdee
 *
 */
public class SingleTon3 {

	private static SingleTon3 instance;
	private SingleTon3(){}
	
	public static synchronized SingleTon3 getInstance(){
		if(instance==null){
			instance = new SingleTon3();
		}
		return instance;
	}
}
