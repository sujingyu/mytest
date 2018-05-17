package singleton;

/**
 * 双重校验锁
 * @author kingdee
 *
 */
public class SingleTon6 {
	private volatile static SingleTon6 instance;
	
	private SingleTon6(){};
	
	public static SingleTon6 getInstance(){
		if(instance==null){
			synchronized (SingleTon6.class) {
				if(instance==null){
					instance = new SingleTon6();
				}
			}
		}
		return instance;
	}
}
